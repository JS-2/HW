import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	final static int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static char[][] board;
	static int R, C;
	static int answer = Integer.MIN_VALUE;
	static Set<Character> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][];
		for(int row = 0; row < R; row++) {
			board[row] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, 1, 5);
		System.out.println(answer);
	}
	
	private static void dfs(int row, int col, int cnt, int pass) {
		char boardChar = board[row][col];
		if(set.contains(boardChar)) return;
		set.add(boardChar);
		
		for(int d = 0; d < 4; d++) {
			if(d == pass) continue;
			
			int newRow = row + direction[d][0];
			int newCol = col + direction[d][1];
			
			if(newRow >= 0 && newRow < R &&
			   newCol >= 0 && newCol < C) {
				boardChar = board[newRow][newCol];
				dfs(newRow, newCol, cnt + 1, (d + 2) % 4 );
			}
		}
		set.remove(board[row][col]);
		answer = Math.max(answer, cnt);
	}
	
}
