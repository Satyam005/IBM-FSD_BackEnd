package org.employee.service;

import java.util.List;

import org.employee.dao.EmployeeDAO;
import org.employee.model.Employee;
import org.employee.model.User;

public class EmployeeService {

	EmployeeDAO dao = new EmployeeDAO();
	
	public int register(User user) {
		return dao.registerUser(user);
	}
	
	public User validate(String email, String password) {
		return dao.validateUser(email, password);
	}
	
	public int create(Employee<Integer> emp) {
		return dao.addEmp(emp);
	}
	
	public List<Employee<Integer>> getAll(){
		return dao.viewEmp();
	}
	
	public Employee<Integer> find(int empID){
		return dao.findEmp(empID);
	}
	
	public int update(Employee<Integer> emp) {
		return dao.updateEmp(emp);
	}
	
	public int delete(int empID) {
		return dao.deleteEmp(empID);
	}
	
	public void close() {
		dao.closeConn();
	}
}
