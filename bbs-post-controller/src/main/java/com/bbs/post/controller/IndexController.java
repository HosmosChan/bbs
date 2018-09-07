package com.bbs.post.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bbs.domain.Module;
import com.bbs.domain.PostClass;
import com.bbs.domain.PostVo;
import com.bbs.post.service.AboutPostService;
import com.bbs.post.service.PostService;
import com.github.pagehelper.Page;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	
    @Autowired
    private PostService postService;
    @Autowired
    private AboutPostService aboutPostService;
	/*
	 * author：wanghsixu 2018/8/9 11：21
	 * 发帖页面跳转
	 * */
	@ResponseBody
	@RequestMapping(value="/write")
	public ModelAndView writePost() {
		ModelAndView writePageModelAndView = new ModelAndView();
		writePageModelAndView.setViewName("bbs/write");
    	return writePageModelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/post")
	public ModelAndView post() {
		ModelAndView postPageModelAndView = new ModelAndView();
		postPageModelAndView.setViewName("bbs/post");
    	return postPageModelAndView;
	}

	@ResponseBody
	@RequestMapping(value="/home")
	public ModelAndView home() {
		ModelAndView homePageModelAndView = new ModelAndView();
		homePageModelAndView.setViewName("bbs/home");
    	return homePageModelAndView;
	}
	
    /*
     * 进入论坛首页
     * author: wangshixu 2018/8/9
     * 
     * */
    @RequestMapping(value = "/postForJson")
    public ModelAndView indexPage(Integer currentPage, ModelAndView MV) {
    	if(currentPage == null)currentPage = 1;
    	Integer pageSize = 10;
    	Page<Object> page =  postService.getAllPostPage(currentPage,pageSize);
    	MV.addObject("page", page);
    	MV.setViewName("bbs/index");
    	return MV;
    }
    /*
     * 进入论坛首页
     * author: wangshixu 2018/8/15
     * 
     * */
	@RequestMapping(value="/PostByClassCodeForJson")
	public ModelAndView listPostByClassCode(ModelAndView MV, String classCode, Integer currentPage) {
		if(currentPage == null)currentPage = 1;
    	Integer pageSize = 10;
    	Page<Object> page = aboutPostService.selectAllPostClassByCode(classCode,currentPage,pageSize);
    	MV.addObject("page", page);
    	MV.setViewName("bbs/moudelPost");
		return MV;
	}
}
