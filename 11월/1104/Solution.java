import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static ArrayList<ArrayList<Integer>> upLink;
	static ArrayList<ArrayList<Integer>> downLink;
	static int[] linked;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int Ti = 1; Ti <= T; Ti++) {
			N = Integer.parseInt(br.readLine());
			upLink = new ArrayList<>(); 
			downLink = new ArrayList<>(); 
			for(int i = 0; i < N; i++) {
				upLink.add(new ArrayList<Integer>());
				downLink.add(new ArrayList<Integer>());
			}
			int M = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				upLink.get(from).add(to);
				downLink.get(to).add(from);
			}
			int answer = 0;
			for(int i = 0; i < N; i++)
				if(countLink(i) == N) ++answer; 
			sb.append("#").append(Ti).append(" ").append(answer).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static int countLink(int nodeNum) {
		int sum = 0;
		sum += countUpLink(nodeNum, new boolean[N]);
		sum += countDownLink(nodeNum, new boolean[N]);
		return sum - 1;
	}
	
	public static int countUpLink(int nodeNum, boolean[] visited) {
		int sum = 1;
		ArrayList<Integer> link = upLink.get(nodeNum);
		for(int i = 0; i < link.size(); i++) {
			int num = link.get(i);
			if(visited[num]) continue;
			visited[num] = true;
			sum += countUpLink(num, visited);
		}
		return sum;
	}
	
	public static int countDownLink(int nodeNum, boolean[] visited) {
		int sum = 1;
		ArrayList<Integer> link = downLink.get(nodeNum);
		for(int i = 0; i < link.size(); i++) {
			int num = link.get(i);
			if(visited[num]) continue;
			visited[num] = true;
			sum += countDownLink(num, visited);
		}
		return sum;
	}
}