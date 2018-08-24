package com.bbs.complain.service;

import com.bbs.domain.ComplainVo;
import com.bbs.domain.PostVo;
import com.bbs.exception.BusinessRunException;
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
     */
    public Integer saveComplain(ComplainVo complainVo) throws BusinessRunException;

    public PostVo postInfo(String code);                                //投诉获取帖子信息

    public Page<Object> getComplain(String status, Integer currentPage);//获取投诉信息

    public List<ComplainVo> getComplainType(ComplainVo complainVo);     //获取到的全部投诉类型

    public ComplainVo findComplainByCode(String code);                  //根据code忽视投诉信息

    public void updateComplainByCode(ComplainVo ignoreComplain);        //根据code忽视投诉信息

    public void deleteComplain(String code);                            //删除帖子并删除对应投诉信息以及对应评论信息
}