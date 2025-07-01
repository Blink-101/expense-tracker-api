package com.example.expensetracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class ExpenseDTO {
    private Long id;
    private String title;
    private Double amount;
    private String category;
    private LocalDate date;

    // getter and setter

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    @NotBlank(message = "Title is required")
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    public Double getAmount(){return amount;}
    public void setAmount(Double amount){this.amount = amount;}

    @NotBlank(message = "Category is required")
    public String getCategory(){return category;}
    public void setCategory(String category){this.category = category;}

    @NotNull(message = "Date is required")
    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}
}
