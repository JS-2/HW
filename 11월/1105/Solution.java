import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	final static int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static char[][] map;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int Ti = 1; Ti <= T; Ti++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][];
			for(int r = 0; r < N; r++) {
				char[] chars = br.readLine().toCharArray();
				map[r] = chars;
			}
			int clickCnt = 0;
			boolean[][] visited = new boolean[N][N];
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(map[r][c] == '.' && bfs(r, c, visited)) ++clickCnt;
				}
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(map[r][c] == '.') ++clickCnt;
				}
			}
			sb.append("#").append(Ti).append(" ").append(clickCnt).append("\n");
		}
		System.out.print(sb.toString());
		
	}
	
	public static boolean bfs(int clickRow, int clickCol, boolean[][] visited) {
		boolean diffusion = false;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { clickRow, clickCol });
		visited[clickRow][clickCol] = true;
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int row = pos[0];
			int col = pos[1];
			int cnt = 0;
			Queue<int[]> nq = new LinkedList<>(); // 왜 큐썼지?
			for(int[] d: dir) {
				int newRow = row + d[0];
				int newCol = col + d[1];
				if(newRow < 0 || newRow >= N ||
				   newCol < 0 || newCol >= N ||
				   visited[newRow][newCol]) continue;
				if(map[newRow][newCol] == '*') {
					++cnt;
					continue;
				}
				if(cnt == 0) nq.add(new int[] { newRow, newCol });
			}
			if(cnt == 0) {
				diffusion = true;
				//모았던걸 큐에 넣는다.
				while(!nq.isEmpty()) {
					int[] newPos = nq.poll();
					q.add(newPos);
					visited[newPos[0]][newPos[1]] = true;
				}
				map[row][col] = '0';
			} else map[row][col] = (char)('0' + cnt);
		}
		if(!diffusion) {
			visited[clickRow][clickCol] = false;
			map[clickRow][clickCol] = '.';
			return false;
		}
		return true;
	}
}