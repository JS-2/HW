import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();	
		
		int T = Integer.parseInt(br.readLine());
		
		for(int Ti = 1; Ti <= T; Ti++) {
			st = new StringTokenizer(br.readLine());
			int oneDay = Integer.parseInt(st.nextToken());
			int oneMonth = Integer.parseInt(st.nextToken());
			int threeMonth = Integer.parseInt(st.nextToken());
			int oneYear = Integer.parseInt(st.nextToken());
			
			int[] schedules = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= 12; i++) 
				schedules[i] = Integer.parseInt(st.nextToken());
			
			int[] dp = new int[13];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			
			for(int i = 1; i <= 12; i++) {
				dp[i] = Math.min(dp[i - 1] + oneMonth, dp[i]);
				dp[i] = Math.min(schedules[i] * oneDay + dp[i - 1], dp[i]);
				if(i >= 3) dp[i] = Math.min(dp[i - 3] + threeMonth, dp[i]);
			}
			sb.append("#").append(Ti).append(" ").append(Math.min(oneYear, dp[12])).append("\n");
		}
		System.out.println(sb.toString());
	}
}