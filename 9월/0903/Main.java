import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, distance[][], answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		answer = Integer.MAX_VALUE;
		// 입력
		N = Integer.parseInt(br.readLine());
		distance = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// bfs
		bfs(0, 1, 0, new boolean[N]);
		System.out.println(answer);
	}
	
	private static void bfs(int from, int cnt, int sum, boolean[] visited) {
		if(answer < sum) return;
		
		if(cnt == N) {
			if(distance[from][0] != 0)
				answer = Math.min(answer, sum + distance[from][0]);
			return;
		}
		
		for(int i = 1; i < N; i++) {
			if(visited[i] || distance[from][i] == 0) continue;
			visited[i] = true;
			bfs(i, cnt + 1, sum + distance[from][i], visited);
			visited[i] = false;
		}
	}
}