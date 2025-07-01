package com.example.expensetracker.mapper;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.model.Expense;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {
    public ExpenseDTO toDTO(Expense expense){
        ExpenseDTO dto = new ExpenseDTO();
        dto.setId(expense.getId());
        dto.setTitle(expense.getTitle());
        dto.setAmount(expense.getAmount());
        dto.setCategory(expense.getCategory());
        dto.setDate(expense.getDate());
        return dto;
    }

    public Expense toEntity(ExpenseDTO dto){
        Expense expense = new Expense();
        expense.setId(dto.getId());
        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setCategory(dto.getCategory());
        expense.setDate(dto.getDate());
        return expense;
    }
}
