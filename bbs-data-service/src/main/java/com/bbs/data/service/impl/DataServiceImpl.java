package com.bbs.data.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.bbs.domain.*;
import com.bbs.exception.BusinessRunException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.data.mapper.DataMapper;
import com.bbs.post.mapper.ModuleMapper;
import com.bbs.post.mapper.PostMapper;
import com.bbs.user.mapper.User1Mapper;
import com.bbs.utils.ExportExcel;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.bbs.data.service.DataService;

@Service
public class DataServiceImpl implements DataService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DataMapper dataMapper;
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private ModuleMapper moduleMapper;
	@Autowired
	private User1Mapper user1Mapper;

	@Override
	public Page<Object> list(String year, String month, String moduleId, int currentPage) {
		Page<Object> page = PageHelper.startPage(currentPage, 7);
		List<Data> Datatest = listData(year, month, moduleId);
		return page;
	}

	@Override
	public List<Data> listData(String year, String month, String moduleId) {
     
		List<Data> Datalist=null;
		try {
    	  String date = year + "-" + month;
  		Map<String, Object> map = new HashMap<String, Object>();
  		map.put("date", date);
  		map.put("moduleId", moduleId);
  		List<Data> Datatest = dataMapper.listData(map);
  		Datalist = new ArrayList();
  		
  		int size = Datatest.size();
  		int max = getmonthday(year, month);
  		int datalistsize = size;
  		int daytime = 0;
  		for (int i = 0; i < max; i++) // 为当月的剩余天数 以 空数据补足列表 显得更加美观
  		{
  			if (datalistsize > 0) {
  				String day = Datatest.get(size - datalistsize).getDay();
  				String str = day.substring(day.length() - 2, day.length());
  				daytime = Integer.parseInt(str);
  			} else
  				daytime = 0;
  			if (daytime != (i + 1)) {

  				String i_Str = String.valueOf(i + 1);
  				if (i_Str.length() < 2) {
  					i_Str = "0" + i_Str;
  				}
  				String time = date + "-" + i_Str;
  				Data newdata = new Data();
  				newdata.setDay(time);
  				newdata.setModuleId(moduleId);
  				newdata.setSumPost(0);
  				newdata.setSumPraise(0);
  				newdata.setMaxPraisePostName("数据库暂无数据 ");
  				Datalist.add(newdata);
  			} else {
  				Datalist.add(Datatest.get(size - datalistsize));
  				datalistsize -= 1;
  			}
  		}
  		for (int i = 0; i < Datalist.size(); i++) {
  			Datalist.get(i).setTid(i + 1);
  		}
		}
		catch(Exception e)
		{
			logger.info("返回列表信息异常",e);
		}
		return Datalist;
	}

	@Override
	public void updatePostData(String time, boolean statue, String moduleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("time", time);
		map.put("moduleId", moduleId);
		Data olddata = dataMapper.getData(map);
		if (statue)
			olddata.setSumPost(olddata.getSumPost() + 1);
		else
			olddata.setSumPost(olddata.getSumPost() - 1);

		dataMapper.updateData(olddata);
	}

	@Override
	public void updatePraiseData(String time, boolean statue, String moduleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("time", time);
		map.put("moduleId", moduleId);
		Data olddata = dataMapper.getData(map);
		if (statue)
			olddata.setSumPraise(olddata.getSumPraise() + 1);
		else
			olddata.setSumPraise(olddata.getSumPraise() - 1);
		dataMapper.updateData(olddata);
	}

	@Override
	public void updateBestPostData(String time, String postname, String moduleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("time", time);
		map.put("moduleId", moduleId);
		Data olddata = dataMapper.getData(map);
		olddata.setMaxPraisePostName(postname);
		dataMapper.updateData(olddata);
	}

	public void checkBestPost(String time) throws BusinessRunException {
		java.sql.Date datetime = java.sql.Date.valueOf(time);
		List<Module> modulelist = moduleMapper.moduleList();
		int size = modulelist.size();
		// 第一个模块 即列表的首个模块 第0个模块不做计算
		for (int i = 1; i < size; i++) { 
			String moduleId = modulelist.get(i).getCode();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("datetime", datetime);
			map1.put("moduleId", moduleId);
			List<PostVo> post = postMapper.getBestPost(map1);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("time", time);
			map.put("moduleId", moduleId);
			Data data = dataMapper.getData(map);
			try{
				if (!post.isEmpty() && data != null) {
					// 如果最后一个帖子的名字与当前不相等
					String lastPostName = post.get(post.size() - 1).getTitle();
					if (!(lastPostName).equals(data.getMaxPraisePostName())) {
						// 更新为新的标题
						Map<String, Object> map2 = new HashMap<String, Object>();
						map2.put("time", time);
						map2.put("name", post.get(post.size() - 1).getTitle());
						map2.put("moduleId", moduleId);
						postMapper.updateBestPost(map2);
					}
				}
			}
			catch(Exception e) {
				logger.info("更新标题失败",e);
				throw new BusinessRunException(e);
			}
			
		}
	}

//		定时函数 每天0点在sumdata表格中创建一个新的模块数据
	@Override
	public void autoCreateNewData(String time) throws BusinessRunException {
		List<Module> modulelist = moduleMapper.moduleList();
		int size = modulelist.size();
		for (int i = 1; i < size; i++) {
			String moduleId = modulelist.get(i).getCode();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("time", time);
			map.put("moduleId", moduleId);
			try {
				if (dataMapper.getData(map) == null) {
					Data data = new Data();
					data.setDay(time);
					data.setSumPost(0);
					data.setSumPraise(0);
					data.setModuleId(moduleId);
					data.setMaxPraisePostName("今天没人觉得有帖子很赞呦");
					data.setBestActiviteUsername("");
					data.setCreateDate(new Date());
					data.setCreateBy("admin");
					dataMapper.autoCreateNewData(data);
				}
			}
			catch(Exception e)
			{
				logger.info("新增报表数据行失败",e);
				throw new BusinessRunException(e);
			}
			
		}
	}

	@Override
	public void updateUserLogintimes(String userId, String date, String loginModuleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("date", date);
		map.put("loginModuleId", loginModuleId);
		UserLiveness userLiveness = dataMapper.getLoginUser(map);
		if (userLiveness != null) {
			// 不是第一次登录 活跃度+1 登录次数+1
			userLiveness.setLoginTimes(userLiveness.getLoginTimes() + 1);
			userLiveness.setUserLiveness(userLiveness.getUserLiveness() + 1);
			dataMapper.updateUserLiveness(userLiveness);
		} else {
			UserLiveness newuserLiveness = new UserLiveness();
			// 第一次登录 创建一条新的信息 活跃度+10
			newuserLiveness.setUserTid(userId);
			newuserLiveness.setLoginDate(date);
			newuserLiveness.setLoginTimes(1);
			newuserLiveness.setPublishTimes(0);
			newuserLiveness.setLoginModuleId(loginModuleId);
			newuserLiveness.setUserLiveness(10);
			newuserLiveness.setCreateBy("admin");
			newuserLiveness.setCreateDate(new Date());
			dataMapper.saveUserLiveness(newuserLiveness);
		}
	}

	@Override
	public void updateUserPublishtimes(String userId, String date, String loginModuleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("date", date);
		map.put("loginModuleId", loginModuleId);
		UserLiveness userLiveness = dataMapper.getLoginUser(map);
		if (userLiveness != null) {
			// 不是第一次登发帖 活跃度+5
			userLiveness.setPublishTimes(userLiveness.getPublishTimes() + 1);
			userLiveness.setUserLiveness(userLiveness.getUserLiveness() + 5);
			dataMapper.updateUserLiveness(userLiveness);
		} else {
			UserLiveness newuserLiveness = new UserLiveness();
			// 第一次登录 到该板块发帖 创建一条新的表格信息 活跃度+10
			newuserLiveness.setUserTid(userId);
			newuserLiveness.setLoginDate(date);
			newuserLiveness.setLoginTimes(0);
			newuserLiveness.setPublishTimes(1);
			newuserLiveness.setLoginModuleId(loginModuleId);
			newuserLiveness.setUserLiveness(5);
			newuserLiveness.setCreateBy("sitong");
			newuserLiveness.setCreateDate(new Date());
			dataMapper.saveUserLiveness(newuserLiveness);
		}
	}

	@Override
	public void deletepostclass(String name) {
		dataMapper.deletepostclass(name);
	}
	
	public String getnewtime() {
		Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
		String year = String.valueOf(c.get(Calendar.YEAR));
		String month = String.valueOf(c.get(Calendar.MONTH) + 1);
		String day = String.valueOf(c.get(Calendar.DATE));
		if (month.length() < 2)
			month = "0" + month;
		if (day.length() < 2)
			day = "0" + day;
		return year + "-" + month + "-" + day;
	}

	@Override
	public String[] getlistWeek(List<Data> listdata) {
		//如果当月只有28天 则月活跃用户与周放在一起 以/分开
		
		String[] listWeek = new String[5];
		int tag = 0;
		for (int i = 0; i < listdata.size(); i++) {
			String name = listdata.get(i).getBestActiviteUsername();
			
			if (!StringUtils.isEmpty(name)) {
				if (i < 8)
					listWeek[tag] = "第一周最活跃用户： " + name;
				else {
					if (i < 15)
						listWeek[tag] = "第二周最活跃用户： " + name;
					else {
						if (i < 22)
							listWeek[tag] = "第三周最活跃用户： " + name;
						else {
							if (i < 29)
								{
									  listWeek[tag] = "第四周最活跃用户： " + name;
									  if(listdata.size()<29)
									   {
									    String[] str =name.split("/",2);
									    listWeek[tag] = "第四周最活跃用户： " + str[0];
									    listWeek[tag+1] = "本月最活跃用户： " + str[1];
									    }
								}
							else {
								listWeek[tag] = "本月最活跃用户： " + name;
							}
						}
					}
				}

				tag++;
			}
		}
		return listWeek;
	}
	@Override
	public void checkBestActivityUser(int daytime) throws BusinessRunException {
		List<Module> modulelist = moduleMapper.moduleList();
		int size = modulelist.size();
		// 定义的模块0 为超级管理员的版块 获取用户的登陆活跃度
		try {
			for (int i = 1; i < size; i++) {
				   String moduleId=modulelist.get(i).getCode();
				   //获取该模块下最活跃用户的名字
				    int max=29;
		            String name=getActivityUserName(max,daytime,moduleId);
					String date = getdate(daytime-1);
					Map<String, Object> map= new HashMap<String, Object>();
			        map.put("moduleId",moduleId);
			        map.put("date",date);
			        map.put("bestActivityname",name);
			        //更新用户
					dataMapper.updatesumdatebyActivityUsername(map);
				}
		}
		catch(Exception e)
		{
			logger.info("更新每周最活跃用户名字异常",e);
			throw new BusinessRunException(e);
		}
		}
	@Override
	public String getActivityUserName(int max,int end,String moduleId) {
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		String year=String.valueOf(c.get(Calendar.YEAR));
		String lastmonth=String.valueOf(c.get(Calendar.MONTH)+1);//更新本月的数据
		if(max<29)
		{lastmonth=String.valueOf(c.get(Calendar.MONTH));}
		
		//定义一周的用户Id 活跃度存储数组
		ArrayList userWeekTid = new ArrayList();
		ArrayList userWeekLiveness = new ArrayList();
		for(int i=end-7;i<end;i++)
		{
			String selectdate = getdate(i);
			if(max<29)
			{selectdate=year+"-02-"+i;}
			Map<String, Object> map= new HashMap<String, Object>();
	        map.put("code","0");
	        map.put("selectdate",selectdate);
	        Map<String, Object> map2= new HashMap<String, Object>();
	        map2.put("code",moduleId);
	        map2.put("selectdate",selectdate);
	        List<UserLiveness> superuserlist = dataMapper.getUserByModuleId(map);
			List<UserLiveness> userlist = dataMapper.getUserByModuleId(map2);
			//定义一天的用户Id 活跃度存储数组
			ArrayList usertid = new ArrayList();
			ArrayList userliveness = new ArrayList();
			//新增登录活跃度
			for(int j=0;j<superuserlist.size();j++)
	        {
				String id=superuserlist.get(j).getUserTid();
				int liveness=superuserlist.get(j).getUserLiveness();
	        	usertid.add(id);
	        	userliveness.add(liveness);
	        }
			//新增发帖活跃度 并将相同Id的活跃度合并
	        for(int j=0;j<userlist.size();j++)
	        {
	        	String id=userlist.get(j).getUserTid();
				int liveness=userlist.get(j).getUserLiveness();
				for(int idAccount=0;idAccount<usertid.size();idAccount++)
				{
					if(id.equals(usertid.get(idAccount)))
					{
						int oldliveness = Integer.valueOf(String.valueOf(userliveness.get(idAccount)));
						userliveness.set(idAccount,oldliveness+liveness);
					}
				}
	        }
	        
	        //将每天的活跃度合并 
	        for(int j=0;j<usertid.size();j++)
	        {
	        	String id=String.valueOf(usertid.get(j));
	        	int liveness=Integer.valueOf(String.valueOf(userliveness.get(j)));
	        	if(userWeekTid.indexOf(id) < 0)
	        	{
	        		userWeekTid.add(id);
	        		userWeekLiveness.add(liveness);
	        	}
	        	else
	        	{
	        		// 得到id的返回ID
					int index = userWeekTid.indexOf(id);
					int oldliveness = Integer.valueOf(String.valueOf(userWeekLiveness.get(index)));
					userWeekLiveness.set(index, oldliveness + liveness);
	        	}
	        	
	        }
	        
		}
		String bestname=null;
		 if(userWeekTid.size()>0||userWeekLiveness.size()>0)
	        {
	        	bestname=getBestUserActivityName(userWeekTid,userWeekLiveness);
	        }
	        
		return bestname;
	}

	
    //选出userWeekLiveness数组内活跃度最高的对应的用户Id 返回其名字
	private String getBestUserActivityName(ArrayList userWeekTid, ArrayList userWeekLiveness) {
			String Accont=String.valueOf(userWeekTid.get(0));
			String bestActivityname = user1Mapper.findUser1ByAccount(Accont).getUserName();
		    int baseActivity = Integer.valueOf(String.valueOf(userWeekLiveness.get(0)));
		    
			for (int i = 1; i < userWeekTid.size(); i++) {
					int tempActivity = Integer.valueOf(String.valueOf(userWeekLiveness.get(i)));
					if (tempActivity > baseActivity) {
						baseActivity = tempActivity;
						String id =String.valueOf(userWeekTid.get(i));
						bestActivityname = user1Mapper.findUser1ByAccount(id).getUserName();
					}
				}
		return bestActivityname;
	}

	public void checkMonthActivityUser(int end) throws BusinessRunException {
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		String year=String.valueOf(c.get(Calendar.YEAR));
		String lastmonth=String.valueOf(c.get(Calendar.MONTH));//更新上一个月的数据
		if (lastmonth.length() < 2)
			lastmonth = "0" + lastmonth;
		List<Module> modulelist = moduleMapper.moduleList();
		
		// 定义的模块0 为超级管理员的版块 获取用户的登陆活跃度
		Module supermodule = modulelist.get(0);
		int size = modulelist.size();
		String selectdate= year + "-" + lastmonth;
		Map<String, Object> supermap= new HashMap<String, Object>();
		supermap.put("code",supermodule.getCode());
		supermap.put("selectdate",selectdate);
      try {
    	  List<UserLiveness> superuserlist = dataMapper.getUserByModuleId(supermap);
  		  ArrayList userNamelogin =dataMapper.findmsg(supermap);
  		ArrayList userliveness = new ArrayList();
		ArrayList userlivenesslogin = new ArrayList();
		ArrayList userlivenesspublish = new ArrayList();
		
		for (int i = 1; i <size; i++) {
			Module module = modulelist.get(i);// 定义的版主版主 获取用户的发帖活跃度
			Map<String, Object> modulemap= new HashMap<String, Object>();
			modulemap.put("code",module.getCode());
			modulemap.put("selectdate",selectdate);
		    ArrayList userNamepublish=dataMapper.findmsg(modulemap);
		    int index=0;
		    for(int e=0;e<userNamelogin.size();e++)
	        {
	        	supermap.put("userTid",userNamelogin.get(e));
	        	userlivenesslogin.add(dataMapper.sumliveness(supermap));
	        	if(index<userNamepublish.size())
	        	{
	        		if(userNamepublish.get(index).equals(userNamelogin.get(e)))
		        	{
	        			modulemap.put("userTid",userNamelogin.get(e));
	        			userlivenesspublish.add(dataMapper.sumliveness(modulemap));
		        		index++;
		        	}
	        		else
		        	{//默认添加一个对象，使得id对应各自的活跃度
	        			userlivenesspublish.add("[0]");
		        	}
	        	}
	        	else
	        	{
	        		userlivenesspublish.add("[0]");
	        	}
	        
	        	
	        	String loginString=String.valueOf(userlivenesslogin.get(e));
	        	int loginActivity=Integer.parseInt(loginString.substring(1,loginString.length()-1));
	        	
	        	String publishString=String.valueOf(userlivenesspublish.get(e));
	        	int publishActivity=Integer.parseInt(publishString.substring(1,publishString.length()-1));
	        	userliveness.add("["+(loginActivity+publishActivity)+"]");
	        	String ActivityString=String.valueOf(userliveness.get(e));
	        	int Activity=Integer.parseInt(ActivityString.substring(1,ActivityString.length()-1));
	        	 }
		    
				String bestActivityname = "无";
				int baseActivity = 0;
				if (userNamelogin.size() > 0) {

					String userId = String.valueOf(userNamelogin.get(0));
					bestActivityname = user1Mapper.findUser1ByAccount(userId).getUserName();
					String Activity = String.valueOf(userliveness.get(0));
					baseActivity = Integer.parseInt(Activity.substring(1, Activity.length() - 1));
					for (int z = 0; z < userNamelogin.size(); z++) {
						String activity = String.valueOf(userliveness.get(z));
						int tempActivity = Integer.parseInt(activity.substring(1, activity.length() - 1));
						if (tempActivity > baseActivity) {
							baseActivity = tempActivity;
							String id = String.valueOf(userNamelogin.get(z));
							bestActivityname = user1Mapper.findUser1ByAccount(id).getUserName();
						}
					}
					}
			// 更新当前模块下的前一天数据的最活跃用户项
			String moduleId = module.getCode();
			int m = 0;
			String date = getdate(m);
			Map<String, Object> updatamap= new HashMap<String, Object>();
			updatamap.put("moduleId",moduleId);
			updatamap.put("date",date);
			if(end<29)
			{   
				String oldname=dataMapper.getWeekName(updatamap);
				bestActivityname=oldname+"/"+bestActivityname;
			}
			updatamap.put("bestActivityname",bestActivityname);
			dataMapper.updatesumdatebyActivityUsername(updatamap);
			
			userliveness.clear();
			userlivenesslogin.clear();
			userlivenesspublish.clear();
		}	
		}
		catch(Exception e)
		{
			logger.info("更新上个月最活跃用户名字异常");
			throw new BusinessRunException(e);
		}
	}
	
	public void checkLastWeekActivityUser(int max) throws BusinessRunException
	{
		int daytime=29;
		List<Module> modulelist = moduleMapper.moduleList();
		int size = modulelist.size();
		// 定义的模块0 为超级管理员的版块 获取用户的登陆活跃度
        try {
        	for (int i = 1; i <2; i++) {
 			   String moduleId=modulelist.get(i).getCode();
 			   //获取该模块下最活跃用户的名字
 	           String name=getActivityUserName(max,daytime,moduleId);
 	           Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
 	   		   String year=String.valueOf(c.get(Calendar.YEAR));
 			   String date =year+"-02-28";
 				Map<String, Object> map= new HashMap<String, Object>();
 		        map.put("moduleId",moduleId);
 		        map.put("date",date);
 		        map.put("bestActivityname",name);
 		        //更新用户
 				dataMapper.updatesumdatebyActivityUsername(map);
 			}
		}
		catch(Exception e)
		{
			logger.info("更新  当2月为28天时 三月1号更新上月22-28号周活跃用户异常",e);
			throw new BusinessRunException(e);
		}

	}

	public String getdate(int m) {
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		String year=String.valueOf(c.get(Calendar.YEAR));
		String month;
		String day;
		if (m != 0) {
			month=String.valueOf(c.get(Calendar.MONTH)+1);
			day = String.valueOf(m);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (day.length() < 2) {
				day = "0" + day;
			}
		} else {
			month=String.valueOf(c.get(Calendar.MONTH));
			int max = getmonthday(year, month);
			day = String.valueOf(max);
			if (month.length() < 2) {
				month = "0" + month;
			}
		}
		return year + "-" + month + "-" + day;
	}
	public int getmonthday(String yearStr, String monthStr) {
		int year = Integer.valueOf(yearStr);
		int month = Integer.valueOf(monthStr);
		int maxtemp = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			maxtemp = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			maxtemp = 30;
			break;
		default:
			maxtemp = 28;// 一般为平年
		}
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			if (month == 2) // 闰年的2月为29天
			{
				maxtemp = 29;
			}
		}
		return maxtemp;
	}

	@Override
	public void exportExcel(String moduleName,String year, String month, List<Data> listdata,
			HttpServletResponse response) {
        try {
        	ExportExcel<Data> ee= new ExportExcel<Data>();
    		String[] headers = { "序号", "日期","模块编号","发帖量", "点赞量","最受欢迎帖子","最活跃用户","创建时间","创建人","修改时间","修改人"};
    		String fileName = moduleName+year+"-"+month+"月份数据信息统计表";
    		ee.exportExcel(headers,listdata,fileName,response);
		}
		catch(Exception e)
		{
			logger.info("导出数据报表异常",e);
		}

		
	}
}