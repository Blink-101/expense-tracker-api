package com.example.expensetracker.service;


import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.exception.ExpenseNotFoundException;
import com.example.expensetracker.mapper.ExpenseMapper;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ExpenseMapper expenseMapper;

    @Override
    public ExpenseDTO saveExpense(ExpenseDTO dto){
        Expense expense = expenseMapper.toEntity(dto);
        return expenseMapper.toDTO(expenseRepository.save(expense));
    }

    @Override
    public List<ExpenseDTO> getAllExpenses(){
        return expenseRepository.findAll().stream()
                .map(expenseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO getExpenseById(Long id){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));
        return  expenseMapper.toDTO(expense);
    }

    @Override
    public List<ExpenseDTO> getExpensesByCategory(String category){
        return expenseRepository.findByCategory(category)
                .stream().map(expenseMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO dto){
        Expense existing = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));
        existing.setTitle(dto.getTitle());
        existing.setAmount(dto.getAmount());
        existing.setCategory(dto.getCategory());
        existing.setDate(dto.getDate());
        return expenseMapper.toDTO(expenseRepository.save(existing));
    }

    public void deleteExpense(Long id){
        if (!expenseRepository.existsById(id)){
            throw new ExpenseNotFoundException(id);
        }
        expenseRepository.deleteById(id);
    }


}
