package com.assignment;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ListenerAnnotationEx implements ServletRequestListener {

    
    public ListenerAnnotationEx() {
        
    }

	
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	ServletContext servletContext = sre.getServletContext();
        servletContext.log("Request destroyed");
        System.out.println("System.out: Request destroyed");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	ServletContext servletContext = sre.getServletContext();
	    servletContext.log("New request initialized");
	    System.out.println("System.out: New request initialized");
    }
	
}
