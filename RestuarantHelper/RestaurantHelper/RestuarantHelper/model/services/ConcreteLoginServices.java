package model.services;

import java.util.List;

import model.entites.Employee;

public class ConcreteLoginServices implements LoginServices {

	private List<Employee> register;
	private ConcreteRegistrationServices servicesRegister;
	private boolean success = false;

	public ConcreteLoginServices(List<Employee> register) {
		this.register = register;
	}

	@Override
	public void autenticationByPass(String name, Integer password) {
	    for (Employee employee : register) {
	    	if (password.equals(employee.getPass())) {
	            System.out.println("Login successful!");
	            success = true;
	            return; // Retorna após o login ser bem-sucedido
	        }
	    }
	    System.out.println("User not found or incorrect password");
	}


	public List<Employee> getRegister() {
		return register;
	}

	public void setRegister(List<Employee> register) {
		this.register = register;
	}

	@Override
	public boolean itsAutenticated() {
       if(success = false) {
			return false;
		}
	   return success;
	}
}
