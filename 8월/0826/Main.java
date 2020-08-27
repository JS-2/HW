package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int[][] A;
	static int[][] AClone;
	static int[][] turns;
	static int K, N, M;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		turns = new int[K][];
		
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < M; col++) {
				A[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		//회전연산 저장
		for(int Ki = 0; Ki < K; Ki++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			turns[Ki] = new int[] { r, c, s };
		}
		
		//경우의 수로 turn 사용 3P3
		permutation(new int[K], new boolean[K], 0);
		
		System.out.println(answer);
	}
	
	private static int findMin() {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int lowSum = 0;
			for(int j = 0; j < M; j++) 
				lowSum += AClone[i][j];
			min = lowSum < min ? lowSum : min;
		}
		return min;
	}
	
	private static void turn(int r, int c, int s) {
		if(s == 0) return;
		
		LinkedList<Integer> l = new LinkedList<>();
		int left = c - s - 1;
		int top = r - s - 1;
		int right = c + s - 1;
		int bottom = r + s - 1;
		int nowRow = top;
		int nowCol = left;
		
		while(nowCol < right) l.offer(AClone[nowRow][nowCol++]);
		while(nowRow < bottom) l.offer(AClone[nowRow++][nowCol]);
		while(nowCol > left) l.offer(AClone[nowRow][nowCol--]);
		while(nowRow > top) l.offer(AClone[nowRow--][nowCol]);
		
		l.addFirst(l.getLast());
		l.peek();
		
		while(nowCol < right) AClone[nowRow][nowCol++] = l.poll();
		while(nowRow < bottom) AClone[nowRow++][nowCol] = l.poll();
		while(nowCol > left) AClone[nowRow][nowCol--] = l.poll();
		while(nowRow > top) AClone[nowRow--][nowCol] = l.poll();
		
		turn(r, c, s - 1);
	}
	
	private static void permutation(int[] arr, boolean[] visit, int cnt) {
		if (cnt == K) {
			AClone = new int[N][];
			for(int i = 0; i < N; i++) 
				AClone[i] = A[i].clone(); //2차원 배열 복제
			for(int n: arr) {
				turn(turns[n][0], turns[n][1], turns[n][2]);
			}
			int min = findMin();
			answer = min < answer ? min : answer;
			return;
		}
		for(int i = 0; i < K; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				arr[cnt] = i;
				permutation(arr, visit, cnt + 1);
				visit[i] = false;
			}
		}
	}
}
