package com.assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAnnotationEx
 */
@WebServlet(name="Welcome", urlPatterns= {"/welcome","/Welcome","/home","/Home" })
public class ServletAnnotationEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAnnotationEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext=request.getServletContext();
		servletContext.log("Starting SimpleServlet");
		System.out.println("System.out: Starting SimpleServlet");
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h3>");
		printWriter.println("Welcome..!! This page is made using Servlet");
		printWriter.println("</h3>");
		servletContext.log("Ending SimpleServlet");
		System.out.println("System.out: Ending SimpleServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
