import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int row, col, N, width, height, minDistance[], map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		map = new int[height + 1][width + 1];
		minDistance = new int[N + 1];
		
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		
		/* 1: 북↑
		   2: 남↓
		   3: 서←
		   4: 동→ */
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			if(dir == 1) map[0][pos] = i;
			else if(dir == 2) map[height][pos] = i;
			else if(dir == 3) map[pos][0] = i;
			else if(dir == 4) map[pos][width] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int myDir = Integer.parseInt(st.nextToken());
		int myPos = Integer.parseInt(st.nextToken());
		
		if(myDir == 1) { row = 0; col = myPos;}
		else if(myDir == 2) { row = height; col = myPos;}
		else if(myDir == 3) { row = myPos; col = 0;}
		else if(myDir == 4) { row = myPos; col = width;}
		
		clockWise();
		counterClockWise();
		int answer = 0;
		for(int i = 1; i < N + 1; i++)
			answer += minDistance[i];
		System.out.println(answer);
	}
	
	private static void clockWise() {
		int newRow = row;
		int newCol = col;
		int cnt = 0;
		do {
			if(map[newRow][newCol] > 0 && minDistance[map[newRow][newCol]] > cnt) 
				minDistance[map[newRow][newCol]] = cnt;
			
			if(newRow == 0 && newCol != width) ++newCol;
			else if(newCol == 0 && newRow != 0) --newRow;			
			else if(newRow == height && newCol != 0) --newCol;
			else if(newCol == width && newRow != height) ++newRow;
			++cnt;
		} while(newRow != row || newCol != col);
	}
	
	private static void counterClockWise() {
		int newRow = row;
		int newCol = col;
		int cnt = 0;
		do {
			if(map[newRow][newCol] > 0 && minDistance[map[newRow][newCol]] > cnt) 
				minDistance[map[newRow][newCol]] = cnt;
			
			if(newRow == 0 && newCol != 0) --newCol;
			else if(newCol == 0 && newRow != height) ++newRow;			
			else if(newRow == height && newCol != width) ++newCol;
			else if(newCol == width && newRow != 0) --newRow;
			++cnt;
		} while(newRow != row || newCol != col);
	}
}