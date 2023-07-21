package model.entites;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<Product> prod = new ArrayList<>();
	private LocalDateTime OrderTime;
	
	public Order(List<Product> prod, LocalDateTime orderTime) {
		this.prod = prod;
		this.OrderTime = orderTime;
	}
	

}
