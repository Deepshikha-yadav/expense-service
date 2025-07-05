package com.ExpenseTracker.ExpenseService.mapper;

import org.mapstruct.Mapper;

import com.ExpenseTracker.ExpenseService.dto.ExpenseDto;
import com.ExpenseTracker.ExpenseService.model.Expense;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {
	    ExpenseDto toDto(Expense entity);
	    Expense toEntity(ExpenseDto dto);
}
