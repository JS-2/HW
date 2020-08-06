
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
{
	static int[][] food;
	static int min = Integer.MAX_VALUE;
	static int N;
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		food = new int[N][];
		int S, B;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			food[i] = new int[] { S, B };
		}		
		
		bfs(1, 0, 0);
		System.out.println(min);
	}
	
	private static void bfs(int S, int B, int foodNum) {
		if(foodNum == N) {
			if(S != 1 && B != 0) {
				min = min > Math.abs(S - B) ? Math.abs(S - B) : min;
			}
			return;
		}
		
		bfs(S * food[foodNum][0], B + food[foodNum][1], foodNum + 1);
		bfs(S, B, foodNum + 1);
	}
}
