
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static int N, M;
	static int[] weights;
	static int answer;
	
	public static void solution(int cnt, int sum, int hold) {
		if(hold == 2) {
			answer = (sum > answer && sum <= M) ? sum : answer;
			return;
		} else if(cnt == N) return;
		
		solution(cnt + 1, sum + weights[cnt], hold + 1);
		solution(cnt + 1, sum, hold);
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int Ti = 1; Ti <= TC; Ti++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			weights  = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				weights[i] = Integer.parseInt(st.nextToken());
			
			answer = -1;
			solution(0, 0, 0);
			
			System.out.println("#" + Ti + " " + answer);
		}
	}
}