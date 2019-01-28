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

/**
 * 帖子投诉数据访问层
 *
 * @author chenhuayang
 * @version 2018/9/6
 */
@Service
public class ComplainServiceImpl implements ComplainService {
    @Autowired
    private ComplainMapper complainMapper;

    @Override
    public void saveComplain(ComplainVo complainVo) {
        complainVo.setStatus("00");
        complainVo.setCreateBy("Admin");
        complainVo.setCode(GETuuid.getUUID());
        complainVo.setCreateDate(new Date());
        complainMapper.saveComplain(complainVo);
    }

    @Override
    public PostVo postInfo(String code) {
        PostVo postInfo = complainMapper.postInfo(code);
        return postInfo;
    }

    @Override
    public Page<Object> getComplain(String status, Integer currentPage) {
        Page<Object> page = PageHelper.startPage(currentPage, 999999999);
        complainMapper.getComplain(status);
        return page;
    }

    @Override
    public List<ComplainVo> getComplainType(ComplainVo complainVo) {
        return complainMapper.getComplainType(complainVo);
    }

    @Override
    public ComplainVo findComplainByCode(String code) {
        ComplainVo complainVo = complainMapper.findComplainByCode(code);
        return complainVo;
    }

    @Override
    public void updateComplainByCode(ComplainVo ignoreComplain) {
        complainMapper.updateComplainByCode(ignoreComplain);
    }

    @Override
    public void deleteComplainAndPostAndComment(String code) {
        complainMapper.deleteComplainAndPostAndComment(code);
    }

    @Override
    public void deleteComplain(String code) {
        complainMapper.deleteComplain(code);
    }
}