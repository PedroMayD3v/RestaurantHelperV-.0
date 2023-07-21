package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entites.Admin;
import model.entites.Employee;
import model.entites.Seller;
import model.enums.EmployeerFunctions;
import model.services.ConcreteAdminServices;
import model.services.ConcreteLoginServices;
import model.services.LoginServices;


public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Employee admin = new Admin();
		Employee seller = new Seller();
		List<Employee> registration = new ArrayList<>();
		ConcreteAdminServices adminServices = new ConcreteAdminServices();
		LoginServices login = null;
		String option;
		int n;

		UI.WelcomeMessage();

		System.out.println("How many employeers will be read? ");
		System.out.print(">> ");
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println("Type the first type will be read: ");
			System.out.println();

			UI.ShowOptions();
			System.out.print(">> ");
			option = sc.next();

			if (option.equalsIgnoreCase("Employeer")) {
				sc.nextLine();
				System.out.println("===========================");
				System.out.print("Enter complete name: ");
				String nameOfEmployee = sc.nextLine();
				System.out.print("Enter the salary of this employeer: ");
				Double salary = sc.nextDouble();
				sc.nextLine();
				System.out.print("Enter the time on company (dd/MM/yyyy): ");
				LocalDate dt = LocalDate.parse(sc.nextLine(), fmt1);
				UI.ShowListFunction();
				System.out.print("Type option: ");
				option = sc.nextLine();

				switch (option) {
				case "1":
					System.out.println("Create a password for this type (Just Numbers!!): ");
					System.out.print(">> ");
					Integer pass = sc.nextInt();
					sc.nextLine();
					seller = new Seller(nameOfEmployee, salary, EmployeerFunctions.SELLER, dt, pass);
                    registration.add(seller);
					adminServices.getEmpList().add(seller);
					break;

				case "2":
					// A ser implementado
					break;
				}
			} else if (option.equalsIgnoreCase("Admin")) {
				sc.nextLine();
				System.out.println("===========================");
				System.out.print("Enter complete name: ");
				String nameOfAdmin = sc.nextLine();
				System.out.print("Enter the salary of this admin: ");
				Double salary = sc.nextDouble();
				sc.nextLine();
				System.out.print("Enter the time on company (dd/MM/yyyy): ");
				LocalDate dt = LocalDate.parse(sc.nextLine(), fmt1);
				System.out.print("Enter with the secret key: ");
				Integer key = sc.nextInt();
				sc.nextLine();
				admin = new Admin(nameOfAdmin, salary, EmployeerFunctions.DEFAULT, dt, key);
				registration.add(admin);
			}
		}

		UI.setEmployeeList(registration);

		UI.LoginScreen();
		option = sc.nextLine();

		if (option.equalsIgnoreCase("Admin")) {
			System.out.print("Enter with the login name: ");
			String loginName = sc.nextLine();
			System.out.print("Enter with password: ");
			Integer passWord = sc.nextInt();
			sc.nextLine();
			login = new ConcreteLoginServices(registration);
			login.autenticationByPass(loginName, passWord);
		} else if (option.equalsIgnoreCase("Employeer")) {
			System.out.print("Enter with the login name: ");
			String loginName = sc.nextLine();
			System.out.print("Enter with password: ");
			Integer passWord = sc.nextInt();
			sc.nextLine();
			login = new ConcreteLoginServices(registration);
			login.autenticationByPass(loginName, passWord);
		}

		if (login.itsAutenticated()) {
			Employee loggedInEmployee = login.getLoggedInEmployee();
			if (loggedInEmployee instanceof Admin) {
				UI.LoginMenuOfAdmin();
				System.out.print(">> ");
				char opt = sc.next().charAt(0);
				if (opt == '1') {
					sc.nextLine();
					System.out.print("Enter the name of the employee: ");
					String employeeName = sc.nextLine();
					System.out.print("Enter the value of the increase: ");
					double increaseValue = sc.nextDouble();
					sc.nextLine();
					Double newSalary = adminServices.increaseSalaryBasedInTime(employeeName, seller, increaseValue);
					if (newSalary != null) {
						System.out.println("New salary: " + newSalary);
					} else {
						System.out.println("Employee not found or not eligible for salary increase.");
					}

				}
				if (opt == '2') {
					System.out.println("Enter te name of employeer you want search: ");
					System.out.print(">> ");
					String employeeName = sc.next();
					String findEmp = adminServices.findEmploee(employeeName);
					System.out.println(findEmp);
					sc.nextLine();
				}
				if (opt == '3') {
					sc.nextLine();
					System.out.println("Enter te name of employeer you want dismiss: ");
					System.out.print(">> ");
					String employeeName = sc.nextLine();

					Employee dissmiss = adminServices.dismissEmployee(employeeName);
					if(dissmiss != null) {
						System.out.println("Employeer fired!");
					} else {
						System.out.println("Employeer not found!");
					}
				} if (opt == '4') {
					System.out.println("Exiting!");
					System.exit(0);
				}

			} else if (loggedInEmployee instanceof Employee) {
				UI.LoginMenuOfEmployee();
				System.out.println(">> ");
				char opt = sc.next().charAt(0);
				
				if(opt == '1') {
					System.out.println("Enter the name of product: ");
					String prodName = sc.nextLine();
					System.out.println("Enter with the description of product: ");
					String prodDescription =  sc.nextLine();
					System.out.println("Enter with the price of product: ");
					Double price = sc.nextDouble();
					
				}
				
			}
		}
		sc.close();
	}
	
}
