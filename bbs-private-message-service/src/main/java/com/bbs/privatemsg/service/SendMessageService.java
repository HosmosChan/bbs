package com.bbs.privatemsg.service;

import com.bbs.domain.PostVo;
import com.bbs.domain.PrivateMessageVo;

/**
 * 发送私信业务层
 *
 * @author chenhuayang
 * @version 2018/10/19
 */
public interface SendMessageService {
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
}