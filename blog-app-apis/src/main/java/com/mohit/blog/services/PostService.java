package com.mohit.blog.services;

import java.util.List;

import com.mohit.blog.entities.Post;
import com.mohit.blog.payloads.PostDto;
import com.mohit.blog.payloads.PostResponse;

public interface PostService {
 //create	
  PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
 //update
  PostDto updatePost(PostDto postDto,Integer postId);
 //delete
  void deletePost(Integer postId);
 //get all posts
  PostResponse getAllPost(int pageNumber,int pageSize, String sortBy,String sortDir);
 //get single post
  PostDto getPostById(Integer postId);
  
 //get post by category
  List<PostDto> getPostsByCategory(Integer categoryId);
 //get post by user
  List<PostDto> getPostsByUser(Integer userId);
 //search posts 
  List<PostDto> searchPosts(String keyword);
}
