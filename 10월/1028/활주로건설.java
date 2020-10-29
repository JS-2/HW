import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, answer;
	static int[][] map;
	static int[][][] distances;
	static ArrayList<int[]> stores;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int Ti = 1; Ti <= T; Ti++) {
			answer = Integer.MAX_VALUE;
			stores = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] > 1) stores.add(new int[] { r, c });
				}
			}
			
			distances = new int[N][N][stores.size()];
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(map[r][c] != 1) continue;
					for(int i = 0; i < stores.size(); i++) {
						distances[r][c][i] = Math.abs(r - stores.get(i)[0]) + Math.abs(c - stores.get(i)[1]);
					}
				}
			}
			int[] storesNum = new int[stores.size()];
			for(int i = 0; i < stores.size(); i++) storesNum[i] = i;
			for(int num: storesNum) combination(0, num + 1, storesNum, new int[num + 1], 0, new boolean[10]);
			sb.append("#").append(Ti).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void combination(int start, int choice, int[] stores, int arr[], int cnt, boolean[] visited) {
		if(cnt == choice) {
			solution(arr);
			return;
		}
		for(int i = start; i < stores.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[cnt] = stores[i];
			combination(i, choice, stores, arr, cnt + 1, visited);
			visited[i] = false;
		}
	}
	
	public static void solution(int[] arr) {
		int distanceSum = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				int minDistance = Integer.MAX_VALUE;
				for(int e: arr) {
					minDistance = Math.min(minDistance, distances[r][c][e]);
				}
				distanceSum += minDistance;
			}
		}
		for(int e: arr) distanceSum += map[stores.get(e)[0]][stores.get(e)[1]];
		answer = Math.min(answer, distanceSum);
	}
}
