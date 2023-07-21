package model.services;

import model.entites.Employee;

public interface RegistrationServices {
	
	public void removeRegistration(Employee emp);
	public void addRegistration(Employee emp);
	public String getInfo(String name);
	

}
