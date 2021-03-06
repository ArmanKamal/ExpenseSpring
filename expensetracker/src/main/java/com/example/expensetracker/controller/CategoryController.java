package com.example.expensetracker.controller;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensetracker.model.Category;
import com.example.expensetracker.service.CategoryService;



@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryservice;
	
	@GetMapping("/categories")
	
	private Collection<Category> categories(){
		return categoryservice.findAllCategory();
	}
	
	@GetMapping("/category/{id}")
	private ResponseEntity<?> getCategory(@PathVariable Long id){
		Optional<Category> category = categoryservice.getSingleCategory(id);
		return category.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/category")
	private ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException{
		Category result = categoryservice.createCategory(category);
		return ResponseEntity.created(new URI("/api/category"+result.getId())).body(result);
	}
	
	@PutMapping("/category/{id}")
	private Category updateCategory(@Valid @RequestBody Category category, @PathVariable("id") Long id){
		 return categoryservice.getSingleCategory(id)
			      .map(category -> {
			        category.setName(category.getName());
			        return categoryservice.save(category);
			      })
			      .orElseGet(() -> {
			        newEmployee.setId(id);
			        return repository.save(newEmployee);
			      });
	}
}
 