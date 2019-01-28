package com.bbs.privatemsg.service.impl;

import com.bbs.domain.PostVo;
import com.bbs.domain.PrivateMessageVo;
import com.bbs.privatemsg.mapper.SendMessageMapper;
import com.bbs.privatemsg.service.SendMessageService;
import com.bbs.utils.GETuuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发送帖子投诉数据访问层
 *
 * @author chenhuayang
 */
@Service
public class SendMessageServiceImpl implements SendMessageService {
    @Autowired
    private SendMessageMapper sendMessageMapper;

    @Override
    public void savePrivateMessage(PrivateMessageVo privateMessageVo) {
        privateMessageVo.setMessageStatus("未读");
        privateMessageVo.setCreateBy(privateMessageVo.getSendPersonAccount());
        privateMessageVo.setCode(GETuuid.getUUID());
        sendMessageMapper.savePrivateMessage(privateMessageVo);
        sendMessageMapper.updateUser((short) 1, privateMessageVo.getReceivePersonAccount());
    }

    @Override
    public PostVo postInfo(String code) {
        PostVo postInfo = sendMessageMapper.postInfo(code);
        return postInfo;
    }
}