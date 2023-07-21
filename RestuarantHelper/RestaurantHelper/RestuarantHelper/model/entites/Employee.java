package model.entites;

import java.time.LocalDate;

import model.enums.EmployeerFunctions;

public abstract class Employee {

	private String name;
	private Double salary;
	private EmployeerFunctions function;
	protected Integer pass;
	private LocalDate timeInComapany;

	public Employee() {

	}

	public Employee(String name, Double salary, String function, LocalDate timeInComapany, Integer pass) {
		this.name = name;
		this.salary = salary;
		this.function = EmployeerFunctions.DEFAULT;
		this.timeInComapany = timeInComapany;
		this.pass = pass;
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

	public EmployeerFunctions getFunction() {
		return function;
	}

	public void setFunction(EmployeerFunctions function) {
		this.function = function;
	}

	public LocalDate getTimeInComapany() {
		return timeInComapany;
	}

	public Integer getPass() {
		return pass;
	}

	public void setPass(Integer pass) {
		this.pass = pass;
	}

	public void setTimeInComapany(LocalDate timeInComapany) {
		this.timeInComapany = timeInComapany;
	}

}
