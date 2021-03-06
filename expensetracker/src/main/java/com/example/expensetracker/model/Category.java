package com.example.expensetracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 2)
	
	private String name;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Category() {
		
	}
	
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
}
