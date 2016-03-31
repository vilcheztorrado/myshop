package com.companyname.myshop.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.companyname.myshop.domain.Product;

@Component
public interface ProductManager extends Serializable {
	public void increasePrice(int percentage);
    public List<Product> getProducts();
}