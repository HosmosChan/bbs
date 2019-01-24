package com.bbs.privateMessage.service.impl;

import com.bbs.domain.PostVo;
import com.bbs.domain.PrivateMessageVo;
import com.bbs.privateMessage.mapper.SendMessageMapper;
import com.bbs.privateMessage.service.SendMessageService;
import com.bbs.utils.GETuuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SendMessageServiceImpl implements SendMessageService {
    @Autowired
    private SendMessageMapper sendMessageMapper;

    /**
     * 提交私信信息数据访问层
     *
     * @author chenhuayang
     * @version 2018/10/19
     */
    @Override
    public void savePrivateMessage(PrivateMessageVo privateMessageVo) {
        privateMessageVo.setMessageStatus("未读");
        privateMessageVo.setCreateBy(privateMessageVo.getSendPersonAccount());
        privateMessageVo.setCode(GETuuid.getUUID());
        sendMessageMapper.savePrivateMessage(privateMessageVo);
        sendMessageMapper.updateUser((short) 1, privateMessageVo.getRecievePersonAccount());
    }

    /**
     * 私信获取帖子信息数据访问层
     *
     * @author chenhuayang
     * @version 2018/10/19
     */
    @Override
    public PostVo postInfo(String code) {
        PostVo postInfo = sendMessageMapper.postInfo(code);
        return postInfo;
    }
}