package com.bbs.post.controller;

import com.bbs.domain.PostVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bbs.data.service.DataService;
import com.bbs.post.service.AboutPostService;
import com.bbs.post.service.PostService;
import com.github.pagehelper.Page;
@Controller
@RequestMapping(value = "/about")
public class AboutPostController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private AboutPostService aboutPostService; 
	@Autowired
	private PostService postserviceImpl; 
	@Autowired
	private DataService dataserviceImpl; 
	
	@ResponseBody
	@SuppressWarnings("finally")
	@RequestMapping(value="/praise")
	public Integer praise(String postCode,Integer flag){
			Integer amount = aboutPostService.addPraise(postCode,flag);
			String moduleId=postserviceImpl.getmoduleCodebypostCode(postCode);
			String time=dataserviceImpl.getnewtime();
			boolean statue=true;
			if(flag==-1)//表示取消赞
			{
				statue=false;
			}
			try {
				dataserviceImpl.updatePraiseData(time,statue,moduleId);  
			} finally {
				return amount;
			}
	}
	/**
	 * 根据code删除评论
	 *
	 * @author chenhuayang
	 * @version 2018/8/28
	 */
	@RequestMapping(value = "/deleteComment")
	public String deleteComment(String postCode, String code) {
		aboutPostService.deleteComment(code);
		PostVo postVo = postserviceImpl.getPostByCode(postCode);
		postVo.setReplyAmount(postVo.getReplyAmount() - 1);
		postserviceImpl.updateComment(postVo);
		return null;
	}
	
	/**
	 * 根据帖子编码获取帖子(用于帖子详情页)
	 *
	 * @author chenhuayang
	 * @version 2018/7/20
	 * @modify 王世旭
	 * @version 2018/7/23 17:35
	 */
	@RequestMapping(value = "/getPostAndCommnetByCodeOfPage")
	public ModelAndView getPostAndCommnetByCodeOfPage(String postcode, ModelAndView MV, Integer currentPage) {
		try {
			if(currentPage == null)currentPage = 1;
	    	Integer pageSize = 8;
			PostVo postVo = new PostVo();
			postVo.setCode(postcode);
			postVo = postService.getPostbyCode(postVo);
			
			Page<Object> page = aboutPostService.getOnePostComments(postcode ,currentPage ,pageSize);
			MV.addObject("page", page);
			MV.addObject("post", postVo);
			MV.setViewName("bbs/post");
			return MV;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
