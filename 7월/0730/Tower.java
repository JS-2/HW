import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tower {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arrTemp;
		
		Stack<int[]> towers = new Stack<int[]>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		
		for(int i = 0; i < N; i++) {
			//0이 크기 1이 인덱스
			arrTemp = new int[2];
			arrTemp[0] = Integer.parseInt(st.nextToken());
			arrTemp[1] = i;
			
			while(!towers.isEmpty()) {
				if(towers.peek()[0] < arrTemp[0])
					towers.pop();
				else
					break;
			}
			if(towers.isEmpty())
				sb.append("0 ");
			else {
				sb.append((towers.peek()[1] + 1));
				sb.append(" ");
			}
			
			towers.push(arrTemp);
		}
		System.out.println(sb.toString());
		
	}
}
