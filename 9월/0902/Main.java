import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		final int[][] direction = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int[][] airwash = new int[2][];
		
		for(int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if(map[row][col] == -1 && airwash[0] == null) {
					airwash[0] = new int[] { row, col };
					airwash[1] = new int[] { row + 1, col };
				}
			}
		}
		
		//확산
		for(int Ti = 0; Ti < T; Ti++) {
			int[][] diffusionMap = new int[R][C];
			
			for(int row = 0; row < R; row++) {
				for(int col = 0; col < C; col++) {
					if(map[row][col] > 0) {
						int diffusion = map[row][col] / 5;
						for(int[] d: direction) {
							if(map[row][col] - diffusion < 0) continue;
							int newRow = row + d[0];
							int newCol = col + d[1];
							if(newRow < 0 || newRow >= R || newCol < 0 || newCol >= C || map[newRow][newCol] == -1) continue;
							diffusionMap[newRow][newCol] += diffusion;
							map[row][col] -= diffusion;
						}
						diffusionMap[row][col] += map[row][col];
					} else if(map[row][col] == -1) diffusionMap[row][col] = -1;
				}
			}
			map = diffusionMap;
			
			//위쪽순환
			int row = airwash[0][0];
			int col = airwash[0][1];
			
			Deque<Integer> d = new LinkedList<Integer>();
			
			while(++col < C) d.offer(map[row][col]);
			--col;
			while(--row > -1) d.offer(map[row][col]);
			++row;
			while(--col > -1) d.offer(map[row][col]);
			++col;
			while(++row < airwash[0][0]) d.offer(map[row][col]);
			d.addFirst(0);
			
			row = airwash[0][0];
			col = airwash[0][1];
			
			while(++col < C) map[row][col] = d.poll();
			--col;
			while(--row > -1) map[row][col] = d.poll();
			++row;
			while(--col > -1) map[row][col] = d.poll();
			++col;
			while(++row < airwash[0][0]) map[row][col] = d.poll();
			
			//아래쪽순환
			row = airwash[1][0];
			col = airwash[1][1];
			
			d = new LinkedList<Integer>();
			
			while(++col < C) d.offer(map[row][col]);
			--col;
			while(++row < R) d.offer(map[row][col]);
			--row;
			while(--col > -1) d.offer(map[row][col]);
			++col;
			while(--row > airwash[1][0]) d.offer(map[row][col]);
			d.addFirst(0);
			
			row = airwash[1][0];
			col = airwash[1][1];
			
			while(++col < C) map[row][col] = d.poll();
			--col;
			while(++row < R) map[row][col] = d.poll();
			--row;
			while(--col > -1) map[row][col] = d.poll();
			++col;
			while(--row > airwash[1][0]) map[row][col] = d.poll();
			
		}
		
		int answer = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == -1) continue;
				answer += map[i][j];
			}
		}
		System.out.println(answer);
	}
}