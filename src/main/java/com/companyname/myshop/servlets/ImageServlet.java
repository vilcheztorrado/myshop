package com.companyname.myshop.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.OutputStream;
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
// 
//        BufferedInputStream input = null;
//        BufferedOutputStream output = null;
// 
//        try {
//            input = new BufferedInputStream(new ByteArrayInputStream(photo));
//            output = new BufferedOutputStream(response.getOutputStream());
//            byte[] buffer = new byte[8192];
//            int length;
//            while ((length = input.read(buffer)) > 0) {
//                output.write(buffer, 0, length);
//            }
//        } catch (IOException e) {
//            System.out.println("There are errors in reading/writing image stream "
//                    + e.getMessage());
//        } finally {
//            if (output != null)
//                try {
//                    output.close();
//                } catch (IOException ignore) {
//                }
//            if (input != null)
//                try {
//                    input.close();
//                } catch (IOException ignore) {
//                }
//        }
 
    }
}