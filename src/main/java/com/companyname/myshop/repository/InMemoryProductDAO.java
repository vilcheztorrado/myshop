package com.companyname.myshop.repository;

import java.util.ArrayList;
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
    	productList.add(prod);
    }

	public Product getProduct(String id) {
		if (productList != null) {
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getId().toString().equals(id)) {
					return productList.get(i);
				}
			}
		}
		return null;
	}

	public List<Product> getImportantProductList() {
		List<Product> importantProducts = new ArrayList<Product>();
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).isImportant()) {
				importantProducts.add(productList.get(i));
			}
		}
		return importantProducts;
	}

}