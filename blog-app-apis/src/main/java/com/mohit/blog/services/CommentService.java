package com.mohit.blog.services;

import com.mohit.blog.payloads.CommentDto;

public interface CommentService {
 CommentDto createComment(CommentDto commentDto,Integer postId,Integer userId);
 void deleteComment(Integer commentId);
}
