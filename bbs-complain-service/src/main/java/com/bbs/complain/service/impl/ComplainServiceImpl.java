package com.bbs.complain.service.impl;

import com.bbs.complain.mapper.ComplainMapper;
import com.bbs.complain.service.ComplainService;
import com.bbs.domain.ComplainVo;
import com.bbs.domain.PostVo;
import com.bbs.utils.GETuuid;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComplainServiceImpl implements ComplainService {
    @Autowired
    private ComplainMapper complainMapper;

    /**
     * 提交投诉信息数据访问层
     *
     * @author chenhuayang
     * @version 2018/7/19
     */
    @Override
    public void saveComplain(ComplainVo complainVo) {
        complainVo.setStatus("00");
        complainVo.setCreateBy("Admin");
        complainVo.setCode(GETuuid.getUUID());
        complainVo.setCreateDate(new Date());
        complainMapper.saveComplain(complainVo);
    }

    /**
     * 投诉获取帖子信息数据访问层
     *
     * @author chenhuayang
     * @version 2018/7/24
     */
    @Override
    public PostVo postInfo(String code) {
        PostVo postInfo = complainMapper.postInfo(code);
        return postInfo;
    }

    /**
     * 获取投诉信息数据访问层
     *
     * @author chenhuayang
     * @version 2018/7/24
     */
    @Override
    public Page<Object> getComplain(String status, Integer currentPage) {
        Page<Object> page = PageHelper.startPage(currentPage, 999999999);
        complainMapper.getComplain(status);
        return page;
    }

    /**
     * 获取投诉类型数据访问层
     *
     * @author chenhuayang
     * @version 2018/7/24
     */
    @Override
    public List<ComplainVo> getComplainType(ComplainVo complainVo) {
        return complainMapper.getComplainType(complainVo);
    }

    /**
     * 根据code获取投诉信息数据访问层
     *
     * @author chenhuayang
     * @version 2018/7/24
     */
    @Override
    public ComplainVo findComplainByCode(String code) {
        ComplainVo complainVo = complainMapper.findComplainByCode(code);
        return complainVo;
    }

    /**
     * 更新投诉信息数据访问层（修改status）
     *
     * @author chenhuayang
     * @version 2018/9/1
     */
    @Override
    public void updateComplainByCode(ComplainVo ignoreComplain) {
        complainMapper.updateComplainByCode(ignoreComplain);
    }

    /**
     * 删除帖子并删除对应投诉信息以及对应评论信息数据访问层
     *
     * @author chenhuayang
     * @version 2018/9/1
     * @version 2018/9/6
     */
    @Override
    public void deleteComplainAndPostAndComment(String code) {
        complainMapper.deleteComplainAndPostAndComment(code);
    }

    /**
     * 删除投诉信息数据访问层
     *
     * @author chenhuayang
     * @version 2018/9/6
     */
    @Override
    public void deleteComplain(String code) {
        complainMapper.deleteComplain(code);
    }
}