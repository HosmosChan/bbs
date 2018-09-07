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
     * @version 2018/9/6
     */
    void saveComplain(ComplainVo complainVo);

    List<ComplainVo> getComplainType(ComplainVo complainVo);

    PostVo postInfo(String code);

    List<ComplainVo> getComplain(String status);

    ComplainVo findComplainByCode(String code);

    void updateComplainByCode(ComplainVo ignoreComplain);

    void deleteComplainAndPostAndComment(String code);

    void deleteComplain(String code);
}