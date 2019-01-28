package com.bbs.privatemsg.service.impl;

import com.bbs.domain.PrivateMessageVo;
import com.bbs.domain.User1;
import com.bbs.privatemsg.mapper.SelectMessageMapper;
import com.bbs.privatemsg.mapper.SendMessageMapper;
import com.bbs.privatemsg.service.SelectMessageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TreeMap;

/**
 * 接收帖子投诉数据访问层
 *
 * @author chenhuayang
 */
@Service
public class SelectMessageServiceImpl implements SelectMessageService {
    @Autowired
    private SelectMessageMapper selectMessageMapper;
    @Autowired
    private SendMessageMapper sendMessageMapper;

    @Override
    public void getNewMessageCount(HttpServletRequest request) {
        HttpSession sessions = request.getSession();
        if (null != sessions.getAttribute("user1")) {
            User1 user1 = (User1) sessions.getAttribute("user1");
            String account = user1.getAccount();
            int newMessage = selectMessageMapper.getNewMessageCount(account);
            HttpSession session = request.getSession();
            session.setAttribute("newMessage", newMessage);
        }
    }

    @Override
    public Page<PrivateMessageVo> getMessageList(String receivePersonAccount, Integer messageStatus, Integer currentPage, Integer pageSize) {
        Page<PrivateMessageVo> page = PageHelper.startPage(currentPage, pageSize);
        Map<String, Object> map = new TreeMap<>();
        map.put("receivePersonAccount", receivePersonAccount);
        sendMessageMapper.updateUser((short) 0, receivePersonAccount);
        String status = null;
        switch (messageStatus) {
            case 0:
                status = "未读";
                break;
            case 1:
                status = "已读";
                break;
            case 2:
                status = "回收站状态";
                break;
            default:
                break;
        }
        map.put("messageStatus", status);
        selectMessageMapper.getMessageList(map);
        return page;
    }

    @Override
    public void updateMessage(PrivateMessageVo privateMessageVo) {
        selectMessageMapper.updateMessage(privateMessageVo);
    }

    @Override
    public PrivateMessageVo getMessageByCode(String code) {
        return selectMessageMapper.getMessageByCode(code);
    }
}