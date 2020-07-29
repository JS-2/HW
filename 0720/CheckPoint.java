package com.java.first;

import java.util.Scanner;

public class CheckPoint {
	
	static void calculateBmi(int height, int weight) {
		int bmi = weight + 100 - height;
		System.out.printf("비만수치는 %d입니다.\n",bmi);
		if(bmi > 0)
			System.out.println("당신은 비만이군요.");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int height = input.nextInt();
		int weight = input.nextInt();
		
		calculateBmi(height, weight);
		input.close();
	}
}
