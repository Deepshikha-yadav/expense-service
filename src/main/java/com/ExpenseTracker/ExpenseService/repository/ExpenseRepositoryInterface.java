package com.ExpenseTracker.ExpenseService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ExpenseTracker.ExpenseService.model.Expense;

@Repository
public interface ExpenseRepositoryInterface extends JpaRepository<Expense, Long> {
	
	@Query("Select e from Expense e where e.category=?1")
	public List<Expense> findByCategory(String category);
}
