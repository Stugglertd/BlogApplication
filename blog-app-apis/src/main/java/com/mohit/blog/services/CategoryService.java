package com.mohit.blog.services;

import java.util.List;

import com.mohit.blog.payloads.CategoryDto;
import com.mohit.blog.payloads.UserDto;

public interface CategoryService {
 //create
 CategoryDto createCategory(CategoryDto categoryDto);
 //update
 CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);	
 //delete
 void deleteCategory(Integer categoryId);
 //get
 CategoryDto getCategoryById(Integer categoryId);	
 //get all
 List<CategoryDto> getAllCategories();
}
