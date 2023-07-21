package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entites.Employee;

public class ConcreteAdminServices implements AdminServices {

	private List<Employee> empList = new ArrayList<>();
	private boolean success = false;
	
	public ConcreteAdminServices() {
	}

	@Override
	public Double increaseSalaryBasedInTime(String name, Employee emp, Double value) {
	    Double bonus = value;
	    Double newSalary;
	    if (emp.getTimeInComapany().getYear() < 2010 && name.equals(emp.getName())) {
	        newSalary = emp.getSalary() + bonus;
	        emp.setSalary(newSalary);
	        return emp.getSalary();
	    } else {
	        return 0.0;
	    }
	}

	@Override
    public String findEmploee(String name) {
        for (Employee emp : empList) {
            if (name.equals(emp.getName())) {
                return "Employee found: " 
                       + emp.getName()
                       +"\n"
                       +"Salary: " + emp.getSalary();
            }
        }
        return "Employee not found:";
    }

	@Override
	public Employee dismissEmployee(String name) {
	    Employee employeeToDismiss = null;
	    for (int i = 0; i < empList.size(); i++) {
	        Employee emp = empList.get(i);
	        if (name.equalsIgnoreCase(emp.getName())) {
	            employeeToDismiss = emp;
	            empList.remove(i);
	            break; // Se encontrou o funcionário, não precisa continuar o loop
	        }
	    }
	    return employeeToDismiss;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}