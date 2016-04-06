package com.companyname.myshop.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.myshop.domain.Product;
import com.companyname.myshop.repository.InMemoryProductDAO;
import com.companyname.myshop.service.SimpleProductManager;


public class InventoryControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
    	InventoryController controller = new InventoryController();
    	SimpleProductManager spm = new SimpleProductManager();
        spm.setProductDao(new InMemoryProductDAO(new ArrayList<Product>()));
        controller.setProductManager(spm);
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("products/list", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
    }

}