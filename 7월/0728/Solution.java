
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		final int[][] direction = {
				{ 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
		};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		int[] NArr;
		T = Integer.parseInt(br.readLine());
		NArr = new int[T];
		int[][][] output = new int[T][][];
		
		for(int test_case = 0; test_case < T; test_case++) {
			NArr[test_case] = Integer.parseInt(br.readLine());
			output[test_case] = new int[NArr[test_case]][NArr[test_case]];
		}
		
		for(int test_case = 0; test_case < T; test_case++) {
			int N = NArr[test_case];
			int[][] out = output[test_case];
			int row = 0;
			int col = 0;
			int dIdx = 0;
			
			for(int i = 1; i <= N * N; i++) {
				out[row][col] = i; 
				if(row + direction[dIdx][0] < 0 || row + direction[dIdx][0] >= N 
						|| col + direction[dIdx][1] < 0 || col + direction[dIdx][1] >= N
						|| out[row + direction[dIdx][0]][col + direction[dIdx][1]] > 0) {
					dIdx = (dIdx + 1) % 4;
				}
				row += direction[dIdx][0];
				col += direction[dIdx][1];
			}
			
			System.out.println("#" + (test_case + 1));
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(out[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}