package com.bbs.post.mapper;

import java.util.List;

import com.bbs.domain.Comment;

public interface CommentMapper {
	public List<Comment> getOnePostComments(String postCode);
	public Integer saveComment(Comment comment);
	public void deleteCommentByPostCode(String postCode);
}
