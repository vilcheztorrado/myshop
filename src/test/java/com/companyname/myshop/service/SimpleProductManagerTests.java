package com.companyname.myshop.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.companyname.myshop.domain.Product;
import com.companyname.myshop.repository.InMemoryProductDAO;
import com.companyname.myshop.repository.ProductDAO;
import com.companyname.myshop.service.SimpleProductManager;

public class SimpleProductManagerTests {
	
	private SimpleProductManager productManager;
	
	private List<Product> products;
	
	private static int PRODUCT_COUNT = 2;
	
	private static Double CHAIR_PRICE = new Double(20.50);
	private static String CHAIR_DESCRIPTION = "Chair";
	
	private static String TABLE_DESCRIPTION = "Table";
	private static Double TABLE_PRICE = new Double(150.10); 
		
	@Before
	public void setUp() throws Exception {
	    productManager = new SimpleProductManager();
	    products = new ArrayList<Product>();
	    
	    // stub up a list of products
	    Product product = new Product();
	    product.setDescription("Chair");
	    product.setPrice(CHAIR_PRICE);
	    products.add(product);
	    
	    product = new Product();
	    product.setDescription("Table");
	    product.setPrice(TABLE_PRICE);
	    products.add(product);
	    
	    ProductDAO productDao = new InMemoryProductDAO(products);
        productManager.setProductDao(productDao);	
	}
	
	@Test
	public void testGetProductsWithNoProducts() {
	    productManager = new SimpleProductManager();
	    productManager.setProductDao(new InMemoryProductDAO(null));
	    assertNull(productManager.getProducts());
	}
	
	@Test
	public void testGetProducts() {
	    List<Product> products = productManager.getProducts();
	    assertNotNull(products);        
	    assertEquals(PRODUCT_COUNT, productManager.getProducts().size());
	
	    Product product = products.get(0);
	    assertEquals(CHAIR_DESCRIPTION, product.getDescription());
	    assertEquals(CHAIR_PRICE, product.getPrice());
	    
	    product = products.get(1);
	    assertEquals(TABLE_DESCRIPTION, product.getDescription());
	    assertEquals(TABLE_PRICE, product.getPrice());      
	}
	
	@Test
	public void testCreateProductWithNullDescription() {
		try {
			byte[] image = new byte[4];
		    image[0] = image[1] = image[2] = image[3] = 1;
		    productManager = new SimpleProductManager();
		    productManager.setProductDao(new InMemoryProductDAO(null));
		    assertEquals(null, productManager.createProduct(null, 100.0, true, image));
		}
		catch(NullPointerException ex) {
		    fail("Description is null!!");
		}
	}
	
	@Test
	public void testCreateProductWithEmptyDescription() {
		try {
			byte[] image = new byte[4];
		    image[0] = image[1] = image[2] = image[3] = 1;
		    productManager = new SimpleProductManager();
		    productManager.setProductDao(new InMemoryProductDAO(null));
		    assertEquals(null, productManager.createProduct("", 100.0, true, image));
		}
		catch(NullPointerException ex) {
		    fail("Description is Empty!!");
		}
	}
	
	@Test
	public void testCreateProductWithNotValidPrice() {
		try {
			byte[] image = new byte[4];
		    image[0] = image[1] = image[2] = image[3] = 1;
		    productManager = new SimpleProductManager();
		    productManager.setProductDao(new InMemoryProductDAO(null));
		    assertEquals(null, productManager.createProduct("An Item", -1, true, image));
		}
		catch(NullPointerException ex) {
		    fail("Price is negative!!");
		}
	}
	
	@Test
	public void testIncreasePriceWithAllCorrectData() {
		String expectedDescriptionValue = "An Item";
		double expectedPriceValue = 100.0;
		byte[] image = new byte[4];
	    image[0] = image[1] = image[2] = image[3] = 1;
		productManager = new SimpleProductManager();
	    productManager.setProductDao(new InMemoryProductDAO(new ArrayList<Product>()));
	    productManager.createProduct("An Item", 100.0, true, image);
	    
	    List<Product> products = productManager.getProducts(); 
	    Product product = products.get(0);
	    assertEquals("description comparator", expectedDescriptionValue, product.getDescription());    
	    assertEquals(expectedPriceValue, product.getPrice(), 0);       
	}

}