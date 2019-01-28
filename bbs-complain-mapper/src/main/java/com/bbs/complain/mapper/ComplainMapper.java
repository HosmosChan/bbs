package com.bbs.complain.mapper;

import com.bbs.domain.ComplainVo;
import com.bbs.domain.PostVo;

import java.util.List;

/**
 * 投诉信息对象持久化映射层
 *
 * @author chenhuayang
 * @version 2018/9/6
 */
public interface ComplainMapper {
    /**
     * 保存投诉信息
     *
     * @param complainVo 投诉信息
     */
    void saveComplain(ComplainVo complainVo);

    /**
     * 获取投诉信息类型列表
     *
     * @param complainVo 投诉信息
     * @return List<ComplainVo> 投诉信息类型列表
     */
    List<ComplainVo> getComplainType(ComplainVo complainVo);

    /**
     * 根据帖子code获取帖子详情
     *
     * @param code 帖子code
     * @return PostVo 帖子详情
     */
    PostVo postInfo(String code);

    /**
     * 根据投诉信息状态status获取投诉信息列表
     *
     * @param status 投诉信息状态status
     * @return List<ComplainVo> 投诉信息列表
     */
    List<ComplainVo> getComplain(String status);

    /**
     * 根据投诉code获取投诉信息
     *
     * @param code 投诉code
     * @return ComplainVo 投诉信息
     */
    ComplainVo findComplainByCode(String code);

    /**
     * 根据投诉code无视投诉信息
     *
     * @param ignoreComplain 欲无视的投诉信息
     */
    void updateComplainByCode(ComplainVo ignoreComplain);

    /**
     * 根据帖子code删除帖子、评论和投诉
     *
     * @param code 帖子code
     */
    void deleteComplainAndPostAndComment(String code);

    /**
     * 根据投诉code删除投诉信息
     *
     * @param code 投诉code
     */
    void deleteComplain(String code);
}