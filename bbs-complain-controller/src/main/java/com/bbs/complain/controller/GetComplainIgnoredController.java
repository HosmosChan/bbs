package com.bbs.complain.controller;

import com.bbs.complain.service.ComplainService;
import com.bbs.domain.ComplainVo;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 管理员查询被忽视投诉信息控制层
 *
 * @author chenhuayang
 * @version 2018/8/14
 */
@Controller
@RequestMapping(value = "/complainIgnored")
public class GetComplainIgnoredController {
    @Autowired
    private ComplainService complainService;

    /**
     * 获取投诉信息
     *
     * @author chenhuayang
     * @version 2018/8/14
     */
    @ResponseBody
    @RequestMapping(value = "/searchingComplainIgnored")
    public ModelAndView searchingComplain(String status) {
        try {
            status = "01";
            Integer currentPage = 1;
            Page<Object> page = complainService.getComplain(status, currentPage);
            ModelAndView myComplainPageModelAndView = new ModelAndView();
            myComplainPageModelAndView.setViewName("complain/isComplainIgnored");
            myComplainPageModelAndView.addObject("page", page);
            return myComplainPageModelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据code重视投诉信息
     *
     * @author chenhuayang
     * @version 2018/8/16
     */
    @RequestMapping(value = "/payAttentionComplain")
    public String payAttentionComplain(String code) {
        try {
            ComplainVo ignoreComplain = complainService.findComplainByCode(code);
            ignoreComplain.setStatus("00");
            complainService.updateComplainByCode(ignoreComplain);
            return "complain/complainJumpIgnored";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据code删除投诉信息
     *
     * @author chenhuayang
     * @version 2018/9/6
     */
    @RequestMapping(value = "/deleteComplain")
    public String deleteComplain(String code) {
        try {
            complainService.deleteComplain(code);
            return "complain/complainJumpIgnored";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}