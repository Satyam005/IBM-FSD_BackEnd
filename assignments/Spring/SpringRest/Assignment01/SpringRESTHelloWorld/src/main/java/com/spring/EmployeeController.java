package com.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;

	@RequestMapping(value = "/status", method = RequestMethod.GET, produces = { "text/plain" })
	public String status() {
		return "Welcome to Employee REST Services";
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ResponseBody
	public List<Employee<Integer>> allEmployee() {
		//EmployeeService service = new EmployeeService();
		List<Employee<Integer>> empList = service.getAll();
		return empList;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST,consumes = { "application/json" } , produces = { "application/json" })
	@ResponseBody
	public Employee<Integer> addEmployee(@RequestBody Employee<Integer> emp) {
		//EmployeeService service = new EmployeeService();
		int status = service.create(emp);
		//String message="";
		if(status>=1)
		{
			Employee<Integer> empObj = service.findByName(emp.getName());
			return empObj;
		}
		else
			return null;
	}
	
	@RequestMapping(value = "/employee/{eId}", method = RequestMethod.GET)
	public Employee<Integer> findEmployee(@PathVariable String eId) {
		Employee<Integer> emp = null;
		
		int empID = Integer.parseInt(eId);
		//EmployeeService service = new EmployeeService();
		emp = service.find(empID);
		
		return emp;
	}
	
	@RequestMapping(value = "/employee/{eId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteEmployee(@PathVariable String eId) {
		
		int empID = Integer.parseInt(eId);
		
		int status = service.delete(empID);
		if(status>=1)
			return "Employee Deleted";
		return "";
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	@ResponseBody
	public String updateEmployee(@RequestBody Employee<Integer> emp) {
		
		int status = service.update(emp);
		if(status>=1)
			return "Employee Updated";
		return "";
	}
}
