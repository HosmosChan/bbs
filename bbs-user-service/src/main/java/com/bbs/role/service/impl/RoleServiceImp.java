package com.bbs.role.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bbs.data.mapper.DataMapper;
import com.bbs.domain.Role;
import com.bbs.domain.User1;
import com.bbs.domain.UserVo1;
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
        if (db_user == null) {
            user1Mapper.addUserRole(user1);
        } else {
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
    public List<User1> listUserByRole() {
        return roleMapper.listUserByRole();
    }

    @Override
    public UserVo1 roleAnthentionUser(String account, String password) throws Exception {
        UserVo1 userVo1 = new UserVo1();
        if (this.findUserByRoleUser(account) != null) {
            userVo1.setUser1(this.findUserByRoleUser(account));
            String db_password = userVo1.getUser1().getPassword();
            String db_roleName = userVo1.getUser1().getRoleName();
            String role = "管理员";
            if (!db_password.equals(password)) {
                userVo1.setMessage("1");
            }
            if (db_password.equals(password)) {
                if (!role.equals(db_roleName)) {
                    userVo1.setMessage("2");
                }
                if (role.equals(db_roleName)) {
                    userVo1.setMessage("3");
                }
            }
        } else {
            userVo1.setUser1(null);
            userVo1.setMessage("4");
        }
        return userVo1;
    }

    @Override
    public int getManageNumber() {
        return roleMapper.getManageNumber();
    }
}