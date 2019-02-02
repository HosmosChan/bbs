package com.bbs.post.controller;

import java.util.List;

import com.bbs.domain.Point;
import com.bbs.domain.User1;
import com.bbs.point.service.UserPointService;
import com.bbs.privatemsg.service.SelectMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.bbs.domain.Module;
import com.bbs.domain.PostClass;
import com.bbs.post.service.AboutPostService;
import com.bbs.post.service.PostService;
import com.github.pagehelper.Page;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
    @Autowired
    private PostService postService;
    @Autowired
    private AboutPostService aboutPostService;
    @Autowired
    private SelectMessageService selectMessageService;
    @Autowired
    private UserPointService userPointService;

    /**
     * author：wanghsixu 2018/8/9 11：21
     * 发帖页面跳转
     */
    @RequestMapping(value = "/write")
    public ModelAndView writePost(HttpServletRequest request) {
        selectMessageService.getNewMessageCount(request);
        ModelAndView MV = new ModelAndView();
        List<PostClass> allPostClassList = aboutPostService.getAllPostClass();
        MV.addObject("allPostClassList", allPostClassList);
        List<Module> moduleList = aboutPostService.getAllModule();
        moduleList.remove(0);// 去掉第一个超级版块的模块 第一个Sitong专用 不用来具体版块
        MV.addObject("moduleList", moduleList);
        MV.setViewName("bbs/write");
        return MV;
    }

    @ResponseBody
    @RequestMapping(value = "/post")
    public ModelAndView post(HttpServletRequest request) {
        selectMessageService.getNewMessageCount(request);
        ModelAndView postPageModelAndView = new ModelAndView();
        postPageModelAndView.setViewName("bbs/post");
        return postPageModelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/home")
    public ModelAndView home(HttpServletRequest request) {
        ModelAndView homePageModelAndView = new ModelAndView();
        Point point = new Point();
        point.setAccount(((User1) request.getSession().getAttribute("user1")).getAccount());
        point = userPointService.getPoint(point);
        homePageModelAndView.addObject("point", point);
        homePageModelAndView.setViewName("bbs/home");
        return homePageModelAndView;
    }

    /**
     * 进入论坛首页
     * author: wangshixu 2018/8/9
     */
    @RequestMapping(value = "/postForJson")
    public ModelAndView indexPage(Integer currentPage, ModelAndView MV, HttpServletRequest request) {
        selectMessageService.getNewMessageCount(request);
        if (currentPage == null) currentPage = 1;
        Integer pageSize = 10;
        Page<Object> page = postService.getAllPostPage(currentPage, pageSize);
        MV.addObject("page", page);
        MV.setViewName("bbs/index");
        return MV;
    }

    /**
     * 进入论坛首页
     * author: wangshixu 2018/8/15
     */
    @RequestMapping(value = "/PostByClassCodeForJson")
    public ModelAndView listPostByClassCode(ModelAndView MV, String classCode, Integer currentPage, HttpServletRequest request) {
        selectMessageService.getNewMessageCount(request);
        if (currentPage == null) currentPage = 1;
        Integer pageSize = 10;
        Page<Object> page = aboutPostService.selectAllPostClassByCode(classCode, currentPage, pageSize);
        MV.addObject("page", page);
        MV.addObject("currentClassCode", classCode);
        MV.setViewName("bbs/moudelPost");
        return MV;
    }
}