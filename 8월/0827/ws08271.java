package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ws08271 {
	
	static char[][] map;
	static boolean[][] visit;
	static int R, C;
	final static int[][] direction = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		//입력
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int answer = 0;
		for(int row = 0; row < R; row++) {
			answer += dfs(row, 0) ? 1 : 0;
		}
		System.out.println(answer);
	}
	
	private static boolean dfs(int row, int col) {
		visit[row][col] = true;
		
		if(col == C - 1)
			return true;
		
		for(int[] d: direction) {
			int newRow = row + d[0];
			int newCol = col + d[1];
			
			if(newRow >= 0 && newRow < R && newCol >= 0 && newCol < C &&
			   map[newRow][newCol] == '.' && !visit[newRow][newCol]) {
				if(dfs(newRow, newCol))
					return true;
			}
		}
		return false;
	}
}
