package com.assignment3.db.employee;

import com.assignment3.db.employee.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/assess3_employeedatabase";
	static final String DB_USER = "root";
	static final String DB_PASS = "pass@word1";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	EmployeeDAO() {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int addEmp(Employee<Integer> emp) {

		int status = 0;
		String insert = "insert into assess3_employeedatabase (name,age,gender,department,salary) values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, emp.getName());
			pstmt.setInt(2, emp.getAge());
			pstmt.setString(3, emp.getGender());
			pstmt.setString(4, emp.getDepartment());
			pstmt.setInt(5, emp.getSalary());

			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public List<Employee<Integer>> viewEmp() {

		List<Employee<Integer>> empList = new ArrayList<>();
		try {
			String select = "select id,name,age,gender,department,salary from assess3_employeedatabase";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String department = rs.getString("department");
				int salary = rs.getInt("salary");
				Employee<Integer> emp = new Employee<>(name, age, gender, department, salary);
				emp.setEmpID(id);

				empList.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	public Employee<Integer> findEmp(int empID) {
		Employee<Integer> emp = null;
		try {
			String find = "select id,name,age,gender,department,salary from assess3_employeedatabase where id=?";
			pstmt = conn.prepareStatement(find);
			pstmt.setInt(1, empID);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String department = rs.getString("department");
				int salary = rs.getInt("salary");
				emp = new Employee<>(name, age, gender, department, salary);
				emp.setEmpID(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return emp;

	}

	public int updateEmp(Employee<Integer> emp) {
		int status = 0;
		try {
			String update = "update assess3_employeedatabase set name=?,age=?,gender=?,department=?,salary=? where id=?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, emp.getName());
			pstmt.setInt(2, emp.getAge());
			pstmt.setString(3, emp.getGender());
			pstmt.setString(4, emp.getDepartment());
			pstmt.setInt(5, emp.getSalary());
			pstmt.setInt(6, emp.getEmpID());

			status = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}

	public int deleteEmp(int empID) {
		int status = 0;
		try {
			String delete = "delete from assess3_employeedatabase where id=?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, empID);

			status = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}

	public List<Employee<Integer>> sort(int byField) {

		List<Employee<Integer>> empList = new ArrayList<>();
		String query = "";
		if (byField == 1)
			query = "select id,name,age,gender,department,salary from assess3_employeedatabase order by name";
		else if (byField == 2)
			query = "select id,name,age,gender,department,salary from assess3_employeedatabase order by age";
		else if (byField == 3)
			query = "select id,name,age,gender,department,salary from assess3_employeedatabase order by salary desc";

		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String department = rs.getString("department");
				int salary = rs.getInt("salary");
				Employee<Integer> emp = new Employee<>(name, age, gender, department, salary);
				emp.setEmpID(id);

				empList.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	public List<Integer> countEmpByAge(int minAge){
		List<Integer> empIdList = new ArrayList<>();
		try {
			String query = "select id from assess3_employeedatabase where age>?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, minAge);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("id");
				empIdList.add(id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empIdList;
	}
	
	public Map<String, Integer> empCountByDept(){
		Map<String, Integer> deptMap = new LinkedHashMap<String, Integer>();
		
		try {
			String query = "select department,count(*) as total from assess3_employeedatabase group by department order by department";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String dept = rs.getString("department");
				int total = rs.getInt("total");
				deptMap.put(dept, total);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deptMap;
	}
	
	public Map<String, Integer> maxSalByDept(){
		Map<String, Integer> salMap = new LinkedHashMap<String, Integer>();
		
		try {
			String query = "select department,max(salary) as salary from assess3_employeedatabase group by department order by department";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String dept = rs.getString("department");
				int salary = rs.getInt("salary");
				salMap.put(dept, salary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salMap;
	}
	
	public Map<String, Integer> avgSalDept(){
		Map<String, Integer> avgSalMap = new LinkedHashMap<String, Integer>();
		
		try {
			String query = "select department,avg(salary) as avg from assess3_employeedatabase group by department order by department";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String dept = rs.getString("department");
				int avgSal = rs.getInt("avg");
				avgSalMap.put(dept, avgSal);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avgSalMap;
	}
	
	void closeConn() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}