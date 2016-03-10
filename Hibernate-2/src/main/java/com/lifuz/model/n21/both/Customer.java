package com.lifuz.model.n21.both;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private Integer customerId;
	private String CustomerName;

	private Set<Order> orders = new HashSet<>();;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}


}
