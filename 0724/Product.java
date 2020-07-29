package com.ssafy.algo;

public class Product {
	private int number;
	private String name;
	private int price;
	
	private int quantity;
	
	public Product(int number, String name, int price, int quantity) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
