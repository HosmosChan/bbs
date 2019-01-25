package com.bbs.privateMessage.service;

import com.bbs.domain.PrivateMessageVo;
import com.github.pagehelper.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 接收私信业务层
 *
 * @author chenhuayang
 * @version 2018/11/02
 */
public interface SelectMessageService {
    void getNewMessageCount(HttpServletRequest request);

    Page<Object> getMessageList(String recievePersonAccount, Integer messageStatus, Integer currentPage, Integer pageSize);

    void updateMessage(PrivateMessageVo privateMessageVo);

    PrivateMessageVo getMessageByCode(String code);
}
