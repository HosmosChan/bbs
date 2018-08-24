package com.bbs.complain.mapper;

import com.bbs.domain.ComplainVo;
import com.bbs.domain.PostVo;

import java.util.List;

public interface ComplainMapper {
    /**
     * 投诉信息对象持久化映射层
     *
     * @author chenhuayang
     * @version 2018/7/20
     */
    public Integer saveComplain(ComplainVo complainVo);

    public List<ComplainVo> getComplainType(ComplainVo complainVo);

    public PostVo postInfo(String code);

    public List<ComplainVo> getComplain(String status);

    public ComplainVo findComplainByCode(String code);

    public void updateComplainByCode(ComplainVo ignoreComplain);

    public void deleteComplain(String code);
}