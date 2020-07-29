package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] tensArr = new int[10];
		int number, tens;

		number = sc.nextInt();
		
		while(number != 0) {
			tens = number/10;
			tensArr[tens]++;
			number = sc.nextInt();
		} 
		
		for(int i = 0; i < 10; i++) {
			if(tensArr[i] != 0) {
				System.out.println(i + ": " + tensArr[i] + "개");
			}
		}
		sc.close();
	}
}
