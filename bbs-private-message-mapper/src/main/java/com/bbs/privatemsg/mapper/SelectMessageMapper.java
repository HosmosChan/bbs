package com.bbs.privatemsg.mapper;

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
    /**
     * 根据接收人receivePersonAccount和私信状态messageStatus获取私信列表
     *
     * @param map 接收人receivePersonAccount和私信状态messageStatus
     * @return List<PrivateMessageVo> 私信列表
     */
    List<PrivateMessageVo> getMessageList(Map<String, Object> map);

    /**
     * 更新私信(现仅用于更新私信状态)
     *
     * @param privateMessageVo 私信信息
     */
    void updateMessage(PrivateMessageVo privateMessageVo);

    /**
     * 根据私信code获取私信信息
     *
     * @param code 私信code
     * @return PrivateMessageVo 私信信息
     */
    PrivateMessageVo getMessageByCode(String code);

    /**
     * 根据用户account = 接收人receivePersonAccount获取接收到的私信数量统计
     *
     * @param account 用户account
     * @return int 私信数量统计
     */
    int getNewMessageCount(String account);
}