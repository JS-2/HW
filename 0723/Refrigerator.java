package com.ssafy;

public class Refrigerator extends Product {
	private String volume;
	
	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	Refrigerator(int number, String name, int price, int quantity, String volume) {
		super(number, name, price, quantity);
		this.volume = volume;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n용       량: " + volume;
	}
}
