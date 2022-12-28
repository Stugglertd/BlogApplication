package com.mohit.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.blog.payloads.ApiResponse;
import com.mohit.blog.payloads.CategoryDto;
import com.mohit.blog.payloads.UserDto;
import com.mohit.blog.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
  @Autowired	
  private CategoryService categoryService;
  
  //create category
  @PostMapping("/")
  public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
	CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);  
	return new ResponseEntity<>(createCategoryDto,HttpStatus.CREATED);
  }
  
  //update category
  @PutMapping("/{catId}")
  public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
	CategoryDto updateCategoryDto = this.categoryService.updateCategory(categoryDto, catId);  
	return new ResponseEntity<CategoryDto>(updateCategoryDto,HttpStatus.OK);
  }
  
  //delete category
  @DeleteMapping("/{catId}")
  public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
	this.categoryService.deleteCategory(catId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted",true),HttpStatus.OK);
  }
  
  //get single
  @GetMapping("/{catId}")
  public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer catId){
   return ResponseEntity.ok(this.categoryService.getCategoryById(catId));	 
  }
  
  //get all
  @GetMapping("/")
  public ResponseEntity<List<CategoryDto>> getAllCategories(){
   return ResponseEntity.ok(this.categoryService.getAllCategories());	 
  }
}
