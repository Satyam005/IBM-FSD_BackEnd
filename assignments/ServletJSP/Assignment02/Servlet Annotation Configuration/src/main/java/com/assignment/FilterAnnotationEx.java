package com.assignment;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterAnnotationEx
 */
@WebFilter(filterName="WelcomeLog", urlPatterns = { "/welcome","/Welcome","/home","/Home" })
public class FilterAnnotationEx implements Filter {

    public FilterAnnotationEx() {

    }

	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("Entered WelcomeLog doFilter()");
		System.out.println("protocol is " + request.getProtocol());
		System.out.println("remote host is " + request.getRemoteHost());
		System.out.println("content type is " + request.getContentType());
		System.out.println("content length is " + request.getContentLength());
		System.out.println("message is " + request.getParameter("message"));
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
