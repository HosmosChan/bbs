package com.bbs.data.service;

import java.util.List;

import com.bbs.domain.Data;
import com.github.pagehelper.Page;

public interface DataService {
   

	public Page<Object> list(String year,String month,String moduleId,int currentPage);//返回查询的报表数据
	public List<Data> listData(String year,String month,String moduleId);//查询报表数据
	public void updatePostData(String time,boolean statue,String moduleId);////更新帖子在报表中的数量
	public void updatePraiseData(String time,boolean statue,String moduleId);//更新点赞在报表中的数量
	public void updateBestPostData(String time,String postName,String moduleId);//更新点赞最多的帖子标题
	public void checkBestPost(String time);//检测最佳标题
	public void updateUserLogintimes(String userId, String  time,String loginModuleId);//更新用户每天登录次数
	public void updateUserPublishtimes(String userId, String  time,String loginModuleId);//更新用户每天发帖次数
	public void autoCreateNewData(String time);//每天0点自动创建sumdata表格 数据初始化
	public void deletepostclass(String name);//每天0点自动创建sumdata表格 数据初始化
	public String[] getlistWeek(List<Data> listdata);
	public String getnewtime();	
	public int getmonthday(String year,String month);
}