package com.ssafy.algo;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProductMgr productList = new ProductMgr();
		int num;
		
		while(true) {
			System.out.println("1.상품 추가 2.상품 리스트 3.상품 번호로 검색 4.상품 번호로 삭제 5.특정 가격 이하의 상품 리스트");
			num = sc.nextInt();

			switch(num) {
			case 1:
				System.out.print("상품 번호:");
				int number = sc.nextInt();
				System.out.print("상품 이름:");
				String name = sc.next();
				System.out.print("가격:");
				int price = sc.nextInt();
				System.out.print("수량:");
				int quantity = sc.nextInt();
				productList.add(new Product(number, name, price, quantity));
				break;
			case 2:
				productList.list();
				break;
			case 3:
				System.out.print("상품 번호:");
				productList.list(sc.nextInt());
				break;
			case 4:
				System.out.print("상품 번호:");
				productList.delete(sc.nextInt());
				break;
			case 5:
				System.out.print("상품 가격:");
				productList.priceList(sc.nextInt());
				break;
			default:
				System.out.println("다시 입력하세요.");
			}
		}
	}

}
