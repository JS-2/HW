package com.java.first;

import java.util.Scanner;

public class Compute {
	
	static void calculate(int firstNum, int secondNum) {
		System.out.printf("곱 = %d\n", firstNum * secondNum);
		System.out.printf("몫 = %d\n", firstNum / secondNum);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int firstNum = input.nextInt();
		int secondNum = input.nextInt();
		
		calculate(firstNum, secondNum);
		input.close();
	}
}
