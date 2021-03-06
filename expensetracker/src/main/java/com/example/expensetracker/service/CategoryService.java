package com.example.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expensetracker.model.Category;
import com.example.expensetracker.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category findByName(String name) {
		return this.categoryRepository.findByName(name);
	}
	
	public List<Category> findAllCategory(){
		return this.categoryRepository.findAll();
	}
	
	public Optional<Category> getSingleCategory(Long id) {
		return this.categoryRepository.findById(id);
	}
	public Category createCategory(Category category){
		return this.categoryRepository.save(category);
	}
}
