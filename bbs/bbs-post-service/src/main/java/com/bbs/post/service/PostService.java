package com.bbs.post.service;

import java.util.List;

import com.bbs.domain.PostClass;
import com.bbs.domain.PostVo;
import com.bbs.exception.BusinessRunException;
import com.github.pagehelper.Page;

public interface PostService {

    public void savePost(PostVo postVo) throws BusinessRunException;

    Page<Object> getMyPost(String account, Integer currentPage);

    //sitong
    //新增帖子类
    public String addPostClass(String module, String postName);
    //更新帖子
    public void updatePost(PostVo postVo) throws BusinessRunException;
    //通过code得到帖子
    public PostVo getPostByCode(String postCode);
     //获取Id的发帖列表
    public List<PostVo> getModulePostList(String moduleCode);
    //返回版块名字
    public String getModuleName(String moduleCode);
    //返回帖子类列表
    public List<PostClass> getModulePostclassList(String moduleCode);
    //根据帖子的阅读量排序，取前6做为热点帖子
    public List<PostVo> selectPostOrderBy6();
    //通过code（实际是原名）更新帖子类名字
    public void updatePostByname(String name,String code);
    //通过名字得到帖子类
    public PostClass getpostclassByname(String name);//得到帖子类
    //通过用户Account查询该用户所管理的模块Id
    public String getmoduleCodebyAccount(String Account);//得到帖子类
    //通过帖子Code查找模块的Id
    public String getmoduleCodebypostCode(String postCode);
    //---------sitong

    /**
     * 搜索帖子业务层(1：根据标题搜索；2：根据作者搜索；3：根据发表时间搜索)
     *
     * @author chenhuayang
     * @version 2018/7/19
     */
    public List<PostVo> searchingPostInfo1(String title);

    public List<PostVo> searchingPostInfo2(String userName);

    public List<PostVo> searchingPostInfo3(String publishDate);
    /*************************搜索帖子业务层	结束*************************/
    /**
     * 根据帖子编码搜索帖子业务层(用于帖子详情页)
     *
     * @author chenhuayang
     * @version 2018/7/20
     * @modify wangshixu
     * @version 2018/7/23
     */
    public PostVo getPostbyCode(PostVo postVo);

    /*************************根据帖子编码搜索帖子业务层(用于帖子详情页)	结束*************************/
    public void deletePostByCode(String postCode);
    /**
     * 添加阅读量统计
     *
     * @author chenhuayang
     * @version 2018/8/9 16:19
     */
    public void addReadingAmount(String code, Integer reading);
    /***********************添加阅读量统计   结束**************************/
    /**
     * 添加阅读量统计
     *
     * @author wangshixu
     * @version 2018/8/15 19:19
     */
	public Page<Object> getAllPostPage( Integer currentPage, Integer pageSize);
}