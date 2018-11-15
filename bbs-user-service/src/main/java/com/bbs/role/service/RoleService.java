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

    int getManageNumber();
}