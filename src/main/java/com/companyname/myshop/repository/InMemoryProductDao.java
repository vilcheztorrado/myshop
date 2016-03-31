package com.companyname.myshop.repository;

import java.util.List;

import com.companyname.myshop.domain.Product;
/* This class is only for simulate DB Access */
public class InMemoryProductDao implements ProductDao {

    private List<Product> productList;

    public InMemoryProductDao(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void saveProduct(Product prod) {
    }

}