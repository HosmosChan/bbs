package com.bbs.data.mapper;

import java.util.List;
import java.util.Map;

import com.bbs.domain.Data;
import com.bbs.domain.UserLiveness;
public interface DataMapper {
	//根据模块Id和find进行模糊查找返回报表数据
	public List<Data> listData(Map<String, Object> map);
	//根据模块Id和具体时间返回报表数据
	public Data getData(Map<String, Object> map);
	//获得当天用户在某模块的发贴和登录纪录
	public UserLiveness getLoginUser(Map<String, Object> map);
	//根据模块Id和时间返回所有用户的发帖和登录记录
	public List<UserLiveness> getUserByModuleId(Map<String, Object> map);
	
	//根据报表数据来更新当前行数据
	public void updateData(Data data);
	//根据用户活跃度数据来更新当前行数据
	public void updateUserLiveness(UserLiveness userLiveness);
	//更新最佳活跃用户
	public void updatesumdatebyActivityUsername(Map<String, Object> map);
	
	//保存用户活跃度
	public void saveUserLiveness(UserLiveness userLiveness);
	//为所有模块创建当天的报表数据行
	public void autoCreateNewData(Data data);
	//根据名字删除帖子类（建立在帖子类名唯一性的基础上）
	public void deletepostclass(String name);
	
	
	
	
	
}
