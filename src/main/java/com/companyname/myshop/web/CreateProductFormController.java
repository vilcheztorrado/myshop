package com.companyname.myshop.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.myshop.service.ProductValidator;
import com.companyname.myshop.service.ProductManager;

@Controller
@RequestMapping("/products/create.htm")
public class CreateProductFormController {

    @Autowired
    private ProductManager productManager;
    
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid ProductValidator productValidator, BindingResult result)
    {
        if (result.hasErrors()) {
            return "products/create";
        }

        productManager.createProduct(productValidator.getDescription(), productValidator.getPrice(), productValidator.getImportant());

        return "redirect:/products/list.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected ProductValidator formBackingObject(HttpServletRequest request) throws ServletException {
        ProductValidator productValidator = new ProductValidator();
        productValidator.setImportant(false);
        return productValidator;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}