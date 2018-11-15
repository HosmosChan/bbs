package com.bbs.role.mapper;

import java.util.List;

import com.bbs.domain.Role;
import com.bbs.domain.User1;

/**
 * @author:tanglei
 * @Create time:2018年7月17日
 * @ClassName:
 * @Description:
 */
public interface RoleMapper {
    public List<Role> selectRole();

    public void addRoleUser(User1 user1);

    public List<User1> listUserByRole();

    public User1 getUserById(Integer tid);

    public int getManageNumber();
}