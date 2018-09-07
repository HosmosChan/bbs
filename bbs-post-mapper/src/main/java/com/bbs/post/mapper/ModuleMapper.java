package com.bbs.post.mapper;

import java.util.List;

import com.bbs.domain.Module;
import com.bbs.domain.PostClass;
import com.bbs.domain.PostVo;
import com.bbs.domain.User1;

public interface ModuleMapper {

    List<Module> getAllModule();

    Integer saveModule(Module module);

    List<Module> moduleList();// 返回模块列表

    List<Module> selectAllModule();

    Module selectByIdModule(String code);

    Module selectByIdModuleCode(String code);

    void updateModule(Module module);

    void updateUser(User1 user1);

    void updateModuleUser(Module module);

    void insertModule(Module module);

    void insertUser(Module module);

    PostClass selectByIdPostClass(String code);

    void updatePostClass(PostClass post);

    List<PostClass> selectALlClass(String code);

    void insertPostClasss(PostClass postClass);

    List<PostVo> selectPostClassByCode(String classCode);

    void deletePostClassByCode(String code);

    List<PostVo> selectAllPostClassByCode(String classCode);
}