package com.companyname.myshop.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.myshop.domain.Product;
import com.companyname.myshop.service.ProductManager;
import com.companyname.myshop.service.ProductValidator;

@Controller
@RequestMapping("/products/")
public class CreateProductFormController {

    @Autowired
    private ProductManager productManager;
    
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value="create.htm", method = RequestMethod.POST)
    public String onCreate(@Valid ProductValidator productValidator, BindingResult result)
    {
        if (result.hasErrors()) {
            return "products/create";
        }

        productManager.createProduct(productValidator.getDescription(), productValidator.getPrice(), productValidator.getImportant(), productValidator.getPhoto().getBytes());

        return "redirect:/products/list.htm";
    }

    @RequestMapping(value="create.htm", method = RequestMethod.GET)
    protected ProductValidator formBackingObjectCreation(HttpServletRequest request) throws ServletException {
        ProductValidator productValidator = new ProductValidator();
        productValidator.setImportant(false);
        return productValidator;
    }
    
    @RequestMapping(value="edit/{id}", method = RequestMethod.GET)
    protected ModelAndView formBackingObjectEdit(@PathVariable("id") String id, HttpServletRequest request) throws ServletException {
        ProductValidator productValidator = new ProductValidator();
        Product p = this.productManager.getProduct(id);
        productValidator.setExistingProductId(p.getId());
        productValidator.setPrice(p.getPrice());
        productValidator.setDescription(p.getDescription());
        productValidator.setImportant(p.isImportant());
        productValidator.setPhotoPreloaded(p.getPhoto());
        
        return new ModelAndView("products/edit", "productValidator", productValidator);
    }
    
    @RequestMapping(value="edit/{id}", method = RequestMethod.POST)
    public String onEdit(@PathVariable("id") String id, @Valid ProductValidator productValidator, BindingResult result)
    {
        if (result.hasErrors()) {
            return "products/edit";
        }
        
        if (productValidator.isRemovedPhoto()) {
        	if (productValidator.getPhoto().isEmpty()) {
        		productManager.editProduct(id, productValidator.getDescription(), productValidator.getPrice(), productValidator.getImportant(), null);
        	} else {
        		productManager.editProduct(id, productValidator.getDescription(), productValidator.getPrice(), productValidator.getImportant(), productValidator.getPhoto().getBytes());
        	}
        } else {
        	if (productValidator.getPhoto().isEmpty()) {
        		productManager.editProduct(id, productValidator.getDescription(), productValidator.getPrice(), productValidator.getImportant());
        	} else {
        		productManager.editProduct(id, productValidator.getDescription(), productValidator.getPrice(), productValidator.getImportant(), productValidator.getPhoto().getBytes());
        	}
        }
        return "redirect:/products/list.htm";
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}