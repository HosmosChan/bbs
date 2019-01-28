package com.bbs.privatemsg.controller;

import com.bbs.domain.PostVo;
import com.bbs.domain.PrivateMessageVo;
import com.bbs.privatemsg.service.SendMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.bbs.utils.RSAUtils;

import java.security.interfaces.RSAPublicKey;

/**
 * 用户发送私信控制层
 *
 * @author chenhuayang
 * @version 2018/10/19
 */
@Controller
@RequestMapping(value = "/sendMessage")
public class SendMessageController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private SendMessageService sendMessageService;

    /**
     * 保存私信信息并对私信信息进行RSA加密
     *
     * @author chenhuayang
     * @version 2018/10/19
     */
    @ResponseBody
    @RequestMapping(value = "/savePrivateMessage")
    public void savePrivateMessage(PrivateMessageVo privateMessageVo) {
        try {
            RSAUtils.RsaKeyPair keyPair = RSAUtils.generaterKeyPair();
            String publicKey = keyPair.getPublicKey();
            RSAPublicKey getPublicKey = RSAUtils.getPublicKey(publicKey);
            privateMessageVo.setMessage(privateMessageVo.getMessage().replace("\r", " ").replace("\n", " ").replace("\t", " ").replace("\f", " ").replace("\b", " "));
            privateMessageVo.setMessage(RSAUtils.encode(privateMessageVo.getMessage(), getPublicKey));
            privateMessageVo.setPrivateKey(keyPair.getPrivateKey());
            sendMessageService.savePrivateMessage(privateMessageVo);
        } catch (Exception e) {
            logger.info(e);
        }
    }

    /**
     * 获取私信信息，传送到前端
     *
     * @author chenhuayang
     * @version 2018/10/19
     */
    @RequestMapping(value = "/sendPrivateMessage")
    public ModelAndView sendPrivateMessage(String code, String replyMessage) {
        try {
            ModelAndView sendPrivateMessage = new ModelAndView();
            PostVo postInfo = sendMessageService.postInfo(code);
            sendPrivateMessage.setViewName("privateMessage/sendMessageFromPost");
            if(replyMessage != null) {
                replyMessage = "Re：[" + replyMessage + "]\n------------------回复-------------------\n";
                sendPrivateMessage.addObject("replyMessage", replyMessage);
            }
            sendPrivateMessage.addObject("postInfo", postInfo);
            return sendPrivateMessage;
        } catch (Exception e) {
            logger.info(e);
            throw e;
        }
    }
}