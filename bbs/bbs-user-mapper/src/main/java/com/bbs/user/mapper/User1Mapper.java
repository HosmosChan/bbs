package com.bbs.user.mapper;

import java.util.List;

import com.bbs.domain.User1;

public interface User1Mapper {
	
	public List<User1> selectUser();
	
	public void addUser(User1 user1);

	public User1 findUser1ByName(String userName);
	
	public User1 findUser1ById(int id);
	
	public void deleteUser1ById(int id);
    
	public void updateuser1ById(User1 user1);

	public List<User1> FuzzyQueryUser(User1 user1);

	public User1 findUser1ByAccount(String account);

	public void updateuser1ByAccount(User1 user1);
}
