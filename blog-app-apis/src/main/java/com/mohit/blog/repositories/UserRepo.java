package com.mohit.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
