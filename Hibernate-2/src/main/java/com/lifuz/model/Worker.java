package com.lifuz.model;

public class Worker {

	private int id;
	private String name;
	private Pay pay;

	public Worker() {
		super();
	}

	public Worker(String name, Pay pay) {
		super();
		this.name = name;
		this.pay = pay;
	}

	public Worker(int id, String name, Pay pay) {
		super();
		this.id = id;
		this.name = name;
		this.pay = pay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + ", pay=" + pay + "]";
	}

}
