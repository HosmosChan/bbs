package com.bbs.privateMessage.service;

import com.bbs.domain.PostVo;
import com.bbs.domain.PrivateMessageVo;

/**
 * 发送私信业务层
 *
 * @author chenhuayang
 * @version 2018/10/19
 */
public interface SendMessageService {
    void savePrivateMessage(PrivateMessageVo privateMessageVo);

    PostVo postInfo(String code);
}