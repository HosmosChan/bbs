package com.bbs.post.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbs.domain.PostVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.domain.PostClass;
import com.bbs.exception.BusinessRunException;
import com.bbs.post.mapper.PostClassMapper;
import com.bbs.post.mapper.PostMapper;
import com.bbs.post.service.PostService;
import com.bbs.utils.GETuuid;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class PostServiceImpl implements PostService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostClassMapper postClassMapper;
    /**
     * 保存帖子
     *
     * @throws BusinessRunException
     * @author wangshixu
     */
    @Override
    @Transactional(rollbackFor = BusinessRunException.class)
    public void savePost(PostVo postVo) throws BusinessRunException {
        try {
            postVo.setCode(GETuuid.getUUID());
            String postClassName = postVo.getPostClassCode();
            PostClass postClass = postClassMapper.getPostClassByClassName(postClassName);
            postVo.setPostClassCode(postClass.getCode());
            postVo.setModuleCode(postClass.getModuleCode());
            postVo.setPublishDate(new Date());
            postVo.setCreateBy("admin");
            postVo.setCreateDate(new Date());
            postMapper.savePost(postVo);
        } catch (Exception e) {
            logger.info("保存帖子异常", e);
            throw new BusinessRunException(e);
        }
    }

    @Override
    public Page<Object> getMyPost(String account,Integer currentPage) {
        Page<Object> page = PageHelper.startPage(currentPage, 10);
        postMapper.getMyPost(account);
        return page;
    }

    @Override
    public void updatePost(PostVo postVo) {
        postMapper.updatePost(postVo);
    }

    @Override
    public PostVo getPostByCode(String postCode) {
        return postMapper.getPostByCode(postCode);
    }

    /**
     * 根据标题搜索帖子数据访问层
     *
     * @author chenhuayang
     * @version 2018/7/19
     */
    @Override
    public List<PostVo> searchingPostInfo1(String title) {
        // TODO Auto-generated method stub
        return postMapper.searchingPostInfo1(title);
    }
    /**
     * 根据作者搜索帖子数据访问层
     *
     * @author chenhuayang
     * @version 2018/7/19
     */
    @Override
    public List<PostVo> searchingPostInfo2(String userName) {
        // TODO Auto-generated method stub
        return postMapper.searchingPostInfo2(userName);
    }
    /**
     * 根据发表时间搜索帖子数据访问层
     *
     * @author chenhuayang
     * @version 2018/7/19
     */
    @Override
    public List<PostVo> searchingPostInfo3(String publishDate) {
        // TODO Auto-generated method stub
        return postMapper.searchingPostInfo3(publishDate);
    }
    /**
     * 根据code获取帖子的详情
     * autor：wangshixu 2018/7/23
     */
    @Override
    public PostVo getPostbyCode(PostVo postVo) {
        return postMapper.getPostByCode(postVo.getCode());
    }

    @Override
    public String addPostClass(String modulecode, String className) {
        // TODO Auto-generated method stub
    	String msg = null;
        System.out.println(postMapper.getPostClassName(className).size());
        if (postMapper.getPostClassName(className).size() == 0)//如果没有在module模块下找到该类贴
        {
             try {
                PostClass postclass = new PostClass();
                postclass.setCode(GETuuid.getUUID());
                postclass.setModuleCode(modulecode);
                postclass.setClassName(className);
                postclass.setCreateBy("admin");
                postclass.setCreateDate(new Date());
                postMapper.AddPostClassName(postclass);
                msg = "succeed";
            } catch (Exception e) {
                logger.info("新增帖子类别异常", e);
            }
        } else {
            msg = "failed";
            return msg;
        }
        return msg;
    }

    @Override
    public List<PostVo> getModulePostList(String moduleCode) {
        // TODO Auto-generated method stub
        List<PostVo> postlist = postMapper.getPostListByModuleCode(moduleCode);
        return postlist;
    }

    @Override
    public String getModuleName(String moduleCode) {
        // TODO Auto-generated method stub
        String name = postMapper.getModuleName(moduleCode);
        return name;
    }

    @Override
    public List<PostClass> getModulePostclassList(String moduleCode) {
        // TODO Auto-generated method stub
        List<PostClass> postclasslist = postMapper.getPostclassListByModuleCode(moduleCode);
        return postclasslist;
    }

    @Override
    public void deletePostByCode(String postCode) {
        postMapper.deletePostByCode(postCode);
        
    }
    
    /**
     * 添加阅读量统计
     *
     * @author chenhuayang
     * @version 2018/8/9 16:19
     */
    @Override
    public void addReadingAmount(String code, Integer reading) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("reading", reading);
        postMapper.addReadingAmount(map);
    }
    /***********************添加阅读量统计   结束**************************/

	@Override
	public List<PostVo> selectPostOrderBy6() {
		List<PostVo> PostOrderByList = postMapper.selectPostOrderBy6();
		return PostOrderByList;
	}
    /**
     * 添加阅读量统计
     *
     * @author wangshixu
     * @version 2018/8/13 18:26
     */
	@Override
	public Page<Object> getAllPostPage( Integer currentPage, Integer pageSize) {
		Page<Object> page = PageHelper.startPage(currentPage, pageSize);
		postMapper.getAllPost();
		return page;
	}

	@Override
	public void updatePostByname(String name, String code) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("code",code);
		postMapper.updatepostclassByname(map);
	}

	@Override
	public PostClass getpostclassByname(String name) {
		// TODO Auto-generated method stub
		return postMapper.getpostclassByname(name);
	}

	@Override
	public String getmoduleCodebyAccount(String Account) {
		// TODO Auto-generated method stub
		return postMapper.getmoduleCodebyAccount(Account);//得到帖子类;
	}

	@Override
	public String getmoduleCodebypostCode(String postCode) {
		// TODO Auto-generated method stub
		return postMapper.getmoduleCodebypostCode(postCode);
	}
}
