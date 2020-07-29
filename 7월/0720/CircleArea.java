package com.java.first;

public class CircleArea {
	
	static void printCircleArea(int radius) {
		double circleArea = radius * radius * Math.PI;
		System.out.printf("반지름이 %dcm인 원의 넓이는 %.1fcm^2입니다.", radius, circleArea);
	}
	
	public static void main(String[] args) {
		printCircleArea(5);
	}
}
