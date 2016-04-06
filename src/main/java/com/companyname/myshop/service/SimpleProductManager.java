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

	public Product createProduct(String description, double price, boolean important, byte[] photo) {
		if(description == null || description.isEmpty() || price < 0) {
			return null;
		}
		Product prod = new Product();
		prod.setDescription(description);
		prod.setPrice(price);
		prod.setImportant(important);
		prod.setPhoto(photo);
		productDao.saveProduct(prod);
		return prod;
	}

	public Product getProduct(String id) {
		return productDao.getProduct(id);
	}

	public List<Product> getImportantProducts() {
		return productDao.getImportantProductList();
	}
}