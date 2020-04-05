package com.spring.codeblog.service;

import java.util.List;

import com.spring.codeblog.models.Post;

/**
 * CodeblogService, 
 */
public interface CodeblogService {
    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);
}