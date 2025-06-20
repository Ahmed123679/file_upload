package com.udacity.file_upload.servlet;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "helloServlet" , urlPatterns = {"/servlet" , "/helloServlet"})
public class HelloServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        
            response.getWriter().write("Hello to My Servlet");
    }

}   
