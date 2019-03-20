package com.assignmentempapp1.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeService {

	Scanner sc = new Scanner(System.in);

	boolean validate(Employee<Integer> emp, Predicate<Employee<Integer>> validator) {
		return validator.test(emp);
	}

	// Used to make divider and row lines
	String line = new String(new char[89]).replace('\0', '-');
	String row = new String(new char[89]).replace('\0', '-');

	// Custom comparator for sorting employee by name
	Comparator<Employee<Integer>> EMP_BY_NAME = new Comparator<Employee<Integer>>() {
		public int compare(Employee<Integer> o1, Employee<Integer> o2) {

			return o1.getName().compareTo(o2.getName());
		}


	};

	// Custom comparator for sorting employee by age ascending
	Comparator<Employee<Integer>> EMP_BY_AGE = new Comparator<Employee<Integer>>() {
		public int compare(Employee<Integer> o1, Employee<Integer> o2) {
			return o1.getAge() - o2.getAge();
		};
	};

	// Custom comparator for sorting employee by salary descending
	Comparator<Employee<Integer>> EMP_BY_SALARY = new Comparator<Employee<Integer>>() {
		public int compare(Employee<Integer> o1, Employee<Integer> o2) {
			return o2.getSalary() - o1.getSalary();
		};
	};

	// Method to accept a valid integer number from console
	public int acceptValidInteger() {
		int num;

		// Check for a valid number
		while (true) {
			int flag = 0;
			try {
				num = sc.nextInt();
				if (num == 0)
					return -1;
				if (num < 0)
				{
					flag = 1;
					throw new InputMismatchException();
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Not a valid number");
				System.out.println("Enter a valid number OR Press 0 to return to main menu");
				if(flag == 0) {
					sc.next();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		sc.nextLine(); // to consume the next line character after reading integer
		return num;
	}

	@SuppressWarnings("unchecked")
	public TreeMap<Integer, Employee<Integer>> readFromFile(){
		
		TreeMap<Integer, Employee<Integer>> treeMap = null;
		
		File file = new File("D:\\EmpDBApp1\\empDB.dat");
		if(file.length()>0)
		{
			try {
				FileInputStream fin = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fin);
				treeMap = (TreeMap<Integer, Employee<Integer>>)in.readObject();
				
				in.close();
				fin.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			treeMap = new TreeMap<Integer, Employee<Integer>>();
		}
		
		return treeMap;
	}
	
	public void writeToFile(TreeMap<Integer, Employee<Integer>> treeMap) {
		
		try {
			File file = new File("D:\\EmpDBApp1\\empDB.dat");
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			
			out.writeObject(treeMap);
			out.close();
			fout.close();
			System.out.println("Employee Data Saved....");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	// Method to print the list of employees
	public void print(Collection<Employee<Integer>> list) {

		System.out.printf("%s%n", line);
		System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-20s | %-10s | %n", "ID", "Name", "Age", "Gender","Department", "Salary");
		System.out.printf("%s%n", line);
		for (Employee<Integer> emp : list) {
			System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-20s | %-10s | %n", emp.getEmpID(), emp.getName(),
					emp.getAge(), emp.getGender(), emp.getDepartment(), emp.getSalary());
			System.out.printf("%s%n", row);
		}
	}

	// Method to search an employee based on employee ID
	public void searchEmp() {
		System.out.println("Enter employee ID:");
		int empId = acceptValidInteger();
		if (empId == -1)
			return;
		
		TreeMap<Integer, Employee<Integer>> employees = readFromFile();
		
		if (employees.containsKey(empId)) {
			Employee<Integer> emp = employees.get(empId);
			System.out.printf("%s%n", line);
			System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-20s | %-10s | %n", "ID", "Name", "Age", "Gender",
					"Department", "Salary");
			System.out.printf("%s%n", line);

			System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-20s | %-10s | %n", emp.getEmpID(), emp.getName(),
					emp.getAge(), emp.getGender(), emp.getDepartment(), emp.getSalary());
			System.out.printf("%s%n", row);
		} else {
			System.out.println("No employee present with ID:" + empId);
			System.out.println();
		}
	}

	// Method to view all employee records
	public void viewEmp() {
		
		TreeMap<Integer, Employee<Integer>> treeMap = readFromFile();
		if(treeMap.isEmpty()) {
			System.out.println("No Employee record present");
		}
		else
		{
			print(treeMap.values());
		}
	}

	// Method to add an employee
	public void addEmp() {
		try {
			System.out.println("Enter Name:");
			String name = sc.nextLine();

			System.out.println("Enter DOB: (dd/MM/yyyy)");
			String dob = sc.nextLine();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate birthday = LocalDate.parse(dob,formatter);
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
				return;

			// creating new employee object
			Employee<Integer> emp = new Employee<>(1,name, age, gender, dept, salary);
			
				boolean isValidData = validate(emp, emp1 -> {
					
					if((emp1.getAge()>0 && emp1.getAge()<=50) && emp1.getSalary()>=10000) {
						//System.out.println("Employee Saved successfully");
						return true;
					}
					else {
						System.out.println("Invalid employee details");
						return false;
					}
							
				});

				if(isValidData) {
					// adding entry to the HashMap
					TreeMap<Integer, Employee<Integer>> treeMap = readFromFile();
					if(!treeMap.isEmpty()) {
						int id = treeMap.lastKey()+1;
						emp.setEmpID(id);
						treeMap.put(id, emp);
					}else
					{
						treeMap.put(1, emp);
					}
					
					writeToFile(treeMap);

				}

		} catch (Exception e) {
			System.out.println("\nSomething Went Wrong..!!");
			System.out.println(e.getMessage());
		}
	}

	// Method to delete an employee
	public void deleteEmp() {
		try {
			System.out.println("\nEnter Employee ID:");
			int empId = acceptValidInteger();
			if (empId == -1)
				return;

			TreeMap<Integer, Employee<Integer>> employees = readFromFile();
			
			if (employees.containsKey(empId)) {
				employees.remove(empId);
				writeToFile(employees);
				System.out.println("\nEmployee Deleted Successfully");
			} else {
				System.out.println("\nNo Employee present with ID:" + empId);
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("\nSomething Went Wrong..!!");
			System.out.println(e.getMessage());
		}
	}

	// Method to update employee details
	public void updateEmp() {
		try {
			System.out.println("\nEnter Employee ID:");
			int empId = acceptValidInteger();
			if (empId == -1)
				return;

			TreeMap<Integer, Employee<Integer>> employees = readFromFile();
			
			if (employees.containsKey(empId)) {

				System.out.println("Enter Name:");
				String name = sc.nextLine();

				System.out.println("Enter Age:");
				int age = acceptValidInteger();
				if (age == -1)
					return;

				System.out.println("Enter Gender (Male/Female):");
				String gender = sc.nextLine();

				System.out.println("Enter Department:");
				String dept = sc.nextLine();

				System.out.println("Enter Salary:");
				int salary = acceptValidInteger();
				if (salary == -1)
					return;

				Employee<Integer> emp = employees.get(empId);

				// Updating values
				emp.setName(name);
				emp.setAge(age);
				emp.setGender(gender);
				emp.setDepartment(dept);
				emp.setSalary(salary);

				// replacing value on the same key to the HashMap
				employees.put(empId, emp);
				writeToFile(employees);

				System.out.println("\nEmployee Updated successfully..");

			} else {
				System.out.println("\nNo employee present with ID:" + empId);
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("\nSomething went wrong..!!");
			System.out.println(e.getMessage());
		}
	}

	// Method to perform sorting on employee records
	public void sortEmp() {

		TreeMap<Integer, Employee<Integer>> employees = readFromFile();
		ArrayList<Employee<Integer>> list = new ArrayList<>(employees.values());
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
			Collections.sort(list, EMP_BY_NAME);
			print(list);
			break;
		case 2:
			Collections.sort(list, EMP_BY_AGE);
			print(list);
			break;
		case 3:
			Collections.sort(list, EMP_BY_SALARY);
			print(list);
			break;
		default:
			System.out.println("\nINVALID CHOICE");
		}
	}

	// Method to print statistics
	public void printStatistics() {

		TreeMap<Integer, Employee<Integer>> employees = readFromFile();
		Collection<Employee<Integer>> values = employees.values();
		
		long count = values.stream().filter(emp -> emp.getAge() > 25).count();
		System.out.println("No. of employees with age greater than 25: "+ count);
		
		List<Integer> empIds = values
				.stream()
				.filter(emp -> emp.getAge() > 25)
				.map(emp -> emp.getEmpID())
				.collect(Collectors.toList());
		System.out.print("Employee ID of employees having age greater than 25: " );
		empIds.forEach(item -> System.out.print(item+" "));
		System.out.println();
		
		Map<String,Long> empByDept= values
		.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		
		System.out.println("Employee count by department using stream ");
		for(Map.Entry<String, Long> dept : empByDept.entrySet()) {
			System.out.println(dept.getKey()+" "+dept.getValue());
		}
		
		System.out.println("Employee count by department ordered using stream");
		Map<String, Long> orderedEmpByDept = values
		.stream()
		.sorted(Comparator.comparing(Employee::getDepartment))
		.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new,Collectors.counting()));
		
		for(Map.Entry<String, Long> m : orderedEmpByDept.entrySet()) {
			System.out.println(m.getKey()+" : "+m.getValue());
		}
		
		Map<String,Double> avgByDept=values.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
		
		System.out.println("Avg salary by department using stream");
		for(Map.Entry<String, Double> avg : avgByDept.entrySet()) {
			System.out.println(avg.getKey()+" "+avg.getValue());
		}
		
		System.out.println("Departments having employee count greater than 2");
		values
		.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
		.entrySet()
		.stream()
		.filter(m -> m.getValue()>2)
		.map(m -> m.getKey())
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		
		Map<String, Integer> empCountByDept = new HashMap<>();
		Map<String, Integer> maxSalByDept = new HashMap<>();
		Map<String, Integer> totalSalByDept = new HashMap<>();

		for (Employee<Integer> emp : values) {
			String dept = emp.getDepartment();
			int currSal = emp.getSalary();
			if (empCountByDept.containsKey(dept) && totalSalByDept.containsKey(dept)) {
				empCountByDept.put(dept, empCountByDept.get(dept) + 1);
				totalSalByDept.put(dept, totalSalByDept.get(dept) + currSal);
			} else {
				empCountByDept.put(dept, 1);
				totalSalByDept.put(dept, currSal);
			}
		}

		System.out.print("\nEmployees by department:\t");
		for (Map.Entry<String, Integer> m : empCountByDept.entrySet()) {
			System.out.print(m.getKey() + "[" + m.getValue() + "]\t");
		}
		System.out.println();

		for (Employee<Integer> emp : values) {
			String dept = emp.getDepartment();
			int currSal = emp.getSalary();
			if (maxSalByDept.containsKey(dept)) {
				int prevSal = maxSalByDept.get(dept);
				if (currSal > prevSal) {
					maxSalByDept.put(dept, currSal);
				}
			} else {
				maxSalByDept.put(dept, currSal);
			}
		}

		System.out.println("\nHighest Salary in each department");
		for (Map.Entry<String, Integer> m : maxSalByDept.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
		}

		System.out.println("\nAverage Salary by department");
		for (Map.Entry<String, Integer> m : empCountByDept.entrySet()) {
			System.out.println(m.getKey() + " : " + totalSalByDept.get(m.getKey()) / m.getValue());
		}
	}
	
	public void export() {
		
		TreeMap<Integer, Employee<Integer>> employees = readFromFile();
		
		try {
			File file = new File("D:\\EmpDBApp1\\empDBex.txt");
			PrintWriter pw = new PrintWriter(file);
			
			for(Employee<Integer> emp : employees.values()) {
				
				pw.printf("%d,%s,%d,%s,%s,%d%n", emp.getEmpID(),emp.getName(),emp.getAge(),emp.getGender(),emp.getDepartment(),emp.getSalary());
			}
			pw.close();
			System.out.println("Export done successfully");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bulkImport() {
		
		try {
			
			TreeMap<Integer, Employee<Integer>> employees = readFromFile();
			int id = 0;
			int empCount = 0;
			
			if(employees.isEmpty())
				id = 1;
			else
				id = employees.lastKey()+1;
			
			File file = new File("D:\\EmpDBApp1\\empDBim.txt");
			
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
			
				empCount++;
				String word[] = sc.nextLine().split(",");
				String name = word[0];
				int age = Integer.parseInt(word[1]);
				String gender = word[2];
				String dept = word[3];
				int salary = Integer.parseInt(word[4]);
				
				Employee<Integer> emp = new Employee<>(id,name,age,gender,dept,salary);
				employees.put(id,emp);
				System.out.println(emp);
				id++;
				
			}
			sc.close();
			
			writeToFile(employees);
			System.out.println(empCount+" employee(s) imported successfully");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}