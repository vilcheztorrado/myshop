package com.companyname.myshop.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.myshop.service.ProductManager;

@Controller
public class HomeController {
	
	@Autowired
    private ProductManager productManager;

	@RequestMapping("/")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("products", this.productManager.getImportantProducts());

        return new ModelAndView("index", "model", myModel);
    }
}
