package com.lifuz.model.n21;

public class Customer {

	private Integer customerId;
	private String CustomerName;

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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", CustomerName=" + CustomerName + "]";
	}

}
