package com.bbs.complain.service;

import com.bbs.domain.ComplainVo;
import com.bbs.domain.PostVo;
import com.github.pagehelper.Page;

import java.util.List;

public interface ComplainService {
    /**
     * 帖子投诉业务层
     *
     * @author chenhuayang
     * @version 2018/7/19
     * @version 2018/8/14
     * @version 2018/8/16
     * @version 2018/9/6
     */
    void saveComplain(ComplainVo complainVo);

    PostVo postInfo(String code);                               //投诉获取帖子信息

    Page<Object> getComplain(String status, Integer currentPage);//获取投诉信息

    List<ComplainVo> getComplainType(ComplainVo complainVo);    //获取到的全部投诉类型

    ComplainVo findComplainByCode(String code);                 //根据code忽视投诉信息

    void updateComplainByCode(ComplainVo ignoreComplain);       //根据code忽视投诉信息

    void deleteComplainAndPostAndComment(String code);          //删除帖子并删除对应投诉信息以及对应评论信息

    void deleteComplain(String code);                           //删除投诉信息
}