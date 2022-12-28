package com.mohit.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.blog.entities.Comment;
import com.mohit.blog.entities.Post;
import com.mohit.blog.entities.User;
import com.mohit.blog.exceptions.ResourceNotFoundException;
import com.mohit.blog.payloads.CommentDto;
import com.mohit.blog.payloads.PostDto;
import com.mohit.blog.repositories.CommentRepo;
import com.mohit.blog.repositories.PostRepo;
import com.mohit.blog.repositories.UserRepo;
import com.mohit.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId,Integer userId) {
	  Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id: ",postId));
	  User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","users id: ",postId));
	  Comment comment = modelMapper.map(commentDto, Comment.class);
	  comment.setPost(post);
	  comment.setUser(user);
	  
	  Comment savedComment = commentRepo.save(comment);
	  
	  return modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
     Comment comment = commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","comment id:",commentId));
	 commentRepo.delete(comment);
	}

}
