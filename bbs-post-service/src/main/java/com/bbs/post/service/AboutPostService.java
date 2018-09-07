package com.bbs.post.service;

import java.util.List;

import com.bbs.domain.Comment;
import com.bbs.domain.Module;
import com.bbs.domain.PostClass;
import com.bbs.domain.PostVo;
import com.bbs.exception.BusinessRunException;
import com.github.pagehelper.Page;

public interface AboutPostService {
    Page<Object> getOnePostComments(String postCode, Integer currentPage, Integer pageSize);

    Integer saveComment(Comment comment);

    Integer saveModule(Module module);

    Integer addPraise(String postCode, Integer flag);

    List<Module> selectAllModule();

    Module selectByIdModule(String code);

    void updateModel(Module module) throws BusinessRunException;

    void insertModuleUser(Module module) throws BusinessRunException;

    void insertModule(Module module);

    List<PostClass> selectALlClass(String code);

    void updatePostClass(PostClass post);

    PostClass selectByIdPostClass(String code);

    void insertPostClasss(PostClass postClass) throws BusinessRunException;

    List<Module> getAllModule();

    List<PostClass> getAllPostClass();

    List<PostVo> selectPostClassByCode(String classCode);

    void deletePostClassByCode(String code);

    void deleteCommentByPostCode(String postCode);

    Page<Object> selectAllPostClassByCode(String classCode, Integer currentPage, Integer pageSize);

    void deleteComment(String code);
}