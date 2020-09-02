import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {

	final static int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }};
	static int N;
	static int answerCore;
	static int answer;
	static boolean[][] cells;
	static ArrayList<int[]> cellPositions;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int Ti = 1; Ti <= T; Ti++) {
			answerCore = Integer.MIN_VALUE;
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			cells = new boolean[N][N];
			cellPositions = new ArrayList<>();
			//입력
			for(int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col = 0; col < N; col++) {
					String cell = st.nextToken();
					if(cell.equals("1")) {
						cells[row][col] = true;
						// 테두리는 전원 이미 연결됨
						if(row == 0 || row == N - 1 || col == 0 || col == N - 1) continue;
						cellPositions.add(new int[] { row, col });
					}
				}
			}
			
			dfs(0, 0, cellPositions.size(), 0);
			sb.append("#").append(Ti).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void dfs(int index, int cnt, int size, int coreCnt) {
		if(index == size) {
			if(answerCore < coreCnt) {
				answer = cnt;
				answerCore = coreCnt;
			} else if(answerCore == coreCnt) {
				answer = Math.min(answer, cnt);
			}
			return;
		}
		
		int[] pos = cellPositions.get(index);
		
		for(int[] d: direction) {
			int newRow = pos[0] + d[0];
			int newCol = pos[1] + d[1];
			//방향으로 쭉 선깔기
			while(newRow >= 0 && newRow < N &&
				  newCol >= 0 && newCol < N) {
				if(cells[newRow][newCol]) break;
				++cnt;
				cells[newRow][newCol] = true;
				newRow += d[0];
				newCol += d[1];
			}
			newRow -= d[0];
			newCol -= d[1];
			
			if(newRow == 0 || newRow == N - 1 ||
			   newCol == 0 || newCol == N - 1)
				dfs(index + 1, cnt, size, coreCnt + 1);
			
			//반대 방향으로 선 쭉 회수하기
			while(newRow >= 0 && newRow < N &&
				  newCol >= 0 && newCol < N) {
				if(newRow == pos[0] && newCol == pos[1]) break;
				--cnt;
				cells[newRow][newCol] = false;
				newRow -= d[0];
				newCol -= d[1];
			}
		}
		//코어 전원 연결 포기
		dfs(index + 1, cnt, size, coreCnt);
	}
}
