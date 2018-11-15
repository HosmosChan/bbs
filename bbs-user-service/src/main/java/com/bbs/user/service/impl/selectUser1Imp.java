package com.bbs.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bbs.domain.User1;
import com.bbs.domain.UserVo1;
import com.bbs.user.mapper.User1Mapper;
import com.bbs.user.service.User1Service;

@Service
public class selectUser1Imp implements User1Service {
    /*注入user1Mapper*/
    @Autowired
    private User1Mapper user1Mapper;

    /*根据账号，查找用户*/
    @Override
    public User1 findUserByUsrname(String userName) throws Exception {
        // TODO Auto-generated method stub
        User1 user1 = user1Mapper.findUser1ByName(userName);
        return user1;
    }

    /*用户登录的身份认证*/
    @Override
    public UserVo1 anthentionUser(String userName, String password) throws Exception {
        // TODO Auto-generated method stub
        UserVo1 userVo1 = new UserVo1();
        if (this.findUserByUsrname(userName) != null) {
            userVo1.setUser1(this.findUserByUsrname(userName));
            String db_password = userVo1.getUser1().getPassword();
            if (!db_password.equals(password)) {
                userVo1.setMessage("1");
            } else {
                userVo1.setMessage("2");
            }
        } else {
            userVo1.setUser1(null);
            userVo1.setMessage("3");
        }
        return userVo1;
    }

    /*用户注册信息验证*/
    @Override
    public String addUser(User1 user1, String password2) throws Exception {
        String user_account = user1.getAccount();
        user1.setCreateDate(new Date());
        User1 db_user = user1Mapper.findUser1ByAccount(user_account);
        if (db_user == null) {
            user1Mapper.addUser(user1);
            return "1";
        } else {
            return "该用户已经存在";
        }
    }

    //		if(db_user == null) {
//			if(password2.equals(user_password)){
//				System.out.println(password2);
//				user1Mapper.addUser(user1);
//			}else {
//				throw new Exception("二次密码输入不一致！");
//			}
//		}
//		if(db_user != null) {
//			if(user_password.equals(db_user.getPassword())) {
//				throw new Exception("该用户已经存在");
//			}else {
//				if(password2.equals(db_user.getPassword())) {
//					user1Mapper.addUser(user1);
//				}else {
//					throw new Exception("二次密码输入不一致！");
//			}
//		}
//		}
    /*显示所有的用户信息*/
    @Override
    public List<User1> selectAllUser1() throws Exception {
        // TODO Auto-generated method stub
        List<User1> list = user1Mapper.selectUser();
        return list;
    }

    /*根据用户id，查找用户信息*/
    @Override
    public User1 findUser1ById(int id) throws Exception {
        User1 user1 = user1Mapper.findUser1ById(id);
        return user1;
    }

    /*根据用户id，删除用户信息*/
    @Override
    public void deleteUser1ById(int id) throws Exception {
        user1Mapper.deleteUser1ById(id);
    }

    /*根据用户id，修改用户信息*/
    @Override
    public void updateuser1ById(User1 user1) throws Exception {
        // TODO Auto-generated method stub
        user1Mapper.updateuser1ById(user1);
    }

    /*用户信息的模糊查询*/
    @Override
    public List<User1> FuzzyQueryUser(User1 user1) throws Exception {
        // TODO Auto-generated method stub
        List<User1> list = user1Mapper.FuzzyQueryUser(user1);
        return list;
    }

    @Override
    public User1 findUser1ByAccount(String account) throws Exception {
        User1 user1 = user1Mapper.findUser1ByAccount(account);
        return user1;
    }

    @Override
    public void updateuser1ByAccount(User1 user1) throws Exception {
        user1Mapper.updateuser1ByAccount(user1);
    }
}