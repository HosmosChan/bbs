package com.bbs.user.service;

import java.util.List;

import com.bbs.domain.User;
import com.bbs.domain.UserVo;
import com.bbs.exception.BusinessRunException;

public interface UserService {
    User getUser(UserVo userVo);

    Integer saveUser(User user) throws BusinessRunException;

    List<User> listUser(UserVo userVo);
}
