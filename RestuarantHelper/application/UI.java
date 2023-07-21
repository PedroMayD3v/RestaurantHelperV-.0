package application;

import java.time.Instant;
import java.util.List;

import model.entites.Admin;
import model.entites.Employee;
import model.enums.EmployeerFunctions;

public class UI {
	private static Instant date = Instant.now();
	private static EmployeerFunctions fc;
	private static Employee employeer;
	private static List<Employee> employeeList;

	public static void WelcomeMessage() {
		System.out.println("Bem vindo ao sistema de gerenciamento de vendas e funcionarios!");
		System.out.println("=====================================================");
		System.out.println("Esse sistema foi feito para ajudar a gerenciar o seu estabelecimento");
		System.out.println("De modo a automatizar todas as funções que você precisa!");
		System.out.println("=====================================================");
		System.out.println("Criado por: Pedro Pontes!");
		System.out.println();
		System.out.println("Date: " + date);
		System.out.println("=====================================================");
		System.out.println();
	}

	public static void LoginMenuOfAdmin() {
			System.out.println();
			System.out.println("=====================");
			System.out.println("Welcome to the options menu, Admin!");
			System.out.println("Nice to see you here");
			System.out.println("=====================");
			System.out.println("Select one option:");
			System.out.println("1. Increasy salary of a employeer based in time");
			System.out.println("2. Search employee");
			System.out.println("3. Dissmiss employee");
			System.out.println("4. Exit");
		
	}
	public static void LoginMenuOfEmployee() {
		System.out.println();
		System.out.println("=====================");
		System.out.println("Welcome to the options menu!");
		System.out.println("Nice to see you here");
		System.out.println("=====================");
		System.out.println("Select one option:");
		System.out.println("1. Sell a new product");
		System.out.println("2. See if can incraeasy your salary");
		System.out.println("3. Exit");
	}

	public static void setEmployeeList(List<Employee> employeeList) {
		UI.employeeList = employeeList;
	}

	public static void ShowListFunction() {
		System.out.println("Select the function of this employeer:");
		System.out.println("1 - " + fc.SELLER);
		System.out.println("2 - " + fc.DEFAULT);
	}

	public static void ShowOptions() {
		System.out.println("You want register a new (Employeer or Admin)?: ");
		System.out.print("Type option: ");
	}

	public static void LoginScreen() {
		System.out.println("=========================");
		System.out.println("Let's begin, do you want to login as (Admin or Employee): ");
		System.out.println("=========================");
		System.out.print("Type option: ");
	}

	public static EmployeerFunctions getFc() {
		return fc;
	}

	public static void setFc(EmployeerFunctions fc) {
		UI.fc = fc;
	}
}
