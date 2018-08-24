package com.bbs.user.service;

import java.util.List;

import com.bbs.domain.User;
import com.bbs.domain.UserVo;
import com.bbs.exception.BusinessRunException;

public interface UserService {
	public User getUser(UserVo userVo);
	public Integer saveUser(User user) throws BusinessRunException;
	public List<User> listUser(UserVo userVo);
}
