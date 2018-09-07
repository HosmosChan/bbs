package com.bbs.data.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.data.service.DataService;
import com.bbs.domain.Data;
import com.bbs.domain.User1;
import com.bbs.post.service.PostService;
import com.bbs.role.service.RoleService;
import com.bbs.utils.ExportExcel;


/**
 * author ：sitong
 * 数据显示、数据导出
 *
 */
@Controller
@RequestMapping(value="/data")
public class DataController 
{
	@Autowired
	private DataService dataserviceImpl;
	@Autowired
	private PostService postserviceImpl;
	@Autowired
	private RoleService roleserviceImpl;
	@RequestMapping(value="/login")
	public String login() {
		
		return "data/login";
	}
	@RequestMapping(value="/testScheduled")
	public String testScheduled() {
		System.err.println("开始更新月数据");
		roleserviceImpl.checkMonthActivityUser();
		System.err.println("更新月数据成功");
		return "data/login";
	}
	/*
	 * 获取数据报表
	 * */
	@RequestMapping(value="/getlistData")
	public String getlistData(String year,String month,Model model,HttpServletRequest request) 
			throws ServletException, IOException {
		if(month.length()<2)
		{
			month="0"+month;
		}
		HttpSession session = request.getSession();
        User1 user= (User1) session.getAttribute("user1");
        String moduleId=postserviceImpl.getmoduleCodebyAccount(user.getAccount());//查询该用户所管理的模块Id
		if(moduleId==null)
		    {
		    	moduleId="0";
		    }
		List<Data> listdata=dataserviceImpl.listData(year,month,moduleId);  	
		model.addAttribute("listdata",listdata);
		String[] listWeek=dataserviceImpl.getlistWeek(listdata);
		model.addAttribute("listWeek",listWeek);
		
		return "data/DataShow";
	}
	/*
	 * 将数据导入到Excel表格中
	 * */
	@RequestMapping(value="/exportMSG")
	public String exportMSG(String year,String month,HttpServletResponse response,HttpServletRequest request)
	{
        if(month.length()<2)
        {
        	month="0"+month;
        }
        HttpSession session = request.getSession();
        User1 user= (User1) session.getAttribute("user1");
        String moduleId=postserviceImpl.getmoduleCodebyAccount(user.getAccount());//查询该用户所管理的模块Id
	   if(moduleId==null)
		    {
		    	moduleId="0";
		    }
		List<Data> listdata=dataserviceImpl.listData(year, month,moduleId);
		
		String moduleName=postserviceImpl.getModuleName(moduleId);
		ExportExcel<Data> ee= new ExportExcel<Data>();
		String[] headers = { "序号", "日期","模块编号","发帖量", "点赞量","最受欢迎帖子","最活跃用户","创建时间","创建人","修改时间","修改人"};
		String fileName = moduleName+year+"-"+month+"月份数据信息统计表";
		ee.exportExcel(headers,listdata,fileName,response);
		return "data/login";
	}
}