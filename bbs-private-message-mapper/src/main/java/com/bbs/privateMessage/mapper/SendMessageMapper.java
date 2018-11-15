package com.bbs.privateMessage.mapper;

import com.bbs.domain.PostVo;
import com.bbs.domain.PrivateMessageVo;

/**
 * 发送私信信息对象持久化映射层
 *
 * @author chenhuayang
 * @version 2018/10/19
 */
public interface SendMessageMapper {
    void savePrivateMessage(PrivateMessageVo privateMessageVo);

    PostVo postInfo(String code);
}