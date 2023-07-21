package application;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Scanner;

import model.enums.EmployeerFunctions;

public class UI {

	private static Instant date = Instant.now();
	private static EmployeerFunctions fc;

	public static void WelcomeMessage() {
		System.out.println("Bem vindo ao sistema de gerenciamento de restaurante!");
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("Esse sistema foi feito para ajudar a gerenciar o seu restaurante");
		System.out.println("De modo a automatizar todas as funções que você precisa! ");
		System.out.println();
		System.out.println("=====================================================");
		System.out.println("Criado por: Pedro Pontes!");
		System.out.println();
		System.out.println("Date: " + date);
		System.out.println("=====================================================");
		System.out.println();

	}

	public static void BuildEmployee(Scanner sc, String str) {

	}

	public static void ShowListFunction() {
		System.out.println("Select the function of this employeer:");
		System.out.println("1 -" + fc.PIZZA_MAKER);
		System.out.println("2 - " + fc.DEFAULT);
	}

	public static void ShowOptions() {
		System.out.println("You want register a new (Employeer or Admin)?: ");
		System.out.print("Type option: ");
	}

	public static void LoginScreen() {
		System.out.println("=========================");
		System.out.println("Lets begin, you want login as (Admin or Employee): ");
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
