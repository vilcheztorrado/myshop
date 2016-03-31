package com.companyname.myshop.repository;

import java.util.List;

import com.companyname.myshop.domain.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}