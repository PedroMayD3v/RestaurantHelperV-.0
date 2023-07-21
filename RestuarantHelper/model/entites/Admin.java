package model.entites;

import java.time.LocalDate;

import model.enums.EmployeerFunctions;
import model.services.ConcreteLoginServices;

public class Admin extends Employee {

	private int secretPass;
	private String name;
	private Double salary;

	public Admin(String name, Double salary, EmployeerFunctions function, LocalDate timeInComapany, Integer pass) {
		super(name, salary, function, timeInComapany, pass);
		this.secretPass = 3582;
		this.name = name;
		this.salary = salary;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public int getSecretPass() {
		return secretPass;
	}

}
