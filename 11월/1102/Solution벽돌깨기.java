import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	final static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, C, R, answer;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int Ti = 1; Ti <= T; Ti++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[R][C];
			
			for(int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			answer = Integer.MAX_VALUE;
			dfs(0, map);
			sb.append("#").append(Ti).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void showMap(int[][] map) {
		for(int i = 0; i < R; i++) {
			System.out.println();
			for(int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
		}
		System.out.println();
	}
	
	public static int countBlock(int[][] map) {
		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0) ++sum;
			}
		}
		return sum;
	}
	
	public static void dfs(int cnt, int[][] map) {
		if(N == cnt || countBlock(map) == 0) {
			answer = Math.min(answer, countBlock(map));
			return;
		}
		for(int c = 0; c < C; c++) {
			// c: 벽돌 발사 위치
			int[][] cloneMap = mapCopy(map);
			for(int r = 0; r < R; r++) {
				if(map[r][c] > 0) {
					// 부수고 
					breakBlock(r, c, cloneMap);
					// 중력작용하고
					gravity(cloneMap);
					// 다음 dfs
					dfs(cnt + 1, cloneMap);
					break;
				}
			}
		}
	}
	
	public static void breakBlock(int r, int c, int[][] map) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, map[r][c] });
		map[r][c] = 0;
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int row = pos[0];
			int col = pos[1];
			int area = pos[2];
			for(int i = 1; i < area; i++) {
				for(int[] d: dir) {
					int newRow = row + d[0] * i;
					int newCol = col + d[1] * i;
					if(newRow < 0 || newRow >= R || 
					   newCol < 0 || newCol >= C ||
					   map[newRow][newCol] == 0) continue;
					q.add(new int[] { newRow, newCol, map[newRow][newCol] });
					map[newRow][newCol] = 0;
				}
			}
		}
	}
	
	public static void gravity(int[][] map) {
		for(int r = R - 1; r >= 0; r--) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] > 0) {
					int nextRow = r + 1;
					while(nextRow < R && map[nextRow][c] == 0) ++nextRow;
					--nextRow;
					if(nextRow == r) continue;
					map[nextRow][c] = map[r][c];
					map[r][c] = 0;
				}
			}
		}
	}
	
	public static int[][] mapCopy(int[][] map) {
		int[][] cloneMap = new int[R][];
		for(int i = 0; i < map.length; i++) cloneMap[i] = map[i].clone();
		return cloneMap;
	}
}
