package com.bbs.privateMessage.controller;

import com.bbs.domain.PrivateMessageVo;
import com.bbs.domain.User1;
import com.bbs.privateMessage.service.SelectMessageService;
import com.bbs.utils.IpUtil;
import com.bbs.utils.RSAUtils;
import com.github.pagehelper.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 用户获取私信控制层
 *
 * @author chenhuayang
 * @version 2018/11/01
 */
@RestController
@RequestMapping(value = "/selectMessage")
public class SelectMessageController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private SelectMessageService selectMessageService;

    @RequestMapping(value = "/selectMessage")
    public ModelAndView getMessageList(String recievePersonAccount, HttpServletRequest request, Integer messageStatus, Integer currentPage) throws IOException {
        selectMessageService.getNewMessageCount(request);
        ModelAndView selectPrivateMessageByUnread = new ModelAndView();
        HttpSession session = request.getSession();
        User1 user1 = (User1) session.getAttribute("user1");
        recievePersonAccount = user1.getAccount();
        /*String ipAddress = IpUtil.getIpAddr(request);
        System.err.println(ipAddress);*/
        if (currentPage == null) {
            currentPage = 1;
        }
        if (messageStatus == null) {
            messageStatus = -1;
        }
        Integer pageSize = 10;
        Page<Object> privateMessage = selectMessageService.getMessageList(recievePersonAccount, messageStatus, currentPage, pageSize);
        HttpSession messageStatusSession = request.getSession();
        messageStatusSession.setAttribute("messageStatus", messageStatus);
        privateMessage.forEach(p -> {
            /*try {
                p.setMessage(RSAUtils.decode(p.getMessage(), RSAUtils.getPrivateKey(p.getPrivateKey())));
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        });
        selectPrivateMessageByUnread.setViewName("privateMessage/selectMessage");
        selectPrivateMessageByUnread.addObject("message", privateMessage);
        return selectPrivateMessageByUnread;
    }

    @RequestMapping(value = "/updateMessage")
    public void updateMessage(HttpServletRequest request, PrivateMessageVo privateMessageVo) {
        HttpSession session = request.getSession();
        User1 user1 = (User1) session.getAttribute("user1");
        privateMessageVo.setModifyBy(user1.getAccount());
        selectMessageService.updateMessage(privateMessageVo);
    }

    @RequestMapping(value = "/getMessageByCode")
    public ModelAndView getMessageByCode(HttpServletRequest request, String code) throws Exception {
        ModelAndView selectPrivateMessageByCode = new ModelAndView();
        PrivateMessageVo privateMessage = selectMessageService.getMessageByCode(code);
        privateMessage.setMessage(RSAUtils.decode(privateMessage.getMessage(), RSAUtils.getPrivateKey(privateMessage.getPrivateKey())));
        selectPrivateMessageByCode.setViewName("privateMessage/selectMessageDetail");
        selectPrivateMessageByCode.addObject("messageDetail", privateMessage);
        if ("未读".equals(privateMessage.getMessageStatus())) {
            HttpSession session = request.getSession();
            User1 user1 = (User1) session.getAttribute("user1");
            PrivateMessageVo privateMessageVo = new PrivateMessageVo();
            privateMessageVo.setCode(code);
            privateMessageVo.setMessageStatus("已读");
            privateMessageVo.setModifyBy(user1.getAccount());
            selectMessageService.updateMessage(privateMessageVo);
        }
        return selectPrivateMessageByCode;
    }
}