package com.ExpenseTracker.ExpenseService.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseDto {
	
	private Long id;
	
	private BigDecimal amount;
	
	private String description;
	
	private String category;
	
	private Long userId;
	
	private LocalDate expenseDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDate getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}

	public ExpenseDto(Long id, BigDecimal amount, String description, String category, Long userId) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.category = category;
		this.userId = userId;
	}
	
}
