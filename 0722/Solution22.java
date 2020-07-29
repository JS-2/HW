package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {
	
	public static void main(String[] args) {
		// 0: 상, 1: 하, 2: 좌, 3: 우
		final int[][] directValue = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] N = new int[T];
		int[] numberOfStriders = new int[T];
		int[][] striderRow = new int[T][];
		int[][] striderCol = new int[T][];
		int[][] striderDirection = new int[T][];
		
		//Set strider
		for(int Ti = 0; Ti < T; Ti++) {
			N[Ti] = sc.nextInt();
			numberOfStriders[Ti] = sc.nextInt();
			striderRow[Ti] = new int[numberOfStriders[Ti]];
			striderCol[Ti] = new int[numberOfStriders[Ti]];
			striderDirection[Ti] = new int[numberOfStriders[Ti]];
			
			for(int i = 0; i < numberOfStriders[Ti]; i++) {
				striderRow[Ti][i] = sc.nextInt();
				striderCol[Ti][i] = sc.nextInt();
				striderDirection[Ti][i] = sc.nextInt() - 1;
				
				// 겹치는 소금쟁이 체크
				for(int j = 0; j < i; j++) {
					if(striderCol[Ti][j] == striderCol[Ti][i] && striderRow[Ti][j] == striderRow[Ti][i]) {
						--numberOfStriders[Ti];
						--i;
						break;
					}
				}
			}
		}
		sc.close(); //입력종료
		
		for(int Ti = 0; Ti < T; Ti++) {
			int[] row = striderRow[Ti];
			int[] col = striderCol[Ti];
			int[] direction = striderDirection[Ti];
			int livingStriders = numberOfStriders[Ti];
			
			for(int striderIdx = 0; striderIdx < numberOfStriders[Ti]; striderIdx++) {
				if((row[striderIdx] + 6 * directValue[direction[striderIdx]][0] >= N[Ti])
						|| (row[striderIdx] + 6 * directValue[direction[striderIdx]][0] < 0)
						|| (col[striderIdx] + 6 * directValue[direction[striderIdx]][1] >= N[Ti])
						|| (col[striderIdx] + 6 * directValue[direction[striderIdx]][1] < 0)) { 
					//1. 밖으로 나가는 소금쟁이
					--livingStriders;
					row[striderIdx] = -1;
					col[striderIdx] = -1;
				} else {
					//2. 부딪히는 소금쟁이
					loop:
					for(int jumpDistance = 3; jumpDistance > 0; jumpDistance--) {
						row[striderIdx] += jumpDistance * directValue[direction[striderIdx]][0];
						col[striderIdx] += jumpDistance * directValue[direction[striderIdx]][1];
						//세 번째 뛴 소금쟁이 체크
						for(int checkThirdIdx = 0; checkThirdIdx < striderIdx; checkThirdIdx++) {
							if (row[striderIdx] == row[checkThirdIdx]
									&& col[striderIdx] == col[checkThirdIdx]) {
								--livingStriders;
								row[striderIdx] = -1;
								col[striderIdx] = -1;
								break loop;
							}
						}
					}
				}
			}
			
			System.out.println("#" + (Ti + 1) + " " + livingStriders);
		}
	}

}
