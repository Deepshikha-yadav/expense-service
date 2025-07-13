package com.ExpenseTracker.ExpenseService.dto;

import java.time.LocalDate;

public class ExpenseEvent {

	private ExpenseDto data;
    private String eventType;
    private LocalDate createdAt = LocalDate.now();
    
	public ExpenseDto getData() {
		return data;
	}
	public void setData(ExpenseDto data) {
		this.data = data;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	public ExpenseEvent(ExpenseDto data, String eventType) {
		super();
		this.data = data;
		this.eventType = eventType;
	}
	public ExpenseEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}
