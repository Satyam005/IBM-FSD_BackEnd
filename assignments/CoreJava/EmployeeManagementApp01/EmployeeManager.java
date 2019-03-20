package com.assignmentempapp1.java;

public class EmployeeManager {

	public static void main(String[] args) {

		EmployeeService service = new EmployeeService();

		try {
			int input = 0;
			do {
				int exit = -1;
				System.out.println();
				System.out.println("--------------------EMPLOYEE MANAGEMENT--------------------");
				System.out.println("                    ____________________                     \n");
				System.out.println("1.\t\tADD EMPLOYEES");
				System.out.println("2.\t\tVIEW EMPLOYEES");
				System.out.println("3.\t\tSEARCH EMPLOYEES");
				System.out.println("4.\t\tUPDATE EMPLOYEES");
				System.out.println("5.\t\tDELETE EMPLOYEES");
				System.out.println("6.\t\tSORT EMPLOYEES");
				System.out.println("7.\t\tPRINT STATISTICS");
				System.out.println("8.\t\tEXPORT");
				System.out.println("9.\t\tIMPORT");
				System.out.println("0.\t\tEXIT ");

				System.out.println("\nENTER OPTION : ");
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
				case 8:
					service.export();
					break;
				case 9:
					service.bulkImport();
					break;
				default:
					System.err.println("INVALID SELECTION....!!");
				}
				if (exit == 1)
					break;
			} while (input != 0);
		} catch (Exception e) {
			System.out.println("Something Went Wrong");
			System.out.println(e.getMessage());
		}

	}
}