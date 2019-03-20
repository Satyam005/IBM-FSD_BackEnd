package com.assignment3.db.employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

import com.assignment3.db.employee.Employee;

public class EmployeeService {

	EmployeeDAO dao = new EmployeeDAO();
	Scanner sc = new Scanner(System.in);
	
	String line = new String(new char[89]).replace('\0', '-');
	String row = new String(new char[89]).replace('\0', '-');

	boolean validate(Employee<Integer> emp, Predicate<Employee<Integer>> validator) {
		return validator.test(emp);
	}

	public int acceptValidInteger() {
		int num;
		// Check for a valid number
		while (true) {
			int flag = 0;
			try {
				num = sc.nextInt();
				if (num == 0)
					return -1;
				if (num < 0) {
					flag = 1;
					throw new InputMismatchException();
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Not a valid number");
				System.out.println("Enter a valid number OR Press 0 to return to main menu");
				if (flag == 0) {
					sc.next();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		sc.nextLine(); // to consume the next line character after reading integer
		return num;
	}

	public Employee<Integer> acceptEmpInput() {
		Employee<Integer> emp = null;
		boolean isValidData = false;
		try {
			System.out.println("Enter Name:");
			String name = sc.nextLine();

			System.out.println("Enter DOB: (dd/MM/yyyy)");
			String dob = sc.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate birthday = LocalDate.parse(dob, formatter);
			LocalDate today = LocalDate.now();
			Period p = Period.between(birthday, today);
			int age = p.getYears();

			System.out.println("Enter Gender (Male/Female):");
			String gender = sc.nextLine();
			System.out.println("Enter Department:");
			String dept = sc.nextLine();
			System.out.println("Enter Salary: (Salary should be greater than 10000)");
			int salary = acceptValidInteger();
			if (salary == -1)
				return null;

			emp = new Employee<>(name, age, gender, dept, salary);
			isValidData = validate(emp, e -> {
				if ((e.getAge() > 20 && e.getAge() < 65) && e.getSalary() >= 10000)
					return true;
				else {
					System.out.println("Criteria not met. Invalid employee deatils..!");
					return false;
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (isValidData)
			return emp;
		else
			return null;
	}

	public void print(List<Employee<Integer>> empList)
	{
		System.out.printf("%s%n", line);
		System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-20s | %-10s | %n", "ID", "Name", "Age", "Gender","Department", "Salary");
		System.out.printf("%s%n", line);
		for (Employee<Integer> emp : empList) {
			System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-20s | %-10s | %n", emp.getEmpID(), emp.getName(),
					emp.getAge(), emp.getGender(), emp.getDepartment(), emp.getSalary());
			System.out.printf("%s%n", row);
		}
	}
	
	public void add() {
		Employee<Integer> emp = acceptEmpInput();
		if (emp == null)
			return;

		int status = dao.addEmp(emp);
		if (status > 0)
			System.out.println("Employee Added..");
		else
			System.out.println("Something Went Wrong..!!");
	}
	
	public void view() {
		List<Employee<Integer>> empList = dao.viewEmp();
		if(empList.isEmpty())
			System.out.println("No Employee Records Available..!!");
		else
			print(empList);
	}
	
	public void find(){
		System.out.println("Enter Employee id");
		int empID = sc.nextInt();
		Employee<Integer> emp = dao.findEmp(empID);
		if(emp == null)
			System.out.println("No Employee present with ID: "+empID);
		else
		{
			System.out.printf("%s%n", line);
			System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-20s | %-10s | %n", "ID", "Name", "Age", "Gender",
					"Department", "Salary");
			System.out.printf("%s%n", line);

			System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-20s | %-10s | %n", emp.getEmpID(), emp.getName(),
					emp.getAge(), emp.getGender(), emp.getDepartment(), emp.getSalary());
			System.out.printf("%s%n", row);
		}
	}
	
	public void update() {
		System.out.println("Enter employee id");
		int empID = sc.nextInt();
		sc.nextLine();
		Employee<Integer> empToFind = dao.findEmp(empID);
		if(empToFind == null)
			System.out.println("No Employee present with ID: "+empID);
		else
		{
			Employee<Integer> empToUpdate = acceptEmpInput();
			empToUpdate.setEmpID(empID);
			int status = dao.updateEmp(empToUpdate);
			if(status>0)
				System.out.println("Employee Updated.");
			else
				System.out.println("Something Went Wrong");
		}
	}
	
	public void delete() {
		System.out.println("Enter Employee id");
		int empID = sc.nextInt();
		sc.nextLine();
		Employee<Integer> empToFind = dao.findEmp(empID);
		if(empToFind == null)
			System.out.println("No employee present with ID: "+empID);
		else
		{
			int status = dao.deleteEmp(empID);
			if(status>0)
				System.out.println("Employee Deleted.");
			else
				System.out.println("Something Went Wrong");
		}
	}
	
	public void sort() {
		
		System.out.println("Sort By:");
		System.out.println("1. Name\t 2. Age\t 3. Salary\t 0. Return to main menu");
		System.out.println("\nEnter option: ");

		int choice = acceptValidInteger();
		if (choice == -1)
			return;
		switch (choice) {
		case 0:
			return;
		case 1:
			print(dao.sort(1));
			break;
		case 2:
			print(dao.sort(2));
			break;
		case 3:
			print(dao.sort(3));
			break;
		default:
			System.out.println("\nINVALID CHOICE....!!");
		}
	}
	
	public void printStatistics() {
		System.out.println("---------------Employee Statistics---------------");
		List<Integer> empIdList = dao.countEmpByAge(30);
		System.out.println("Employee older than 30 years: "+empIdList.size());
		System.out.print("List of employee ID(s) older than 30 years: ");
		for(Integer id : empIdList)
			System.out.print(id+" ");
		
		Map<String, Integer> deptMap = dao.empCountByDept();
		System.out.println("\n\nEmployee count by Department");
		for(Map.Entry<String, Integer> map : deptMap.entrySet()) {
			System.out.println(map.getKey()+" : "+map.getValue());
		}
		
		Map<String, Integer> salMap = dao.maxSalByDept();
		System.out.println("\nHighest Salary in each Department");
		for(Map.Entry<String, Integer> map : salMap.entrySet()) {
			System.out.println(map.getKey()+" "+map.getValue());
		}
		
		Map<String, Integer> avgSalMap = dao.avgSalDept();
		System.out.println("\nAverage Salary by Department");
		for(Map.Entry<String, Integer> map : avgSalMap.entrySet()) {
			System.out.println(map.getKey()+" : "+map.getValue());
		}
		
		System.out.println();
		
	}
	
	public synchronized void export() {
		List<Employee<Integer>> empList = dao.viewEmp();
		try {
			File file = new File("D:\\Assess3_EmployeeDatabase\\employees_export.txt");
			PrintWriter pw = new PrintWriter(file);
			
			for(Employee<Integer> emp : empList) {
				
				pw.printf("%d,%s,%d,%s,%s,%d%n", emp.getEmpID(),emp.getName(),emp.getAge(),emp.getGender(),emp.getDepartment(),emp.getSalary());
			}
			pw.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void bulkImport() {
		int empCount = 0;
		try {
			File file = new File("D:\\Assess3_EmployeeDatabase\\employees_import.txt");
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
			
				String word[] = sc.nextLine().split(",");
				String name = word[0];
				int age = Integer.parseInt(word[1]);
				String gender = word[2];
				String dept = word[3];
				int salary = Integer.parseInt(word[4]);
				
				Employee<Integer> emp = new Employee<>(name,age,gender,dept,salary);
				int status = dao.addEmp(emp);
				if(status>0)
				empCount++;
			}
			sc.close();
			System.out.println(empCount+" Employee(s) Imported Successfully..");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void close() {
		dao.closeConn();
	}
}
