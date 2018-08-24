package com.bbs.post.mapper;

import java.util.List;

import com.bbs.domain.Module;
import com.bbs.domain.PostClass;
import com.bbs.domain.PostVo;
import com.bbs.domain.User1;

public interface ModuleMapper {

	public List<Module> getAllModule();

	Integer saveModule(Module module);

	List<Module> moduleList();// 返回模块列表

	public List<Module> selectAllModule();

	public Module selectByIdModule(String code);
	
	public Module selectByIdModuleCode(String code);

	public void updateModule(Module module);

	public void updateUser(User1 user1);

	public void updateModuleUser(Module module);

	public void insertModule(Module module);

	public void insertUser(Module module);

	public PostClass selectByIdPostClass(String code);

	public void updatePostClass(PostClass post);

	public List<PostClass> selectALlClass(String code);

	public void insertPostClasss(PostClass postClass);


	public List<PostVo> selectPostClassByCode(String classCode);

	public void deletePostClassByCode(String code);
	
	public List<PostVo> selectAllPostClassByCode(String classCode);
}
