package com.assignment02.java;
import java.util.*;

public class EmployeeService {

    Scanner sc = new Scanner(System.in);

    // Creating a HashMap for the employees
    Map<Integer, Employee<Integer>> employees = new HashMap<>();

    // Used to make divider and row lines
    String line = new String(new char[84]).replace('\0', '-');
    String row = new String(new char[84]).replace('\0', '-');

    // Custom comparator for sorting employee by name
    Comparator EMP_BY_NAME = new Comparator() {
        public int compare(Object o1, Object o2) {

            return ((Employee) o1).getName().compareTo(((Employee) o2).getName());
        };
    };

    // Custom comparator for sorting employee by age ascending
    Comparator EMP_BY_AGE = new Comparator() {
        public int compare(Object o1, Object o2) {
            return ((Employee) o1).getAge() - ((Employee) o2).getAge();
        };
    };

    // Custom comparator for sorting employee by salary descending
    Comparator EMP_BY_SALARY = new Comparator() {
        public int compare(Object o1, Object o2) {
            return ((Employee) o2).getSalary() - ((Employee) o1).getSalary();
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

    // Method to print the list of employees
    public void print(Collection<Employee<Integer>> list) {

        System.out.printf("%s%n", line);
        System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-15s | %-10s | %n", "ID", "Name", "Age", "Gender",
                "Department", "Salary");
        System.out.printf("%s%n", line);
        for (Employee emp : list) {
            System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-15s | %-10s | %n", emp.getEmpID(), emp.getName(),
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
        if (employees.containsKey(empId)) {
            Employee<Integer> emp = employees.get(empId);
            System.out.printf("%s%n", line);
            System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-15s | %-10s | %n", "ID", "Name", "Age", "Gender",
                    "Department", "Salary");
            System.out.printf("%s%n", line);

            System.out.printf("| %-5s | %-20s | %-5s | %-10s | %-15s | %-10s | %n", emp.getEmpID(), emp.getName(),
                    emp.getAge(), emp.getGender(), emp.getDepartment(), emp.getSalary());
            System.out.printf("%s%n", row);
        } else {
            System.out.println("No employee present with ID:" + empId);
            System.out.println();
        }
    }

    // Method to view all employee records
    public void viewEmp() {
        print(employees.values());
    }

    // Method to add an employee
    public void addEmp() {
        try {
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

            // creating new employee object
            Employee<Integer> emp = new Employee<>(name, age, gender, dept, salary);

            // adding entry to the HashMap
            employees.put(emp.getEmpID(), emp);

            System.out.println("\nEmployee added successfully..");

        } catch (Exception e) {
            System.out.println("\nSomething went wrong..!!");
            System.out.println(e.getMessage());
        }
    }

    // Method to delete an employee
    public void deleteEmp() {
        try {
            System.out.println("\nEnter employee ID:");
            int empId = acceptValidInteger();
            if (empId == -1)
                return;

            if (employees.containsKey(empId)) {
                employees.remove(empId);
                System.out.println("\nEmployee deleted successfully");
            } else {
                System.out.println("\nNo employee present with ID:" + empId);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("\nSomething went wrong..!!");
            System.out.println(e.getMessage());
        }
    }

    // Method to update employee details
    public void updateEmp() {
        try {
            System.out.println("\nEnter employee ID:");
            int empId = acceptValidInteger();
            if (empId == -1)
                return;

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

                System.out.println("\nEmployee updated successfully..");

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
            System.out.println("\nInvalid choice");
        }
    }

    // Method to print statistics
    public void printStatistics() {

        Collection<Employee<Integer>> values = employees.values();
        Map<String, Integer> empCountByDept = new HashMap<>();
        Map<String, Integer> maxSalByDept = new HashMap<>();
        Map<String, Integer> totalSalByDept = new HashMap<>();

        for (Employee emp : values) {
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

        for (Employee emp : values) {
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
}