package com.companyname.myshop.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.companyname.myshop.domain.Product;

@Component
public interface ProductManager extends Serializable {
	public Product createProduct(String description, double price, boolean important, byte[] photo);
    public List<Product> getProducts();
	public Product getProduct(String id);
}