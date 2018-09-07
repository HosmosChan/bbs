package com.bbs.post.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bbs.domain.Module;
import com.bbs.domain.PostClass;
import com.bbs.domain.PostVo;
import com.bbs.post.service.AboutPostService;
import com.bbs.post.service.PostService;
import com.github.pagehelper.Page;

@Controller
@RequestMapping(value = "/")
public class EntranceController {

    @Autowired
    private PostService postService;
    @Autowired
    private AboutPostService aboutPostService;
	@RequestMapping(value = "/index")
	public ModelAndView indexPage(HttpServletRequest request) {
		ModelAndView indexPageModelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		Integer currentPage = 1;
		Integer pageSize = 10;
		Page<Object> page = postService.getAllPostPage(currentPage, pageSize);
		indexPageModelAndView.addObject("page", page);
		// 获取板块信息
		List<Module> moduleList = aboutPostService.getAllModule();
		moduleList.remove(0);// 去掉第一个超级版块的模块 第一个Sitong专用 不用来具体版块
		session.setAttribute("moduleList", moduleList);
		List<PostClass> postClassList = aboutPostService.getAllPostClass();
		session.setAttribute("postClassList", postClassList);

		List<PostVo> PostOrderByList = postService.selectPostOrderBy6();
		session.setAttribute("PostOrderByList", PostOrderByList);

		// indexPageModelAndView.addObject("moduleList",moduleList);
		indexPageModelAndView.setViewName("bbs/index");
		return indexPageModelAndView;
	}
}
