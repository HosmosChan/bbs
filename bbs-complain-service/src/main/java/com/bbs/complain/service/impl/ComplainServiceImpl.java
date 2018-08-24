package com.bbs.complain.service.impl;

import com.bbs.complain.mapper.ComplainMapper;
import com.bbs.complain.service.ComplainService;
import com.bbs.domain.ComplainVo;
import com.bbs.domain.PostVo;
import com.bbs.exception.BusinessRunException;
import com.bbs.utils.GETuuid;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ComplainServiceImpl implements ComplainService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ComplainMapper complainMapper;

    /**
     * 提交投诉信息数据访问层
     *
     * @throws BusinessRunException
     * @author chenhuayang
     * @version 2018/7/19
     */
    @Override
    @Transactional(rollbackFor = BusinessRunException.class)
    public Integer saveComplain(ComplainVo complainVo) throws BusinessRunException {
        try {
            // TODO Auto-generated method stub
            complainVo.setCode(GETuuid.getUUID());
            complainVo.setStatus("00");
            complainVo.setCreateBy("Admin");
            complainVo.setCreateDate(new Date());
            return complainMapper.saveComplain(complainVo);
        } catch (Exception e) {
            logger.info("保存投诉异常", e);
            throw new BusinessRunException(e);
        }
    }
    /**
     * 投诉获取帖子信息数据访问层
     *
     * @author chenhuayang
     * @version 2018/7/24
     */
    @Override
    public PostVo postInfo(String code) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        complainMapper.updateComplainByCode(ignoreComplain);
    }

    @Override
    public void deleteComplain(String code) {
        complainMapper.deleteComplain(code);
    }
}