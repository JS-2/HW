package com.ssafy;

public class ProductTest {
	
	

	public static void main(String[] args) {
		TV firstProduct = new TV(543362, "KU75UT8070F", 1871480, 3, 75, "QLED");
		Refrigerator secondProduct = new Refrigerator(234562,"RF85T9111T2", 1660280, 1, "174L"); 
		
		System.out.println(firstProduct);
		firstProduct.setNumber(1);
		firstProduct.setName("one");
		firstProduct.setPrice(1);
		firstProduct.setQuantity(1);
		firstProduct.setSize(1);
		firstProduct.setDisplayType("one");
		System.out.println(firstProduct.getNumber());
		System.out.println(firstProduct.getName());
		System.out.println(firstProduct.getPrice());
		System.out.println(firstProduct.getQuantity());
		System.out.println(firstProduct.getSize());
		System.out.println(firstProduct.getDisplayType());
		
		System.out.println(secondProduct);
		secondProduct.setNumber(2);
		secondProduct.setName("two");
		secondProduct.setPrice(2);
		secondProduct.setQuantity(2);
		secondProduct.setVolume("2L");
		System.out.println(secondProduct.getNumber());
		System.out.println(secondProduct.getName());
		System.out.println(secondProduct.getPrice());
		System.out.println(secondProduct.getQuantity());
		System.out.println(secondProduct.getVolume());
	}

}
