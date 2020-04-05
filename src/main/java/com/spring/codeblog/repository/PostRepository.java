package com.spring.codeblog.repository;

import com.spring.codeblog.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostRepository
 */
public interface PostRepository extends JpaRepository<Post, Long>{

    
}