package com.bbs.role.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.data.mapper.DataMapper;
import com.bbs.domain.Module;
import com.bbs.domain.Role;
import com.bbs.domain.User1;
import com.bbs.domain.UserLiveness;
import com.bbs.post.mapper.ModuleMapper;
import com.bbs.role.mapper.RoleMapper;
import com.bbs.role.service.RoleService;
import com.bbs.user.mapper.User1Mapper;

/**
 * @author:tanglei
 * @Create time:2018年7月17日
 * @ClassName:
 * @Description:
 */

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private User1Mapper user1Mapper;
	@Autowired
	private ModuleMapper moduleMapper;
	@Autowired
	private DataMapper dataMapper;

	@Override
	public List<Role> selectRole() throws Exception {
		List<Role> list = roleMapper.selectRole();
		return list;
	}

	@Override
	public void addRoleUser(User1 user1, String password2) throws Exception {
		String user_account = user1.getAccount();	
		user1.setCreateDate(new Date());
		
		User1 db_user = user1Mapper.findUser1ByAccount(user_account);
		
		if(db_user == null) {
			user1Mapper.addUser(user1);
		}else{
			throw new Exception("该用户已经存在");
		}
		

	}

	@Override
	public User1 findUserByRoleUser(String account) throws Exception {
		// TODO Auto-generated method stub

		User1 user1 = user1Mapper.findUser1ByName(account);
		return user1;
	}

	@Override
	public User1 roleAnthentionUser(String account, String password) throws Exception {
		// TODO Auto-generated method stub

		User1 user1 = this.findUserByRoleUser(account);
                      
 		String db_password = user1.getPassword();

		String db_roleName = user1.getRoleName();

		String role = "管理员";

		if (!db_password.equals(password)) {

			throw new Exception("密码错误");
		}
		if (!db_roleName.equals(role)) {
			throw new Exception("您不是管理员，无此权限！");
		}
		return user1;

	}
	
	
	@Override
	public List<User1> listUserByRole() {
		
		return roleMapper.listUserByRole();
	}
	
	@Override
	public void checkBestActivityUser(int daytime) {

		Date my = new Date();
		List<Module> modulelist = moduleMapper.moduleList();
		int size = modulelist.size();
		// 定义的模块0 为超级管理员的版块 获取用户的登陆活跃度
		Module supermodule = modulelist.get(0);
		for (int i = 1; i < size; i++) {
			Module module = modulelist.get(i);// 定义的版主 获取用户的发帖活跃度
			ArrayList usertid = new ArrayList();
			ArrayList userliveness = new ArrayList();
			for (int m = daytime - 7; m < daytime; m++) {
				String selectdate = getdate(m);
				Map<String, Object> map= new HashMap<String, Object>();
		        map.put("code",supermodule.getCode());
		        map.put("selectdate",selectdate);
		        Map<String, Object> map2= new HashMap<String, Object>();
		        map2.put("code",module.getCode());
		        map2.put("selectdate",selectdate);
				List<UserLiveness> superuserlist = dataMapper.getUserByModuleId(map);
				List<UserLiveness> userlist = dataMapper.getUserByModuleId(map2);
			
				if (!userlist.isEmpty() && !superuserlist.isEmpty()) {
					for (int k = 0; k < userlist.size(); k++) {
						String id = userlist.get(k).getUserTid();
						int liveness = userlist.get(k).getUserLiveness() + superuserlist.get(0).getUserLiveness();
						if (usertid.indexOf(id) < 0) {
							usertid.add(id);
							userliveness.add(liveness);
						}

						else {
							// 得到id的返回ID
							int index = usertid.indexOf(id);
							int oldliveness = Integer.valueOf(String.valueOf(userliveness.get(index)));
							userliveness.set(index, oldliveness + liveness);
						}
					}
				}
			}
			
			if (usertid.size() > 0) {
				
				String Accont=String.valueOf(usertid.get(0));
				String bestActivityname = user1Mapper.findUser1ByAccount(Accont).getUserName();
				int baseActivity = Integer.valueOf(String.valueOf(userliveness.get(0)));
				for (int z = 0; z < usertid.size(); z++) {
					int tempActivity = Integer.valueOf(String.valueOf(userliveness.get(z)));
					if (tempActivity > baseActivity) {
						baseActivity = tempActivity;
						String id =String.valueOf(usertid.get(z));
						bestActivityname = user1Mapper.findUser1ByAccount(id).getUserName();
					}
				}
				// 更新当前模块下的前一天数据的最活跃用户项
				String moduleId = module.getCode();
				String date = getdate(daytime - 1);
				Map<String, Object> map= new HashMap<String, Object>();
		        map.put("moduleId",moduleId);
		        map.put("date",date);
		        map.put("bestActivityname",bestActivityname);
		       //System.err.println("模块为"+moduleId+"用户名");
				dataMapper.updatesumdatebyActivityUsername(map);
			}

		}

	}

	public void checkMonthActivityUser() {
		// 初始化数据
		ArrayList usertid = new ArrayList();
		ArrayList userliveness = new ArrayList();
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		String year=String.valueOf(c.get(Calendar.YEAR));
		String lastmonth=String.valueOf(c.get(Calendar.MONTH));//更新上一个的数据
		
		int maxday = getmonthday(year, lastmonth);
		if (lastmonth.length() < 2)
			lastmonth = "0" + lastmonth;

		List<Module> modulelist = moduleMapper.moduleList();
		// 定义的模块0 为超级管理员的版块 获取用户的登陆活跃度
		Module supermodule = modulelist.get(0);
		int size = modulelist.size();
		for (int i = 1; i < size; i++) {
			Module module = modulelist.get(i);// 定义的版主版主 获取用户的发帖活跃度
			for (int m = 1; m < maxday + 1; m++) {
				String day = null;
				if (m < 10)
					day = "0" + m;
				else
					day = String.valueOf(m);
				String selectdate = year + "-" + lastmonth + "-" + day;
				Map<String, Object> map= new HashMap<String, Object>();
		        map.put("code",supermodule.getCode());
		        map.put("selectdate",selectdate);
		        Map<String, Object> map2= new HashMap<String, Object>();
		        map2.put("code",module.getCode());
		        map2.put("selectdate",selectdate);
				List<UserLiveness> superuserlist = dataMapper.getUserByModuleId(map);
				List<UserLiveness> userlist = dataMapper.getUserByModuleId(map2);

				if (!userlist.isEmpty() && !superuserlist.isEmpty()) {
					for (int k = 0; k < userlist.size(); k++) {
						int id = Integer.valueOf(userlist.get(k).getUserTid());
						int liveness = userlist.get(k).getUserLiveness() + superuserlist.get(0).getUserLiveness();
						if (usertid.indexOf(id) < 0) {
							usertid.add(id);
							userliveness.add(liveness);
						}

						else {
							// 得到id的返回ID
							int index = usertid.indexOf(id);
							int oldliveness = Integer.valueOf(String.valueOf(userliveness.get(index)));
							userliveness.set(index, oldliveness + liveness);
						}
					}
				}
			}
			if (usertid.size() > 0) {
				String bestActivityname = user1Mapper.findUser1ByAccount(String.valueOf(usertid.get(0))).getUserName();
				int baseActivity = Integer.valueOf(String.valueOf(userliveness.get(0)));
				for (int z = 0; z < usertid.size(); z++) {
					int tempActivity = Integer.valueOf(String.valueOf(userliveness.get(z)));
					if (tempActivity > baseActivity) {
						baseActivity = tempActivity;
						int id = Integer.valueOf(String.valueOf(usertid.get(z)));
						bestActivityname = user1Mapper.findUser1ById(id).getUserName();
					}
				}
				// System.out.println("本月最活跃用户为"+bestActivityname+"活跃度为"+baseActivity);
				// 更新当前模块下的前一天数据的最活跃用户项
				String moduleId = module.getCode();
				int m = 0;
				String date = getdate(m);
				Map<String, Object> map= new HashMap<String, Object>();
		        map.put("moduleId",moduleId);
		        map.put("date",date);
		        map.put("bestActivityname",bestActivityname);
				dataMapper.updatesumdatebyActivityUsername(map);
			}
		}

	}
	
	public void checkLastWeekActivityUser()
	{
		// 初始化数据
				ArrayList usertid = new ArrayList();
				ArrayList userliveness = new ArrayList();
				Date my = new Date();

				String year = String.valueOf(my.getYear() + 1900);
				String lastmonth = String.valueOf(my.getMonth());// 上个月 测试更新七月
				int maxday =28;
				if (lastmonth.length() < 2)
					lastmonth = "0" + lastmonth;

				List<Module> modulelist = moduleMapper.moduleList();
				// 定义的模块0 为超级管理员的版块 获取用户的登陆活跃度
				Module supermodule = modulelist.get(0);
				int size = modulelist.size();
				for (int i = 1; i < size; i++) {
					Module module = modulelist.get(i);// 定义的版主版主 获取用户的发帖活跃度
					for (int m = 22; m < maxday + 1; m++) {
						String day = String.valueOf(m);
						String selectdate = year + "-" + lastmonth + "-" + day;
						Map<String, Object> map= new HashMap<String, Object>();
				        map.put("code",supermodule.getCode());
				        map.put("selectdate",selectdate);
				        Map<String, Object> map2= new HashMap<String, Object>();
				        map2.put("code",module.getCode());
				        map2.put("selectdate",selectdate);
						List<UserLiveness> superuserlist = dataMapper.getUserByModuleId(map);
						List<UserLiveness> userlist = dataMapper.getUserByModuleId(map2);

						if (!userlist.isEmpty() && !superuserlist.isEmpty()) {
							for (int k = 0; k < userlist.size(); k++) {
								int id = Integer.valueOf(userlist.get(k).getUserTid());
								int liveness = userlist.get(k).getUserLiveness() + superuserlist.get(0).getUserLiveness();
								if (usertid.indexOf(id) < 0) {
									usertid.add(id);
									userliveness.add(liveness);
								}

								else {
									// 得到id的返回ID
									int index = usertid.indexOf(id);
									int oldliveness = Integer.valueOf(String.valueOf(userliveness.get(index)));
									userliveness.set(index, oldliveness + liveness);
								}
							}
						}
					}
					if (usertid.size() > 0) {
						String bestActivityname = user1Mapper.findUser1ByAccount(String.valueOf(usertid.get(0))).getUserName();
						int baseActivity = Integer.valueOf(String.valueOf(userliveness.get(0)));
						for (int z = 0; z < usertid.size(); z++) {
							int tempActivity = Integer.valueOf(String.valueOf(userliveness.get(z)));
							if (tempActivity > baseActivity) {
								baseActivity = tempActivity;
								int id = Integer.valueOf(String.valueOf(usertid.get(z)));
								bestActivityname = user1Mapper.findUser1ById(id).getUserName();
							}
						}
						// 更新当前模块下的前一天数据的最活跃用户项
						String moduleId = module.getCode();
						int m =0;
						String date = getdate(m);
						Map<String, Object> map= new HashMap<String, Object>();
				        map.put("moduleId",moduleId);
				        map.put("date",date);
				        map.put("bestActivityname",bestActivityname);
						dataMapper.updatesumdatebyActivityUsername(map);
						System.out.println("更新上一个月最后一周活跃用户成功");
					}
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
		// TODO Auto-generated method stub
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