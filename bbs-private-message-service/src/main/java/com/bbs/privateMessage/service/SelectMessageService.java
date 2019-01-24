package com.bbs.privateMessage.service;

import com.bbs.domain.PrivateMessageVo;

import java.util.List;

/**
 * 接收私信业务层
 *
 * @author chenhuayang
 * @version 2018/11/02
 */
public interface SelectMessageService {
    List<PrivateMessageVo> getMessageList(String recievePersonAccount, Integer messageStatus);

    void updateMessage(PrivateMessageVo privateMessageVo);

    PrivateMessageVo getMessageByCode(String code);
}
