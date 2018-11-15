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
import com.bbs.exception.BusinessRunException;
import com.bbs.post.service.PostService;
import com.bbs.role.service.RoleService;

/**
 * author ：sitong
 * 数据显示、数据导出
 */
@Controller
@RequestMapping(value = "/data")
public class DataController {
    @Autowired
    private DataService dataserviceImpl;
    @Autowired
    private PostService postserviceImpl;
    @Autowired
    private RoleService roleserviceImpl;

    @RequestMapping(value = "/login")
    public String login() {
        return "data/login";
    }

    @RequestMapping(value = "/testScheduled")
    public String testScheduled() throws BusinessRunException {
//		System.err.println("开始更新月数据");
//		dataserviceImpl.checkMonthActivityUser(31);
//		System.err.println("更新月数据成功");
//		System.err.println("开始更新周数据");
//		dataserviceImpl.checkBestActivityUser(8);
//		System.err.println("更新周数据成功");
//		System.err.println("开始更新只有28的月份 月数据");
//		dataserviceImpl.checkLastWeekActivityUser(28);
//		dataserviceImpl.checkMonthActivityUser(28);
//		System.err.println("更新只有28的月份 月数据成功");
//		
//		String q;
//		for(int i=1;i<14;i++)
//		{
//			if(i<10)
//				q="0"+i;
//			else
//			    q=""+i;
//			String data="2018-09-"+q;
//			dataserviceImpl.autoCreateNewData(data);
//		}
        return "data/login";
    }

    /**
     * 获取数据报表
     */
    @RequestMapping(value = "/getlistData")
    public String getlistData(String year, String month, Model model, HttpServletRequest request)
            throws ServletException, IOException {
        if (month.length() < 2) {
            month = "0" + month;
        }
        HttpSession session = request.getSession();
        User1 user = (User1) session.getAttribute("user1");
        String moduleId = postserviceImpl.getmoduleCodebyAccount(user.getAccount());//查询该用户所管理的模块Id
        if (moduleId == null) {
            moduleId = "0";
        }
        List<Data> listdata = dataserviceImpl.listData(year, month, moduleId);
        model.addAttribute("listdata", listdata);
        String[] listWeek = dataserviceImpl.getlistWeek(listdata);
        model.addAttribute("listWeek", listWeek);
        return "data/DataShow";
    }

    /**
     * 将数据导入到Excel表格中
     */
    @RequestMapping(value = "/exportMSG")
    public String exportMSG(String year, String month, HttpServletResponse response, HttpServletRequest request) {
        if (month.length() < 2) {
            month = "0" + month;
        }
        HttpSession session = request.getSession();
        User1 user = (User1) session.getAttribute("user1");
        String moduleId = postserviceImpl.getmoduleCodebyAccount(user.getAccount());//查询该用户所管理的模块Id
        if (moduleId == null) {
            moduleId = "0";
        }
        List<Data> listdata = dataserviceImpl.listData(year, month, moduleId);
        String moduleName = postserviceImpl.getModuleName(moduleId);
        dataserviceImpl.exportExcel(moduleName, year, month, listdata, response);
        return "data/login";
    }
}