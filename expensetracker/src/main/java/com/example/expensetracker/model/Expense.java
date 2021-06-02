package com.example.expensetracker.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="expense")

public class Expense {
	
	@Id
	private Long id;
	
	private Instant expensedate;
	
	private String description;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
	
	public Expense() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Expense(Long id, Instant expensedate, String description, Category category, User user) {
		super();
		this.id = id;
		this.expensedate = expensedate;
		this.description = description;
		this.category = category;
		this.user = user;
	}

	public Instant getExpensedate() {
		return expensedate;
	}

	public void setExpensedate(Instant expensedate) {
		this.expensedate = expensedate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
