import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	final static int EMPTY = 0;
	final static int BODY = 1;
	final static int APPLE = 2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			map[row][col] = APPLE;
		}
		char[] timeCmd = new char[10000];
		int L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().toCharArray()[0];
			timeCmd[time] = cmd;
		}
		
		int headR = 0;
		int headC = 0;
		int dirIdx = 1;
		int time = 0;
		Queue<int[]> tails = new LinkedList<>();
		tails.add(new int[] { headR, headC });
		
		map[headR][headC] = BODY;
		for(; time < 10000; time++) {
			
			if(timeCmd[time] == 'L') dirIdx = (dirIdx + 3) % 4;	
			else if(timeCmd[time] == 'D')  dirIdx = (dirIdx + 1) % 4;	
			headR += dir[dirIdx][0];
			headC += dir[dirIdx][1];
			if(headR < 0 || headR >= N || headC < 0 || headC >= N) break;
			
			if(map[headR][headC] == APPLE) {
				map[headR][headC] = BODY;
				tails.add(new int[] { headR, headC });
			} else if(map[headR][headC] == EMPTY) {
				map[headR][headC] = BODY;
				tails.add(new int[] { headR, headC });
				int[] tail = tails.poll();
				map[tail[0]][tail[1]] = EMPTY;
			} else if(map[headR][headC] == BODY) break;
		}
		
		System.out.println(time + 1);
	}
	
}
