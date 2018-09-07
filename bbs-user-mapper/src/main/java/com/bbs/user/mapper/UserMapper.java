package com.bbs.user.mapper;

import java.util.List;

import com.bbs.domain.User;
import com.bbs.domain.UserVo;

public interface UserMapper {
    User getUser(UserVo userVo);

    Integer saveUser(User user);

    List<User> listUser(UserVo userVo);
}
