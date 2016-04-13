package com.companyname.myshop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import com.companyname.myshop.service.ProductManager;

@Component("imageServlet")
public class ImageServlet implements HttpRequestHandler {
 
    @Autowired
    private ProductManager productManager;
 
    public void handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	ServletOutputStream writer = null;
    	String id = (String) request.getParameter("id");
        byte[] photo = productManager.getProduct(id).getPhoto();
 
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.setContentLength(photo.length);

        writer = response.getOutputStream();
        writer.write(photo);
        writer.flush();
    }
}