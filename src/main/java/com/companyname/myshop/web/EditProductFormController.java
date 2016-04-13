//package com.companyname.myshop.web;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.companyname.myshop.service.ProductManager;
//import com.companyname.myshop.service.ProductValidator;
//
//@Controller
//@RequestMapping("/products/edit/{id}")
//public class EditProductFormController {
//
//    @Autowired
//    private ProductManager productManager;
//    
//    /** Logger for this class and subclasses */
//    protected final Log logger = LogFactory.getLog(getClass());
//
//    @RequestMapping(method = RequestMethod.POST)
//    public String onSubmit(@Valid ProductValidator productValidator, BindingResult result)
//    {
//        if (result.hasErrors()) {
//            return "products/edit";
//        }
//
//        productManager.createProduct(productValidator.getDescription(), productValidator.getPrice(), productValidator.getImportant(), productValidator.getPhoto().getBytes());
//
//        return "redirect:/products/list.htm";
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    protected ModelAndView formBackingObject(@PathVariable("id") String id, HttpServletRequest request) throws ServletException {
//        ProductValidator productValidator = new ProductValidator();
//        //return productValidator;
//    	Map<String, Object> myModel = new HashMap<String, Object>();
//        myModel.put("productValidator", productValidator);
//
//        return new ModelAndView("products/edit", "model", myModel);
//    }
//
//    public void setProductManager(ProductManager productManager) {
//        this.productManager = productManager;
//    }
//
//    public ProductManager getProductManager() {
//        return productManager;
//    }
//
//}