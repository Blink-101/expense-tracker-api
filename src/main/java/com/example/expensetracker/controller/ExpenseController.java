package com.example.expensetracker.controller;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import com.example.expensetracker.service.ExpenseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // adding new expense
    @PostMapping
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody @Valid ExpenseDTO dto){
        return new ResponseEntity<>(expenseService.saveExpense(dto), HttpStatus.CREATED);
    }

    // View all recorded expense
    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    // View by id
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable Long id){
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    //filter expenses by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ExpenseDTO>> getExpensesByCategory(@PathVariable String category){
        return ResponseEntity.ok(expenseService.getExpensesByCategory(category));
    }

    //Update an existing expense
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDTO> updateByCategory(@PathVariable Long id, @RequestBody ExpenseDTO dto){
        return ResponseEntity.ok(expenseService.updateExpense(id, dto));
    }

    // Deleting an expense
    @DeleteMapping("/{id}")
    public ResponseEntity<ExpenseDTO> deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
