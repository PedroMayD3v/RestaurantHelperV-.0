package model.services;

import model.entites.Employee;

public interface LoginServices {
	
	 public void autenticationByPass(String name, Integer password);
	 public boolean itsAutenticated();
	 public boolean isAdmin();
	 public Employee getLoggedInEmployee();

}
