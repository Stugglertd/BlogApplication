package com.mohit.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mohit.blog.entities.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
  private int id;	
  
  @NotEmpty
  @Size(min=4,message = "Username must be of 4 length !!")
  private String name;
  
  @Email(message = "Email address is not valid !!")
  private String email;
  
  @NotEmpty
  @Size(min=3,message = "min size of password must be 3")
  private String password;
  
  @NotEmpty
  private String about;  
  
  private Set<CommentDto> comments = new HashSet<>();
}
