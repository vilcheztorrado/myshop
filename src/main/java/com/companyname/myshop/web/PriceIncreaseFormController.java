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

import com.companyname.myshop.service.PriceIncrease;
import com.companyname.myshop.service.ProductManager;

@Controller
@RequestMapping("/products/priceincrease.htm")
public class PriceIncreaseFormController {

    @Autowired
    private ProductManager productManager;
    
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid PriceIncrease priceIncrease, BindingResult result)
    {
        if (result.hasErrors()) {
            return "products/priceincrease";
        }
        logger.info("Percentage:  " + priceIncrease.getPercentage());
        int increase = priceIncrease.getPercentage();

        productManager.increasePrice(increase);

        return "redirect:/products/list.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected PriceIncrease formBackingObject(HttpServletRequest request) throws ServletException {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(15);
        return priceIncrease;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}