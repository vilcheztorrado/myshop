package com.companyname.myshop.repository;

import java.util.List;

import com.companyname.myshop.domain.Product;

public interface ProductDAO {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

	public Product getProduct(String id);

}