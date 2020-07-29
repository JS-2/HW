package com.ssafy.algo;

public class ProductMgr {
	Product[] product;
	
	ProductMgr() {
		product = new Product[10];
	}
	
	public void add(Product p) {
		for(int i = 0; i < 10; i++) {
			if(product[i] == null) {
				product[i] = p;
				return;
			}
		}
	}
	
	public void list() {
		for(int i = 0; i < 10; i++) {
			if(product[i] != null)
				System.out.println(product[i]);
		}
	}
	
	public void list(int num) {
		for(int i = 0; i < 10; i++) {
			if(product[i] != null && product[i].getNumber() == num) {
				System.out.println(product[i]);
			}
		}
	}
	
	public void delete(int num) {
		for(int i = 0; i < 10; i++) {
			if(product[i] != null && product[i].getNumber() == num) {
				product[i] = null;
			}
		}
	}
	
	public void priceList(int price) {
		for(int i = 0; i < 10; i++) {
			if(product[i] != null && product[i].getPrice() <= price) {
				System.out.println(product[i]);
			}
		}
	}
}
