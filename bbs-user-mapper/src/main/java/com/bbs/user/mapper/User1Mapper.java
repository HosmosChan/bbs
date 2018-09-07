package com.bbs.user.mapper;

import java.util.List;

import com.bbs.domain.User1;

public interface User1Mapper {
    List<User1> selectUser();

    void addUser(User1 user1);

    User1 findUser1ByName(String userName);

    User1 findUser1ById(int id);

    void deleteUser1ById(int id);

    void updateuser1ById(User1 user1);

    List<User1> FuzzyQueryUser(User1 user1);

    User1 findUser1ByAccount(String account);

    void updateuser1ByAccount(User1 user1);
}
