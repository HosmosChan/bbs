package com.bbs.post.mapper;

import java.util.List;

import com.bbs.domain.PostClass;

public interface PostClassMapper {
    List<PostClass> getAllPostClass();

    PostClass getPostClassByClassName(String postClassName);
}