package com.bbs.privateMessage.mapper;

import com.bbs.domain.PrivateMessageVo;

import java.util.List;
import java.util.Map;

/**
 * 接收私信信息对象持久化映射层
 *
 * @author chenhuayang
 * @version 2018/11/02
 */
public interface SelectMessageMapper {
    List<PrivateMessageVo> getMessageList(Map<String, Object> map);

    void updateMessage(PrivateMessageVo privateMessageVo);

    PrivateMessageVo getMessageByCode(String code);
}
