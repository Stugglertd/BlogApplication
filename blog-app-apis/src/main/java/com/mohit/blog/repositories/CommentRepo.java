package com.mohit.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer>{

}
