package com.companyname.myshop.service;

import java.sql.Blob;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ProductValidator {

    @Min(0)
    private double price;
    @NotEmpty
    private String description;
    private boolean important;
    private CommonsMultipartFile photo;

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
    
    public CommonsMultipartFile getPhoto() {
    	return photo;
    }
    
    public void setPhoto(CommonsMultipartFile newPhoto) {
    	photo = newPhoto;
    }
}