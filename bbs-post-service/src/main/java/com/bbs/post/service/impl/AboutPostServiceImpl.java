package com.bbs.post.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.domain.Comment;
import com.bbs.domain.Module;
import com.bbs.domain.PostClass;
import com.bbs.domain.PostVo;
import com.bbs.domain.User1;
import com.bbs.exception.BusinessRunException;
import com.bbs.post.mapper.CommentMapper;
import com.bbs.post.mapper.ModuleMapper;
import com.bbs.post.mapper.PostClassMapper;
import com.bbs.post.mapper.PostMapper;
import com.bbs.post.service.AboutPostService;
import com.bbs.role.mapper.RoleMapper;
import com.bbs.utils.GETuuid;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class AboutPostServiceImpl implements AboutPostService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ModuleMapper moduleMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PostClassMapper postClassMapper;

    @Override
    public Integer saveComment(Comment comment) {
        comment.setCode(GETuuid.getUUID());
        comment.setCommentTime(new Date());
        comment.setCreateDate(new Date());
        comment.setCreateBy("system");
        comment.setModifyDate(new Date());
        comment.setModifyBy("system");
        return commentMapper.saveComment(comment);
    }

    @Override
    public Integer saveModule(Module module) {
        module.setCode(GETuuid.getUUID());
        module.setCreateBy("system");
        module.setCreateDate(new Date());
        module.setModifyDate(new Date());
        module.setModifyBy("system");
        return moduleMapper.saveModule(module);
    }

    @Override
    public Integer addPraise(String postCode, Integer flag) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("postCode", postCode);
        map.put("flag", flag);
        postMapper.addPraise(map);
        return postMapper.getPraiseAmount(postCode);
    }

    @Override
    public List<Module> selectAllModule() {
        List<Module> list = moduleMapper.selectAllModule();
        return list;
    }

    @Override
    public Module selectByIdModule(String code) {
        Module module = moduleMapper.selectByIdModule(code);
        return module;
    }

    @Override
    @Transactional(rollbackFor = BusinessRunException.class)
    public void updateModel(Module module) throws BusinessRunException {
        try {
            moduleMapper.updateModule(module);
            // User1 user1=module.getUser1();
            // user1.setId(Integer.parseInt(module.getUserAccount()));
            // moduleMapper.updateUser(user1);
            moduleMapper.updateModuleUser(module);
        } catch (Exception e) {
            throw new BusinessRunException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = BusinessRunException.class)
    public void insertModuleUser(Module module) throws BusinessRunException {

        try {
            module.setCode(GETuuid.getUUID());
            module.setCreateDate(new Date());
            moduleMapper.insertModule(module);
            moduleMapper.insertUser(module);
        } catch (Exception e) {
            throw new BusinessRunException(e);
        }
    }

    @Override
    public void insertModule(Module module) {
        User1 user1 = roleMapper.getUserById(module.getUser1().getId());
        if (user1 != null) {
            if (!StringUtils.isEmpty(user1.getRoleName()) && user1.getRoleName().equals("版主")) {
                module.setUserAccount(user1.getAccount());
                module.setCode(GETuuid.getUUID());
                module.setCreateDate(new Date());
                moduleMapper.insertModule(module);
            }
        }
    }

    @Override
    public List<PostClass> selectALlClass(String code) {
        List<PostClass> list = moduleMapper.selectALlClass(code);
        return list;
    }

    @Override
    public PostClass selectByIdPostClass(String code) {
        PostClass postClass = moduleMapper.selectByIdPostClass(code);
        return postClass;
    }

    @Override
    public void updatePostClass(PostClass post) {
        moduleMapper.updatePostClass(post);

    }

    @Override
    @Transactional(rollbackFor = BusinessRunException.class)
    public void insertPostClasss(PostClass postClass) throws BusinessRunException {
        try {
            postClass.setCode(GETuuid.getUUID());
            postClass.setCreateDate(new Date());
            moduleMapper.insertPostClasss(postClass);
        } catch (Exception e) {
            throw new BusinessRunException(e);
        }
    }

    @Override
    public List<Module> getAllModule() {
        return moduleMapper.getAllModule();
    }

    @Override
    public List<PostClass> getAllPostClass() {
        return postClassMapper.getAllPostClass();
    }

    @Override
    public List<PostVo> selectPostClassByCode(String classCode) {
        List<PostVo> PostVoList = moduleMapper.selectPostClassByCode(classCode);
        return PostVoList;
    }

    @Override
    public void deletePostClassByCode(String code) {
        moduleMapper.deletePostClassByCode(code);
    }

    @Override
    public Page<Object> selectAllPostClassByCode(String classCode, Integer currentPage, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(currentPage, pageSize);
        List<PostVo> PostVoList2 = moduleMapper.selectAllPostClassByCode(classCode);
        return page;
    }

    /**
     * 根据code删除评论
     *
     * @author chenhuayang
     * @version 2018/8/28
     */
    @Override
    public void deleteComment(String code) {
        commentMapper.deleteComment(code);
    }

    /*
     * 删除帖子的评论
     * */
    @Override
    public void deleteCommentByPostCode(String postCode) {
        commentMapper.deleteCommentByPostCode(postCode);
    }

    @Override
    public Page<Object> getOnePostComments(String postCode, Integer currentPage, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(currentPage, pageSize);
        commentMapper.getOnePostComments(postCode);
        return page;
    }
}