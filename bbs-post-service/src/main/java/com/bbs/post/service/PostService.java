package com.bbs.post.service;

import java.util.List;

import com.bbs.domain.PostClass;
import com.bbs.domain.PostVo;
import com.bbs.exception.BusinessRunException;
import com.github.pagehelper.Page;

public interface PostService {
    void savePost(PostVo postVo) throws BusinessRunException;

    Page<Object> getMyPost(String account, Integer currentPage);

    //sitong
    //新增帖子类
    String addPostClass(String module, String postName);

    //更新帖子
    void updatePost(PostVo postVo) throws BusinessRunException;

    //通过code得到帖子
    PostVo getPostByCode(String postCode);

    //获取Id的发帖列表
    List<PostVo> getModulePostList(String moduleCode);

    //返回版块名字
    String getModuleName(String moduleCode);

    //返回帖子类列表
    List<PostClass> getModulePostclassList(String moduleCode);

    //根据帖子的阅读量排序，取前6做为热点帖子
    List<PostVo> selectPostOrderBy6();

    //通过code（实际是原名）更新帖子类名字
    void updatePostByname(String name, String code);

    //通过名字得到帖子类
    PostClass getpostclassByname(String moduleCode,String name);//得到帖子类

    //通过用户Account查询该用户所管理的模块Id
    String getmoduleCodebyAccount(String Account);//得到帖子类

    //通过帖子Code查找模块的Id
    String getmoduleCodebypostCode(String postCode);
    //---------sitong

    /**
     * 搜索帖子业务层
     *
     * @author chenhuayang
     * @version 2018/7/19
     * @version 2018/9/1
     */
    Page<Object> searchingPostInfo(String searchingDetails, Integer searchingType, Integer currentPage, Integer pageSize);

    /**
     * 根据帖子编码搜索帖子业务层(用于帖子详情页)
     *
     * @author chenhuayang
     * @version 2018/7/20
     * @modify wangshixu
     * @version 2018/7/23
     */
    PostVo getPostbyCode(PostVo postVo);

    void deletePostByCode(String postCode);

    /**
     * 添加阅读量统计
     *
     * @author chenhuayang
     * @version 2018/8/9 16:19
     */
    void addReadingAmount(String code, Integer reading);

    /**
     * 添加阅读量统计
     *
     * @author wangshixu
     * @version 2018/8/15 19:19
     */
    Page<Object> getAllPostPage(Integer currentPage, Integer pageSize);

    void updateComment(PostVo postVo);

    /**
     * 根据阅读量获取阅读量前5的帖子
     *
     * @author chenhuayang
     * @version 2018/10/18 15:45
     */
    PostVo PostOrderByReadingAmount1();

    PostVo PostOrderByReadingAmount2();

    PostVo PostOrderByReadingAmount3();

    PostVo PostOrderByReadingAmount4();

    PostVo PostOrderByReadingAmount5();
}