package org.employee.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.employee.model.Employee;
import org.employee.service.EmployeeService;

/**
 * Servlet implementation class EmployeeAddServlet
 */
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAddServlet() {
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
		String name = request.getParameter("name").trim();
		String dob = request.getParameter("dob").trim();
		String gender = request.getParameter("gender").trim();
		String dept = request.getParameter("department").trim();
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		//System.out.println("dob:"+dob);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate birthday = LocalDate.parse(dob, formatter);
		LocalDate today = LocalDate.now();
		Period p = Period.between(birthday, today);
		int age = p.getYears();
		
		Employee<Integer> emp = new Employee<>(name, age, gender, dept, salary);
		EmployeeService service = new EmployeeService();
		
		int status = service.create(emp);
		String msg = "";
		RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
		
		if(status<1) {
			msg = "Something went wrong..!! Try again.";
		}
		else {
			msg = "Employee Added ..!!";
		}
		request.setAttribute("msg", msg);
		rd.forward(request, response);
	}

}
