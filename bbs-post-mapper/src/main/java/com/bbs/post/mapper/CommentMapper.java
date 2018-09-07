package com.bbs.post.mapper;

import java.util.List;

import com.bbs.domain.Comment;

public interface CommentMapper {
    List<Comment> getOnePostComments(String postCode);

    Integer saveComment(Comment comment);

    void deleteCommentByPostCode(String postCode);

    void deleteComment(String code);
}