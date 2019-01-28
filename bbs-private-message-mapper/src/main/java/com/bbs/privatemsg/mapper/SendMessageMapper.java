package com.bbs.privatemsg.mapper;

import com.bbs.domain.PostVo;
import com.bbs.domain.PrivateMessageVo;

/**
 * 发送私信信息对象持久化映射层
 *
 * @author chenhuayang
 * @version 2018/10/19
 */
public interface SendMessageMapper {
    /**
     * 保存私信信息
     *
     * @param privateMessageVo 私信信息
     */
    void savePrivateMessage(PrivateMessageVo privateMessageVo);

    /**
     * 根据帖子code获取帖子信息
     *
     * @param code 帖子code
     * @return PostVo 帖子信息
     */
    PostVo postInfo(String code);

    /**
     * 更新接收人新私信状态，用于更新用户有几条新私信
     *
     * @param newMessage           1
     * @param receivePersonAccount 接收人receivePersonAccount
     */
    void updateUser(short newMessage, String receivePersonAccount);
}