package com.udacity.file_upload.listener;


import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;


public class HelloListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        
        System.out.println(sre.getServletRequest().getServletContext().toString()
        + " has been destroyed"
        );
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println(sre.getServletRequest().getServletContext().toString()
        + " has been initialzed"
        );
    }

    
    
}
