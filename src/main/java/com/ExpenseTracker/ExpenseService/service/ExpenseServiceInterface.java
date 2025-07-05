package com.ExpenseTracker.ExpenseService.service;

import java.util.List;

import com.ExpenseTracker.ExpenseService.dto.ExpenseDto;

public interface ExpenseServiceInterface {

	public List<ExpenseDto> getAllExpenses();
	
	public ExpenseDto getExpenseById(Long id);
	
	public ExpenseDto addExpense(ExpenseDto expense);
	
	public void deleteExpense(Long id);
	
	public ExpenseDto updateExpense(Long id, ExpenseDto expense);
	
	public List<ExpenseDto> getExpenseByCategory(String category);
}
