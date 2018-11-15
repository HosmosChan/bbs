package com.bbs.data.service;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.bbs.domain.Data;
import com.bbs.exception.BusinessRunException;
import com.github.pagehelper.Page;

public interface DataService {
    Page<Object> list(String year, String month, String moduleId, int currentPage);//返回查询的报表数据

    List<Data> listData(String year, String month, String moduleId);//查询报表数据

    void updatePostData(String time, boolean statue, String moduleId);////更新帖子在报表中的数量

    void updatePraiseData(String time, boolean statue, String moduleId);//更新点赞在报表中的数量

    void updateBestPostData(String time, String postName, String moduleId);//更新点赞最多的帖子标题

    void checkBestPost(String time) throws BusinessRunException;//检测最佳标题

    void updateUserLogintimes(String userId, String time, String loginModuleId);//更新用户每天登录次数

    void updateUserPublishtimes(String userId, String time, String loginModuleId);//更新用户每天发帖次数

    void autoCreateNewData(String time) throws BusinessRunException;//每天0点自动创建sumdata表格 数据初始化

    void deletepostclass(String name);//每天0点自动创建sumdata表格 数据初始化

    String[] getlistWeek(List<Data> listdata);

    String getnewtime();

    int getmonthday(String yearStr, String monthStr);//得到上个月的天数

    void checkMonthActivityUser(int end) throws BusinessRunException;//更新月活跃度用户

    void checkBestActivityUser(int daytime) throws BusinessRunException;//更新每周活跃度用户

    void checkLastWeekActivityUser(int max) throws BusinessRunException;//特殊更新 闰年2月 只有28天 需要放到3.1号去更新

    String getActivityUserName(int max, int end, String moduleId);

    void exportExcel(String moduleName, String year, String month, List<Data> listdata, HttpServletResponse response);
}