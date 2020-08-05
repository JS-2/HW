
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Main
{
	static boolean[][] map;
	static int N;
	static int[][] direction = {
			{ -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }
	};
	static int cnt;
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		
		for(int row = 0; row < N; row++) {
			String str = br.readLine();
			for(int col = 0; col < N; col++) {
				map[row][col] = str.charAt(col) == '1' ? true : false;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(map[row][col] == true) {
					cnt = 0;
					dfs(row, col);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		Iterator<Integer> iter = list.iterator();
		
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	
	private static void dfs(int row, int col) {
		//일단 본인 false로 만들고, 주변에 true를 찾아본다.
		//주변에 true가 있으면 재귀를써서 이어진부분 false로 만든다.
		++cnt;
		map[row][col] = false;
		int newRow, newCol;
		
		for(int d = 0; d < 4; d++) {
			newRow = row + direction[d][0];
			newCol = col + direction[d][1];
			if(newRow >= 0 && newRow < N
					&& newCol >= 0 && newCol < N
					&& map[newRow][newCol] == true) {
				dfs(newRow, newCol);
			}
		}
	}
}
