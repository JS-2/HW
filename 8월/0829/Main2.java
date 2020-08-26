
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	
	static class User {
		int r;
		int c;
		int cnt;
		boolean skill;
		
		User(int r, int c, boolean skill, int cnt) {
			this.r = r;
			this.c = c;
			this.skill = skill;
			this.cnt = cnt;
		}
	}
	
	final static int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] map;
	static int[][] visit;
	static int  N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<User> q = new LinkedList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		visit = new int[N][M];
		char[] chars;
		
		for(int i = 0; i < N; i++) {
			chars = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) 
				map[i][j] = chars[j] == '1' ? true : false;
		}
		
		q.offer(new User(0, 0, true, 1));
		
		//bfs
		while(!q.isEmpty()) {
			User u = q.poll();
			int row = u.r;
			int col = u.c;
			int cnt = u.cnt;
			boolean skill = u.skill;
			
			if(row == N - 1 && col == M - 1) {
				System.out.println(cnt);
				return;
			}
			
			if(visit[row][col] == 0)
				visit[row][col] = skill ? 2 : 1;
			else if (visit[row][col] == 1 && skill)
				visit[row][col] = 2;
			else
				continue;
			
			for(int[] d: direction) {
				int newRow = row + d[0];
				int newCol = col + d[1];
				if(newRow >= 0 && newRow < N
				&& newCol >= 0 && newCol < M) {
					if(!map[newRow][newCol]) { // 돌이 없을때
						q.offer(new User(newRow, newCol, skill, cnt + 1));
					} 
					else if(skill) { // 돌이 있고 스킬이 있을 때
						q.offer(new User(newRow, newCol, false, cnt + 1));
					}
				}
			}
		}
		
		System.out.println(-1);
	}		
}

