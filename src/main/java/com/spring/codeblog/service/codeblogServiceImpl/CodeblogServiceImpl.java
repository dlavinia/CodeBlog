package com.spring.codeblog.service.codeblogServiceImpl;

import java.util.List;

import com.spring.codeblog.models.Post;
import com.spring.codeblog.repository.PostRepository;
import com.spring.codeblog.service.CodeblogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CodeblogServiceImpl
 */

 @Service
public class CodeblogServiceImpl implements CodeblogService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> findAll() {
       
        return postRepository.findAll();
    }

    @Override
    public Post findById(long id) {
       
        return postRepository.findById(id).get() ;
    }

    @Override
    public Post save(Post post) {
        
        return postRepository.save(post);
    }

    
}