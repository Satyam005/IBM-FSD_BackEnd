package org.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.employee.model.User;
import org.employee.service.EmployeeService;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeService service = new EmployeeService();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		User user = new User(name,email);
		user.setPassword(password);
		
		int status = service.register(user);
		RequestDispatcher rd = null;
		
		service.close();
		if(status<1) {
			rd = request.getRequestDispatcher("register.jsp");
			request.setAttribute("errorMessage", "Something went wrong..!! Try Again");
			rd.forward(request, response);
		}
		else {
			rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("message", "Registration Successfull..!!");
			rd.forward(request, response);
		}
	}

}
