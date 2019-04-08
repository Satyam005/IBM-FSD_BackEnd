package com.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO dao ;
	
//	public int register(User user) {
//		return dao.registerUser(user);
//	}
//	
//	public User validate(String email, String password) {
//		return dao.validateUser(email, password);
//	}
	
	public int create(Employee<Integer> emp) {
		return dao.addEmp(emp);
	}
	
	public List<Employee<Integer>> getAll(){
		return dao.viewEmp();
	}
	
	public Employee<Integer> find(int empID){
		return dao.findEmp(empID);
	}
	
	public Employee<Integer> findByName(String empName){
		return dao.findEmpByName(empName);
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
