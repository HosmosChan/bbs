package com.bbs.user.mapper;

import java.util.List;

import com.bbs.domain.User;
import com.bbs.domain.UserVo;

public interface UserMapper {
	public User getUser(UserVo userVo);
	public Integer saveUser(User user);
	public List<User> listUser(UserVo userVo);
}
