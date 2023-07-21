package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entites.Admin;
import model.entites.Employee;
import model.entites.PizzaMaker;
import model.services.ConcreteLoginServices;
import model.services.ConcreteRegistrationServices;
import model.services.LoginServices;
import model.services.RegistrationServices;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List<Employee> registration = new ArrayList<>();
		RegistrationServices register;
		LoginServices login;

		UI.WelcomeMessage();
		UI.ShowOptions();
		String option = sc.nextLine(); // Alterado para sc.nextLine()

		if (option.equalsIgnoreCase("Employeer")) {

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
				register = new ConcreteRegistrationServices(registration);
				System.out.println("Create a password for this type (Just Numbers!!): ");
				System.out.print(">> ");
				Integer pass = sc.nextInt();
				sc.nextLine();
				Employee employeer = new PizzaMaker(nameOfEmployee, salary, option, dt, pass);
				register.addRegistration(employeer);
				registration.add(employeer);

				System.out.print("Enter the name to search: ");
				String searchName = sc.nextLine();
				String getInfo = register.getInfo(searchName);
				System.out.println("Infos:");
				System.out.println(getInfo);
				System.out.println("===========================");

			case "2":
				// A ser implementado

			}

		} else if (option.equalsIgnoreCase("Admin")) {
			System.out.println("===========================");
			System.out.print("Enter complete name: ");
			String nameOfEmployee = sc.nextLine();
			System.out.print("Enter the salary of this employeer: ");
			Double salary = sc.nextDouble();
			sc.nextLine();
			System.out.print("Enter the time on company (dd/MM/yyyy): ");
			LocalDate dt = LocalDate.parse(sc.nextLine(), fmt1);
			System.out.print("Enter with the secret key: ");
			Integer key = sc.nextInt();
			Employee admin = new Admin(nameOfEmployee, salary, option, dt, key);
			registration.add(admin);

		} else {
			System.out.println("Type not found!");
		}

		UI.LoginScreen();
		option = sc.next();

		if (option.equalsIgnoreCase("Admin")) {
			System.out.print("Enter with the login name: ");
			String loginName = sc.nextLine();
			sc.nextLine();
			System.out.print("Enter with password: ");
			Integer passWord = sc.nextInt();
			login = new ConcreteLoginServices(registration);
			login.autenticationByPass(loginName, passWord);

		} else if (option.equalsIgnoreCase("Employeer")) {
			System.out.print("Enter with the login name: ");
			String loginName = sc.nextLine();
			sc.nextLine();
			System.out.print("Enter with password: ");
			Integer passWord = sc.nextInt();
			login = new ConcreteLoginServices(registration);
			login.autenticationByPass(loginName, passWord);
		}

	}

}
