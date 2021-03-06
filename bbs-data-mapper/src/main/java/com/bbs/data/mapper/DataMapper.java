package com.bbs.data.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bbs.domain.Data;
import com.bbs.domain.UserLiveness;

public interface DataMapper {
    //根据模块Id和find进行模糊查找返回报表数据
    List<Data> listData(Map<String, Object> map);

    //根据模块Id和具体时间返回报表数据
    Data getData(Map<String, Object> map);

    //获得当天用户在某模块的发贴和登录纪录
    UserLiveness getLoginUser(Map<String, Object> map);

    //根据模块Id和时间返回所有用户的发帖和登录记录
    List<UserLiveness> getUserByModuleId(Map<String, Object> map);

    //根据报表数据来更新当前行数据
    void updateData(Data data);

    //根据用户活跃度数据来更新当前行数据
    void updateUserLiveness(UserLiveness userLiveness);

    //更新最佳活跃用户
    void updatesumdatebyActivityUsername(Map<String, Object> map);

    //最佳活跃用户 特例 当月28天时 需要将周、月用户存在一起 获取当前存储的用户名字
    String getWeekName(Map<String, Object> updatamap);

    //保存用户活跃度
    void saveUserLiveness(UserLiveness userLiveness);

    //为所有模块创建当天的报表数据行
    void autoCreateNewData(Data data);

    //根据名字删除帖子类（建立在帖子类名唯一性的基础上）
    void deletepostclass(String name);

    ArrayList findmsg(Map<String, Object> map);

    ArrayList sumliveness(Map<String, Object> map);
}