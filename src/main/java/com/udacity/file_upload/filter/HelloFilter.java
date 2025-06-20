package com.udacity.file_upload.filter;

import java.io.IOException;
import java.net.http.HttpResponse;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;


@WebFilter(urlPatterns = {"/servlet"})
public class HelloFilter implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException 
        {
            String username = (String)req.getParameter("name");
            System.out.println("user: " + username + " requests /servlet");
            if(username.equals("Ahmed")) 
           {
               chain.doFilter(req, res);
           }else {
                res.getWriter().println("Access Denied");
           }
            System.out.println("Request has been processed");
        
        }
    
}
