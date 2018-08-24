package com.bbs.post.mapper;

import java.util.List;
import java.util.Map;

import com.bbs.domain.Post;
import com.bbs.domain.PostClass;

import com.bbs.domain.PostVo;

public interface PostMapper {
    public void savePost(PostVo postVo);

    public void updatePost(PostVo postVo);

    public List<PostVo> getMyPost(String account);

    public void addPraise(Map map);//wangshixu 点赞和取消赞，根据map中的flag值进行+1/-1

    public Integer getPraiseAmount(String postCode);

  //司铜————————————
    public void updateBestPost(Map<String, Object> map2);//根据帖子点赞度 更新数据中最佳帖子

    public List<PostClass> getPostClassName(String className);//在版块下查找是否存在某帖子类

    //根据输入时间 获取当天点赞最多的帖子
    public List<PostVo> getBestPost(Map<String, Object> map);
    public void AddPostClassName(PostClass postclass);//添加帖子类名

    public List<PostClass> getPostClass();//返回帖子类表

    public String getModuleCode(String module);//根据版块名返回版块code

    public List<PostVo> getPostListByModuleCode(String moduleCode);//通过模块Id返回全部的帖子列表

    public List<PostClass> getPostclassListByModuleCode(String moduleCode);//通过模块Id返回全部的帖子类列表

    public String getModuleName(String moduleCode);//返回模块名字
    
    public void updatepostclassByname(Map<String, Object> map);//更新信息
   
    public PostClass getpostclassByname(String name);//得到帖子
   
	public List<PostVo> selectPostOrderBy6();//根据帖子的阅读量排序，取前6做为热点帖子

	public String getmoduleCodebypostCode(String postCode);//通过帖子Code查找模块的Id
	
    //未实现
    //——————————司铜
    public PostVo getPostByCode(String postCode);

    /**
     * 搜索帖子对象持久化映射层(1：根据标题搜索；2：根据作者搜索；3：根据发表时间搜索)
     *
     * @author chenhuayang
     * @version 2018/7/19
     */
    public List<PostVo> searchingPostInfo1(String title);

    public List<PostVo> searchingPostInfo2(String userName);

    public List<PostVo> searchingPostInfo3(String publishDate);

    /*************************根据帖子编码搜索帖子对象持久化映射层(用于帖子详情页)	结束*************************/
    public void deletePostByCode(String code);
    /**
     * 添加阅读量统计
     *
     * @author chenhuayang
     * @version 2018/8/9 16:19
     */
    public void addReadingAmount(Map map);
    /***********************添加阅读量统计   结束**************************/

	public String getmoduleCodebyAccount(String Account);
	
	public List<PostVo> getAllPost();

}
