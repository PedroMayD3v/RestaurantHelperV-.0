package model.services;

import java.util.ArrayList;
import java.util.List;
import model.entites.Employee;

public class ConcreteRegistrationServices implements RegistrationServices {

	private List<Employee> registration;
	private Employee emp;

	public ConcreteRegistrationServices(List<Employee> registration) {
		this.registration = registration;
	}

	@Override
	public void addRegistration(Employee emp) {
		registration.add(emp);

	}

	@Override
	public String getInfo(String name) {
		for (Employee emp : registration) {
			if (name.equalsIgnoreCase(emp.getName())) {
				String employeeName = emp.getName();
				double salary = emp.getSalary();
				return "Employee Name: " + employeeName + "\n" + "Employee Salary: " + salary;
			}
		}
		throw new IllegalArgumentException("Employee not registered!");
	}

	@Override
	public void removeRegistration(Employee emp) {
	   registration.remove(emp);
	}

	public List<Employee> getRegistration() {
		return registration;
	}

	public void setRegistration(List<Employee> registration) {
		this.registration = registration;
	}


	
}
