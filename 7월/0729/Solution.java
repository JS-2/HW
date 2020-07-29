
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class Solution
{
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T, N, M;
		int[][] matrix;
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int max = 0;
			int temp;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			
			for(int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col = 0; col < N; col++) {
					matrix[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			for(int row = 0; row < N - M + 1; row++) {
				for(int col = 0; col < N - M + 1; col++) {
					temp = 0;
					for(int i = 0; i < M; i++)
						for(int j = 0; j < M; j++)
							temp += matrix[row + i][col + j];
					max = max < temp ? temp : max;
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}