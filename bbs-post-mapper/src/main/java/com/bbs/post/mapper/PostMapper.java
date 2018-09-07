package com.bbs.post.mapper;

import java.util.List;
import java.util.Map;

import com.bbs.domain.Post;
import com.bbs.domain.PostClass;

import com.bbs.domain.PostVo;

public interface PostMapper {
    void savePost(PostVo postVo);

    void updatePost(PostVo postVo);

    List<PostVo> getMyPost(String account);

    void addPraise(Map map);//wangshixu 点赞和取消赞，根据map中的flag值进行+1/-1

    Integer getPraiseAmount(String postCode);

    //司铜————————————
    void updateBestPost(Map<String, Object> map2);//根据帖子点赞度 更新数据中最佳帖子

    List<PostClass> getPostClassName(String className);//在版块下查找是否存在某帖子类

    //根据输入时间 获取当天点赞最多的帖子
    List<PostVo> getBestPost(Map<String, Object> map);

    void AddPostClassName(PostClass postclass);//添加帖子类名

    List<PostClass> getPostClass();//返回帖子类表

    String getModuleCode(String module);//根据版块名返回版块code

    List<PostVo> getPostListByModuleCode(String moduleCode);//通过模块Id返回全部的帖子列表

    List<PostClass> getPostclassListByModuleCode(String moduleCode);//通过模块Id返回全部的帖子类列表

    String getModuleName(String moduleCode);//返回模块名字

    void updatepostclassByname(Map<String, Object> map);//更新信息

    PostClass getpostclassByname(String name);//得到帖子类

    List<PostVo> selectPostOrderBy6();//根据帖子的阅读量排序，取前6做为热点帖子

    String getmoduleCodebypostCode(String postCode);//通过帖子Code查找模块的Id

    //未实现
    //——————————司铜
    PostVo getPostByCode(String postCode);

    /**
     * 搜索帖子对象持久化映射层(1：根据标题搜索；2：根据作者搜索；3：根据发表时间搜索)
     *
     * @author chenhuayang
     * @version 2018/7/19
     */
    List<PostVo> searchingPostInfo1(String title);

    List<PostVo> searchingPostInfo2(String userName);

    List<PostVo> searchingPostInfo3(String publishDate);

    void deletePostByCode(String code);

    /**
     * 添加阅读量统计
     *
     * @author chenhuayang
     * @version 2018/8/9 16:19
     */
    void addReadingAmount(Map map);

    String getmoduleCodebyAccount(String Account);

    List<PostVo> getAllPost();
}