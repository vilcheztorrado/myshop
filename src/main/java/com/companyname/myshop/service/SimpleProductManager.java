package com.companyname.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.myshop.domain.Product;
import com.companyname.myshop.repository.ProductDAO;

@Service
public class SimpleProductManager implements ProductManager {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductDAO productDao;
	
	public void setProductDao(ProductDAO productDao) {
        this.productDao = productDao;
    }
	
	public List<Product> getProducts() {
	    return productDao.getProductList();        
	}
	
	public void increasePrice(int percentage) {
		List<Product> products = productDao.getProductList();
		if (products != null) {
		    for (Product product : products) {
		        double newPrice = product.getPrice().doubleValue() * 
		                            (100 + percentage)/100;
		        product.setPrice(newPrice);
		        productDao.saveProduct(product);
		    }
		}
	}
}