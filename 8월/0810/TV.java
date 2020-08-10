package com.ssafy;

public class TV extends Product {
	private int size;
	private String displayType;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	
	TV(int number, String name, int price, int quantity, int size, String displayType) {
		super(number, name, price, quantity);
		this.size = size;
		this.displayType = displayType;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n인       치: " + size + "\n디스플레이 타입: " + displayType;
	}
}
