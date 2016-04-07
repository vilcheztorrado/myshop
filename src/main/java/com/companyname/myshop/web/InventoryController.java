package com.companyname.myshop.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.myshop.domain.Product;
import com.companyname.myshop.service.ProductManager;

@Controller
@RequestMapping(value="/products*")
public class InventoryController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
    private ProductManager productManager;
	
    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
	
	@RequestMapping(value="")
    public ModelAndView homepage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("products/index");
    }

    @RequestMapping(value="/list.htm")
    public ModelAndView productList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("products", this.productManager.getProducts());

        return new ModelAndView("products/list", "model", myModel);
    }
    
    @RequestMapping(value="/{id}")
    public ModelAndView productDetail(@PathVariable("id") String id, HttpServletRequest request)
            throws ServletException, IOException {

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("product", this.productManager.getProduct(id));

        return new ModelAndView("products/productDetail", "model", myModel);
    }
}
