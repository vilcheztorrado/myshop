package com.companyname.myshop.repository;

import java.util.List;

import com.companyname.myshop.domain.Product;
/* This class is only for simulate DB Access */
public class InMemoryProductDAO implements ProductDAO {

    private List<Product> productList;

    public InMemoryProductDAO(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void saveProduct(Product prod) {
    }

}