package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean[][] map;
	static int[][] d = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars;
		int N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			chars = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				map[i][j] = chars[j] == '1' ? true : false;
			}
		}
		
		System.out.println(z(N, 0, 0));
		
	}
	
	private static String z(int N, int r, int c) {
		if(N == 1) {
			if(map[r][c])
				return "1";
			else
				return "0";
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int[] p: d) {
			sb.append(z(N / 2, r + N / 2 * p[0], c + N / 2 * p[1]));
		}
		String result = sb.toString();
		
		if(result.equals("1111")) return "1";
		else if(result.equals("0000")) return "0";
		else return new StringBuilder().append("(").append(result).append(")").toString();
	}
}
