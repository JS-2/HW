import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int sum = 0;
	static int answer = Integer.MAX_VALUE;
	static int[][] status;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		status = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				status[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] arr = new int[N / 2];
		dfs(arr, new int[N / 2], 1, 0, 1);
		System.out.println(answer);
	}
	
	private static void dfs(int[] arr1, int[] arr2, int cnt1, int cnt2, int num) {
		if(cnt1 == N / 2 && cnt2 == N / 2) {
			int sum1 = 0, sum2 = 0;
			
			for(int i = 0; i < N / 2; i++)
				for(int j = 0; j < N / 2; j++) 
					sum1 += status[arr1[i]][arr1[j]];
			
			for(int i = 0; i < N / 2; i++)
				for(int j = 0; j < N / 2; j++) 
					sum2 += status[arr2[i]][arr2[j]];
			
			int diff = Math.abs(sum1 - sum2);
			answer = Math.min(answer, diff);
			return;
		}
		
		if(cnt1 != N / 2) {
			arr1[cnt1] = num;
			dfs(arr1, arr2, cnt1 + 1, cnt2, num + 1);
		}
		if(cnt2 != N / 2) {
			arr2[cnt2] = num;
			dfs(arr1, arr2, cnt1, cnt2 + 1, num + 1);
		}
	}
}
