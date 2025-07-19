package com.ExpenseTracker.ExpenseService.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExpenseEvent {

	private String eventType;
    private Long expenseId;
    private Long userId;
    private BigDecimal amount;
    private String category;
    private String description;
    private LocalDate expenseDate;
    private LocalDateTime eventTimestamp = LocalDateTime.now();
    
	public String getEventType() {
		return eventType;
	}
	
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public Long getExpenseId() {
		return expenseId;
	}
	
	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getExpenseDate() {
		return expenseDate;
	}
	
	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}
	
	public LocalDateTime getEventTimestamp() {
		return eventTimestamp;
	}
	
	public void setEventTimestamp(LocalDateTime eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}
	
	public ExpenseEvent(String eventType, Long expenseId, Long userId, BigDecimal amount, String category,
			String description, LocalDate expenseDate, LocalDateTime eventTimestamp) {
		super();
		this.eventType = eventType;
		this.expenseId = expenseId;
		this.userId = userId;
		this.amount = amount;
		this.category = category;
		this.description = description;
		this.expenseDate = expenseDate;
		this.eventTimestamp = eventTimestamp;
	}
	
	public ExpenseEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}
