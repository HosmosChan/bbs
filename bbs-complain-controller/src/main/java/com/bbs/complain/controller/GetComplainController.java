package com.bbs.complain.controller;

import com.bbs.complain.service.ComplainService;
import com.bbs.domain.ComplainVo;
import com.github.pagehelper.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 管理员查询投诉信息控制层
 *
 * @author chenhuayang
 * @version 2018/8/14
 */
@Controller
@RequestMapping(value = "/complain")
public class GetComplainController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private ComplainService complainService;

    /**
     * 根据code忽视投诉信息
     *
     * @author chenhuayang
     * @version 2018/8/16
     */
    @RequestMapping(value = "/ignoreComplain")
    public String ignoreComplain(String code) {
        try {
            ComplainVo ignoreComplain = complainService.findComplainByCode(code);
            ignoreComplain.setStatus("01");
            complainService.updateComplainByCode(ignoreComplain);
            return "complain/complainJump";
        } catch (Exception e) {
            logger.info(e);
            throw e;
        }
    }

    /**
     * 根据code删除帖子并删除对应投诉信息以及对应评论信息
     *
     * @author chenhuayang
     * @version 2018/8/14
     * @version 2018/8/16
     */
    @RequestMapping(value = "/deleteComplainAndPostAndComment")
    public String deleteComplainAndPostAndComment(String code) {
        try {
            complainService.deleteComplainAndPostAndComment(code);
            return "complain/complainJump";
        } catch (Exception e) {
            logger.info(e);
            throw e;
        }
    }

    /**
     * 根据code删除帖子
     *
     * @author chenhuayang
     * @version 2018/8/17
     */
    @ResponseBody
    @RequestMapping(value = "/deletePost")
    public String deletePost(String postCode) {
        try {
            complainService.deleteComplainAndPostAndComment(postCode);
            return "success";
        } catch (Exception e) {
            logger.info(e);
            throw e;
        }
    }

    /**
     * 获取投诉信息
     *
     * @author chenhuayang
     * @version 2018/8/14
     */
    @ResponseBody
    @RequestMapping(value = "/searchingComplain")
    public ModelAndView searchingComplain() {
        String status = "00";
        Integer currentPage = 1;
        try {
            Page<Object> page = complainService.getComplain(status, currentPage);
            ModelAndView myComplainPageModelAndView = new ModelAndView();
            myComplainPageModelAndView.setViewName("complain/searchingComplain");
            myComplainPageModelAndView.addObject("page", page);
            return myComplainPageModelAndView;
        } catch (Exception e) {
            logger.info(e);
            throw e;
        }
    }

    /**
     * json中存储数据库获取到的全部投诉类型
     *
     * @author chenhuayang
     * @version 2018/7/24
     */
    @ResponseBody
    @RequestMapping(value = "/getComplainType")
    public List<ComplainVo> getComplainType(ComplainVo complainVo) {
        try {
            List<ComplainVo> listComplain = complainService.getComplainType(complainVo);
            return listComplain;
        } catch (Exception e) {
            logger.info(e);
            throw e;
        }
    }
}