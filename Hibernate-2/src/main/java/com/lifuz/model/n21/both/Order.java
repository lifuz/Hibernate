package com.lifuz.model.n21.both;

public class Order {

	private Integer OrderId;
	private String OrderName;
	private Customer customer;

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", OrderName=" + OrderName + ", customer=" + customer + "]";
	}

}
