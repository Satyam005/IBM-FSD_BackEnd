package org.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.employee.model.User;
import org.employee.service.EmployeeService;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		EmployeeService service = new EmployeeService();
		
		User user = null;
		user = service.validate(email, pass);
		RequestDispatcher rd = null;
		if(user != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", user.getName());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("uid", user.getId());
			session.setAttribute("loggedIn", true);
			
			response.sendRedirect("EmployeeList.do");
		}
		else {
			rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("errorMessage", "Invalid Username/Password");
			service.close();
			rd.forward(request, response);
		}
	}

}
