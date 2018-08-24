package com.bbs.post.service;

import java.util.List;

import com.bbs.domain.Comment;
import com.bbs.domain.Module;
import com.bbs.domain.PostClass;
import com.bbs.domain.PostVo;
import com.bbs.exception.BusinessRunException;
import com.github.pagehelper.Page;

public interface AboutPostService {
	public List<Comment> getOnePostComments(String postCode);

	public Integer saveComment(Comment comment);

	public Integer saveModule(Module module);

	public Integer addPraise(String postCode,Integer flag);
	public List<Module> selectAllModule();

	public Module selectByIdModule(String code);

	public void updateModel(Module module) throws BusinessRunException;

	public void insertModuleUser(Module module) throws BusinessRunException;

	public void insertModule(Module module);

	public List<PostClass> selectALlClass(String code);

	public void updatePostClass(PostClass post);

	public PostClass selectByIdPostClass(String code);

	public void insertPostClasss(PostClass postClass) throws BusinessRunException;
	
	public List<Module> getAllModule();

	public List<PostClass> getAllPostClass();

	public List<PostVo> selectPostClassByCode(String classCode);

	public void deletePostClassByCode(String code);

	public void deleteCommentByPostCode(String postCode);

	Page<Object> selectAllPostClassByCode(String classCode,Integer currentPage,Integer pageSize);
	
	
}
