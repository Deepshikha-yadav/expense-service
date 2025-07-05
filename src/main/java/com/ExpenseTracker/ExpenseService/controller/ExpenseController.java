package com.ExpenseTracker.ExpenseService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseTracker.ExpenseService.dto.ExpenseDto;
import com.ExpenseTracker.ExpenseService.service.ExpenseServiceInterface;

@RestController
@RequestMapping(("/expenses"))
public class ExpenseController {

	private ExpenseServiceInterface expenseService;
	
	public ExpenseController(ExpenseServiceInterface expenseService) {
		this.expenseService = expenseService;
	}
	
	@GetMapping
	public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
		List<ExpenseDto> expenses = expenseService.getAllExpenses();
		return ResponseEntity.ok(expenses);
	}

	@PostMapping
	public ResponseEntity<ExpenseDto> addExpense(@RequestBody ExpenseDto expense) {
		ExpenseDto saved = expenseService.addExpense(expense);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
		try {
            expenseService.deleteExpense(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id, @RequestBody ExpenseDto expense) {
		try {
			ExpenseDto updated = expenseService.updateExpense(id, expense);
			return ResponseEntity.ok(updated);
		}
		catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	@GetMapping("/category")
	public ResponseEntity<List<ExpenseDto>> getExpensesByCategory(@RequestParam String category) {
        try {
            List<ExpenseDto> expenses = expenseService.getExpenseByCategory(category);
            return ResponseEntity.ok(expenses);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable Long id) {
        try {
            ExpenseDto expense = expenseService.getExpenseById(id);
            return ResponseEntity.ok(expense);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
	
}
