package com.bbs.privateMessage.controller;

import com.bbs.domain.PostVo;
import com.bbs.domain.PrivateMessageVo;
import com.bbs.privateMessage.service.SendMessageService;
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
            privateMessageVo.setMessage(RSAUtils.encode(privateMessageVo.getMessage(), getPublicKey));
            privateMessageVo.setPrivateKey(keyPair.getPrivateKey());
            sendMessageService.savePrivateMessage(privateMessageVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取帖子信息，传送到前端
     *
     * @author chenhuayang
     * @version 2018/10/19
     */
    @RequestMapping(value = "/sendPrivateMessage")
    public ModelAndView sendPrivateMessage(String code) {
        try {
            ModelAndView sendPrivateMessage = new ModelAndView();
            PostVo postInfo = sendMessageService.postInfo(code);
            sendPrivateMessage.setViewName("privateMessage/sendMessageFromPost");
            sendPrivateMessage.addObject("postInfo", postInfo);
            return sendPrivateMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}