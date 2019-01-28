package com.bbs.privatemsg.service;

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
    /**
     * 根据用户account = 接收人receivePersonAccount获取接收到的私信数量统计
     *
     * @param request 从其中获取session进而获取用户account
     */
    void getNewMessageCount(HttpServletRequest request);

    /**
     * 根据接收人receivePersonAccount和私信状态messageStatus获取私信列表
     *
     * @param receivePersonAccount 接收人receivePersonAccount
     * @param messageStatus        私信状态messageStatus
     * @param currentPage          页码
     * @param pageSize             每页行数
     * @return List<PrivateMessageVo> 私信列表
     */
    Page<PrivateMessageVo> getMessageList(String receivePersonAccount, Integer messageStatus, Integer currentPage, Integer pageSize);

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
}