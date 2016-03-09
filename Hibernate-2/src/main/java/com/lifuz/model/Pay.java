package com.lifuz.model;

public class Pay {

	private int monthPay;
	private int yearPay;
	private int vocationWithPay;

	public int getMonthPay() {
		return monthPay;
	}

	public void setMonthPay(int monthPay) {
		this.monthPay = monthPay;
	}

	public int getYearPay() {
		return yearPay;
	}

	public void setYearPay(int yearPay) {
		this.yearPay = yearPay;
	}

	public int getVocationWithPay() {
		return vocationWithPay;
	}

	public void setVocationWithPay(int vocationWithPay) {
		this.vocationWithPay = vocationWithPay;
	}

	@Override
	public String toString() {
		return "Pay [monthPay=" + monthPay + ", yearPay=" + yearPay + ", vocationWithPay=" + vocationWithPay + "]";
	}

}
