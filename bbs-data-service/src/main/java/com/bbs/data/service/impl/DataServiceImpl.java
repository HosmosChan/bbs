package com.bbs.data.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbs.domain.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.data.mapper.DataMapper;
import com.bbs.post.mapper.ModuleMapper;
import com.bbs.post.mapper.PostMapper;
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

	@Override
	public Page<Object> list(String year, String month, String moduleId, int currentPage) {
		Page<Object> page = PageHelper.startPage(currentPage, 7);
		List<Data> Datatest = listData(year, month, moduleId);
		return page;
	}

	// fromsitong
	@Override
	public List<Data> listData(String year, String month, String moduleId) {

		String date = year + "-" + month;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", date);
		map.put("moduleId", moduleId);
		List<Data> Datatest = dataMapper.listData(map);
		List<Data> Datalist = new ArrayList();
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

	public void checkBestPost(String time) {
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
	}

//		定时函数 每天0点在sumdata表格中创建一个新的模块数据
	@Override
	public void autoCreateNewData(String time) {
		List<Module> modulelist = moduleMapper.moduleList();
		int size = modulelist.size();
		for (int i = 1; i < size; i++) {
			String moduleId = modulelist.get(i).getCode();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("time", time);
			map.put("moduleId", moduleId);
			if (dataMapper.getData(map) == null) {
				Data data = new Data();
				data.setDay(time);
				data.setSumPost(0);
				data.setSumPraise(0);
				data.setModuleId(moduleId);
				data.setMaxPraisePostName("今日暂无发帖");
				data.setBestActiviteUsername("");
				data.setCreateDate(new Date());
				data.setCreateBy("admin");
				dataMapper.autoCreateNewData(data);
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
	// bysitong

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
								listWeek[tag] = "第四周最活跃用户： " + name;
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
}