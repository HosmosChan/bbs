package com.bbs.complain.controller;

import com.bbs.complain.service.ComplainService;
import com.bbs.domain.ComplainVo;
import com.bbs.post.service.PostService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
    @Autowired
    private ComplainService complainService;
    @Autowired
    private PostService postService;

    /**
     * 根据code忽视投诉信息
     *
     * @author chenhuayang
     * @version 2018/8/16
     */
    @RequestMapping(value = "/ignoreComplain")
    public String ignoreComplain(String code) {
        ComplainVo ignoreComplain = complainService.findComplainByCode(code);
        ignoreComplain.setStatus("01");
        complainService.updateComplainByCode(ignoreComplain);
        return "complain/complainIgnore";
    }

    /**
     * 根据code删除帖子并删除对应投诉信息以及对应评论信息
     *
     * @author chenhuayang
     * @version 2018/8/14
     * @version 2018/8/16
     */
    @RequestMapping(value = "/deleteComplain")
    public String deleteComplain(String code) {
        complainService.deleteComplain(code);
        return "complain/complainDelete";
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
        complainService.deleteComplain(postCode);
        return "success";
    }
    /**
     * 获取投诉信息
     *
     * @author chenhuayang
     * @version 2018/8/14
     */
    @ResponseBody
    @RequestMapping(value = "/searchingComplain")
    public ModelAndView searchingComplain(String status) {
        status = "00";
        Integer currentPage = 1;
        Page<Object> page = complainService.getComplain(status, currentPage);
        ModelAndView myComplainPageModelAndView = new ModelAndView();
        myComplainPageModelAndView.setViewName("complain/searchingComplain");
        myComplainPageModelAndView.addObject("page", page);
        return myComplainPageModelAndView;
    }

    /**
     * 获取投诉信息
     *
     * @author chenhuayang
     * @version 2018/8/14
     */
    @ResponseBody
    @RequestMapping(value = "/getComplainForJson")
    public List<Object> getComplainForJson(String status, Integer currentPage) {
        status = "00";
        if (currentPage == null) currentPage = 1;
        Page<Object> page = complainService.getComplain(status, currentPage);
        return page.getResult();
    }

    /**
     * json中存储数据库获取到的全部投诉类型
     *
     * @author chenhuayang
     * @version 2018/7/24
     */
    @ResponseBody
    @RequestMapping(value = "/getComplainType")
    public List<ComplainVo> getComplainType(HttpSession session, ComplainVo complainVo) {
        List<ComplainVo> listComplain = complainService.getComplainType(complainVo);
        /*session.setAttribute("complainVo", complainVo);*/
        return listComplain;
    }
}