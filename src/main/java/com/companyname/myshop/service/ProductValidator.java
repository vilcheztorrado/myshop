package com.companyname.myshop.service;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductValidator {

    @Min(0)
    private double price;
    @NotEmpty
    private String description;
    private boolean important;

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public double getPrice() {
        return price;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String newDescription) {
        description = newDescription;
    }
    
    public boolean getImportant() {
    	return important;
    }
    
    public void setImportant(boolean newImportant) {
    	important = newImportant;
    }
}