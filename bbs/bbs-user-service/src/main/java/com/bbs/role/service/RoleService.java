package com.bbs.role.service;

import java.util.List;

import com.bbs.domain.Module;
import com.bbs.domain.Role;
import com.bbs.domain.User1;

/**
* @author:tanglei
* @Create time:2018年7月17日
* @ClassName:
* @Description:
*/
public interface RoleService {

	public List<Role> selectRole() throws Exception;
	
	public void addRoleUser(User1 user1,String password2) throws Exception;
	
	public User1 findUserByRoleUser(String account) throws Exception;
	
	public User1 roleAnthentionUser(String account,String password) throws Exception; 
	
	public List<User1> listUserByRole(); 
	//sitong
	public int getmonthday(String yearStr, String monthStr);//得到上个月的天数
	public void checkMonthActivityUser();//更新月活跃度用户
	public void checkBestActivityUser(int daytime);//更新每周活跃度用户
	public void checkLastWeekActivityUser();//特殊更新 闰年2月 只有28天 需要放到3.1号去更新
	///sitong
}
