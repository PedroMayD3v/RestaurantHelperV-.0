package model.services;

import model.entites.Order;

public interface PaymentServices {

	public Double taxService(Double value);
	public void processPayment(Order order);
}
