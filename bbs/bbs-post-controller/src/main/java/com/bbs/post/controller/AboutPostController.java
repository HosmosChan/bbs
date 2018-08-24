package com.bbs.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbs.data.service.DataService;
import com.bbs.post.service.AboutPostService;
import com.bbs.post.service.PostService;
@Controller
@RequestMapping(value = "/about")
public class AboutPostController {
	
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
}
