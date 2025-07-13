package com.ExpenseTracker.ExpenseService.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ExpenseTracker.ExpenseService.dto.ExpenseDto;
import com.ExpenseTracker.ExpenseService.dto.ExpenseEvent;
import com.ExpenseTracker.ExpenseService.kafka.ExpenseProducer;
import com.ExpenseTracker.ExpenseService.mapper.ExpenseMapper;
import com.ExpenseTracker.ExpenseService.model.Expense;
import com.ExpenseTracker.ExpenseService.repository.ExpenseRepositoryInterface;

@Service
public class ExpenseService implements ExpenseServiceInterface {

	private final ExpenseRepositoryInterface expenseRepository;
	private final ExpenseMapper mapper;
	private final ExpenseProducer producer;
	
	public ExpenseService(ExpenseRepositoryInterface expenseRepository, ExpenseMapper mapper, ExpenseProducer producer) {
		this.expenseRepository = expenseRepository;
		this.mapper = mapper;
		this.producer = producer;
	}
	
	@Override
	public List<ExpenseDto> getAllExpenses() {
		return expenseRepository.findAll().stream().map(mapper::toDto).toList();
	}

	@Override
	public ExpenseDto addExpense(ExpenseDto expense) {
		expense.setExpenseDate(LocalDate.now());
		Expense savedExpense = expenseRepository.save(mapper.toEntity(expense));
		ExpenseDto savedDto = mapper.toDto(savedExpense);
		
		ExpenseEvent event = new ExpenseEvent(savedDto, "CREATED");
		
		producer.publishExpense(event);
		
		return savedDto;
	}

	@Override
	public void deleteExpense(Long id) {
		if (id == null || !expenseRepository.existsById(id)) {
	        throw new IllegalArgumentException("Expense not found or ID is missing.");
	    }
		
		Expense toDelete = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
		
		expenseRepository.deleteById(id);
		
		ExpenseEvent event = new ExpenseEvent(mapper.toDto(toDelete), "DELETED");
		
		producer.publishExpense(event);
		
	}

	@Override
	public ExpenseDto updateExpense(Long id, ExpenseDto expense) {
		if (id == null || !expenseRepository.existsById(expense.getId())) {
	        throw new IllegalArgumentException("Expense not found or ID is missing.");
	    }
		expense.setExpenseDate(LocalDate.now());
		expense.setId(id);
		Expense saved = expenseRepository.save(mapper.toEntity(expense));
		
		ExpenseDto savedDto = mapper.toDto(saved);
		
		ExpenseEvent event = new ExpenseEvent(savedDto, "UPDATED");
		
		producer.publishExpense(event);
		
		return savedDto;
	}

	@Override
	public ExpenseDto getExpenseById(Long id) {
		if(id==null) {
			throw new IllegalArgumentException("Expense not found or ID is missing.");
		}
		Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Expense not found for id: " + id));
        return mapper.toDto(expense);
	}

	@Override
	public List<ExpenseDto> getExpenseByCategory(String category) {
		if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category is missing.");
        }
        return expenseRepository.findByCategory(category).stream()
                .map(mapper::toDto)
                .toList();
	}
	
}
