import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HW {
	
	static int[][] board = new int[19][19];
	static boolean[][][] visit = new boolean[19][19][8];
	final static int[][] direction = {
			{ -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, 
			{ 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }
	};
	final static int empty = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int color;
		// 입력
		for(int r = 0; r < 19; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 19; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		//가장 왼쪽의 바둑알을 출력해야 하므로 왼쪽부터 오른쪽으로 스캔한다.
		for(int col = 0; col < 19; col++) {
			for(int row = 0; row < 19; row++) {
				if(board[row][col] != empty) {
					color = board[row][col];
					for(int d = 0; d < 8; d++) {
						if (visit[row][col][d]) continue;
						else visit[row][col][d] = true;
						int cnt = 1;
						int newRow = row + direction[d][0];
						int newCol = col + direction[d][1];
						while(newRow >= 0 && newRow < 19 &&
								newCol >= 0 && newCol < 19 &&
								board[newRow][newCol] == color &&
								!visit[newRow][newCol][d]) {
							++cnt;
							visit[newRow][newCol][d % 4] = true;
							visit[newRow][newCol][d % 4 + 4] = true;
							newRow += direction[d][0];
							newCol += direction[d][1];
						}
						if(cnt == 5) {
							System.out.println(color);
							System.out.println((row + 1) + " " + (col + 1));
							return;
						}
					} // for
				} // if
			}// for
		}// for
		System.out.println(0);
	}
}