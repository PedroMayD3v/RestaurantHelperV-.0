package model.services;

import java.util.List;

import model.entites.Employee;

public interface AdminServices {
	
	public Double increaseSalaryBasedInTime(String name, Employee emp, Double value);
	public String findEmploee(String name);
	public Employee dismissEmployee(String name);
	
	

}
