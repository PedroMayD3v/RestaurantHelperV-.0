package model.services;

import java.time.LocalDate;

public class ConcreteAdminServices implements AdminServices {

	LocalDate dt;
	boolean success = false;
	
	public ConcreteAdminServices() {
		
	}
	
	public double increaseSalaryBasedInTime(LocalDate time, boolean success) {
		return 0;
		
	}

}
