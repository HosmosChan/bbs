package com.bbs.role.service;

import java.util.List;

import com.bbs.domain.Role;
import com.bbs.domain.User1;
import com.bbs.domain.UserVo1;

/**
 * @author:tanglei
 * @Create time:2018年7月17日
 * @ClassName:
 * @Description:
 */
public interface RoleService {
    List<Role> selectRole() throws Exception;

    void addRoleUser(User1 user1, String password2) throws Exception;

    User1 findUserByRoleUser(String account) throws Exception;

    UserVo1 roleAnthentionUser(String account, String password) throws Exception;

    List<User1> listUserByRole();

    //sitong
    int getmonthday(String yearStr, String monthStr);//得到上个月的天数

    void checkMonthActivityUser();//更新月活跃度用户

    void checkBestActivityUser(int daytime);//更新每周活跃度用户

    void checkLastWeekActivityUser();//特殊更新 闰年2月 只有28天 需要放到3.1号去更新
    //sitong

	int getManageNumber();

}