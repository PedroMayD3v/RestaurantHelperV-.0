package model.services;

import java.util.List;

import application.UI;
import model.entites.Admin;
import model.entites.Employee;
import model.entites.Seller;

public class ConcreteLoginServices implements LoginServices {

	private List<Employee> register;
	private boolean success = false;
	private boolean isAdmin = false;
	 private Employee loggedInEmployee;

	public ConcreteLoginServices(List<Employee> register) {
		this.register = register;
	}

	public List<Employee> getRegister() {
		return register;
	}

	public void setRegister(List<Employee> register) {
		this.register = register;
	}

	@Override
	public boolean itsAutenticated() {
		return success;
	}

	@Override
	public void autenticationByPass(String name, Integer password) {
		for (Employee employee : register) {
			if (employee instanceof Employee && password.equals(employee.getPass())) {
				System.out.println();
				System.out.println("Login successful!");
				success = true;
				loggedInEmployee = employee; 
				return;
			}
		}

		for (Employee employee : register) {
			if (employee instanceof Admin && password.equals(employee.getPass())) {
				System.out.println();
				System.out.println("Login as admin");
				success = true;
				isAdmin = true;
				loggedInEmployee = employee; 
				return;
			}
		}

		System.out.println("Login not found!");
	}

	@Override
	public boolean isAdmin() {
		return isAdmin;
	}

	@Override
	public Employee getLoggedInEmployee() {
		return loggedInEmployee;
	}
}
