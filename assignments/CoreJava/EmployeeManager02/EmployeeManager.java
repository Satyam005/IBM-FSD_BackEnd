package com.assignment02.java;

import com.assignment02.java.EmployeeService;

public class EmployeeManager {

	public static void main(String[] args) {
		
		EmployeeService service = new EmployeeService();

		try {
			int input = 0;
			do {
				int exit = -1;
				System.out.println();
				System.out.println("-----------------------EMPLOYEE MANAGEMENT----------------------");
				System.out.println("                       ___________________                      \n");
				System.out.println("\t1.\t\tADD EMPLOYEES\n");
				System.out.println("\t2.\t\tVIEW EMPLOYEES\n");
				System.out.println("\t3.\t\tSEARCH EMPLOYEES\n");
				System.out.println("\t4.\t\tUPDATE EMPLOYEES\n");
				System.out.println("\t5.\t\tDELETE EMPLOYEES\n");
				System.out.println("\t6.\t\tSORT EMPLOYEES\n");
				System.out.println("\t7.\t\tPRINT STATISTICS\n");
				System.out.println("\t0.\t\tEXIT\n ");

				System.out.println("\tENTER OPTION: ");
				input = service.acceptValidInteger();
				if (input == -1)
					return;

				System.out.println();
				switch (input) {
				case 0:
					exit = 1;
					break;
				case 1:
					service.addEmp();
					break;
				case 2:
					service.viewEmp();
					break;
				case 3:
					service.searchEmp();
					break;
				case 4:
					service.updateEmp();
					break;
				case 5:
					service.deleteEmp();
					break;
				case 6:
					service.sortEmp();
					break;
				case 7:
					service.printStatistics();
					break;
				default:
					System.err.println("INVALID SELECTION...!!!!");
				}
				if (exit == 1)
					break;
			} while (input != 0);
		} catch (Exception e) {
			System.out.println("SOMETHING WENT WRONG...!");
			System.out.println(e.getMessage());
		}

	}
}