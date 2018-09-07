package com.bbs.user.service;

import java.util.List;

import com.bbs.domain.User1;
import com.bbs.domain.UserVo1;

public interface User1Service {
    List<User1> selectAllUser1() throws Exception;

    String addUser(User1 user1, String password2) throws Exception;

    User1 findUserByUsrname(String userName) throws Exception;

    UserVo1 anthentionUser(String userName, String password) throws Exception;

    User1 findUser1ById(int id) throws Exception;

    void deleteUser1ById(int id) throws Exception;

    void updateuser1ById(User1 user1) throws Exception;

    List<User1> FuzzyQueryUser(User1 user1) throws Exception;

    User1 findUser1ByAccount(String account) throws Exception;

    void updateuser1ByAccount(User1 user1) throws Exception;
}