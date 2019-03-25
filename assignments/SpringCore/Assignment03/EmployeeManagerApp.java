package com.assignment03.spring.core.empmngautwiring;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeManagerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// EmployeeService service = new EmployeeService();

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-empmngapp-config.xml");

		EmployeeService service = (EmployeeService) context.getBean("service");

		Callable callExport = new Callable() {
			@Override
			public Object call() throws Exception {
				try {
					System.out.println("Waiting 5 seconds to export.....");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// throw new MyException();
				}
				service.export();
				return null;
			}
		};

		Callable callImport = new Callable() {

			@Override
			public Object call() throws Exception {
				// TODO Auto-generated method stub
				try {
					System.out.println("Waiting 5 seconds to import.....");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// throw new MyException();
				}
				service.bulkImport();
				return null;
			}

		};

		try {
			int input = 0;
			do {
				int exit = -1;
				System.out.println();
				System.out.println("--------------------WELCOME TO EMPLOYEE MANAGEMENT APP..!!!--------------------");
				System.out.println("                    _______________________________________                     \n");
				System.out.println("1.\t\tADD EMPLOYEES");
				System.out.println("2.\t\tVIEW EMPLOYEES");
				System.out.println("3.\t\tFIND EMPLOYEES");
				System.out.println("4.\t\tUPDATE EMPLOYEES");
				System.out.println("5.\t\tDELETE EMPLOYEES");
				System.out.println("6.\t\tSORT EMPLOYEES");
				System.out.println("7.\t\tPRINT STATISTICS");
				System.out.println("8.\t\tEXPORT");
				System.out.println("9.\t\tIMPORT");
				System.out.println("0.\t\tEXIT\n ");

				System.out.println("ENTER OPTION : ");
				input = service.acceptValidInteger();
				if (input == -1)
					return;

				System.out.println();
				switch (input) {
				case 0:
					exit = 1;
					service.close();
					break;
				case 1:
					service.add();
					break;
				case 2:
					service.view();
					break;
				case 3:
					service.find();
					break;
				case 4:
					service.update();
					break;
				case 5:
					service.delete();
					break;
				case 6:
					service.sort();
					break;
				case 7:
					service.printStatistics();
					break;
				case 8:
					ExecutorService es = Executors.newFixedThreadPool(1);
					Future f = es.submit(callExport);
					while (!f.isDone())
						;
					System.out.println("Export done successfully");
					es.shutdown();
					break;
				case 9:
					ExecutorService es1 = Executors.newFixedThreadPool(1);
					Future f1 = es1.submit(callImport);
					while (!f1.isDone())
						;
					System.out.println("Import done successfully");
					es1.shutdown();
					break;
				default:
					System.err.println("Invalid Selection");
				}
				if (exit == 1)
					break;
			} while (input != 0);
		} catch (Exception e) {
			System.out.println("Something went wrong");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			context.registerShutdownHook();
		}
	}

}