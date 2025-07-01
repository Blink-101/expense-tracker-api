package com.example.expensetracker.service;

import com.example.expensetracker.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {

    ExpenseDTO saveExpense(ExpenseDTO dto);
    List<ExpenseDTO> getAllExpenses();
    ExpenseDTO getExpenseById(Long id);
    List<ExpenseDTO> getExpensesByCategory(String category);
    ExpenseDTO updateExpense(Long id, ExpenseDTO dto);
    void deleteExpense(Long id);
}
