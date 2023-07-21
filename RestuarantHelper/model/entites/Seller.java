package model.entites;

import java.time.LocalDate;

import model.enums.EmployeerFunctions;

public class Seller extends Employee {
	
	private String name;
	private Double salary;
	private EmployeerFunctions functions;
	
	
	public Seller(String name0, Double salary0, EmployeerFunctions pizzaMaker, LocalDate timeInComapany, Integer pass) {
		super(name0, salary0, pizzaMaker, timeInComapany, pass);
		this.name = name0;
		this.salary = salary0;
	}

	public Seller() {
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
	public EmployeerFunctions getFunctions() {
		return functions;
	}

	public void setFunctions(EmployeerFunctions functions) {
		this.functions = functions;
	}
	
	

	
	
	
	

	
	
}
