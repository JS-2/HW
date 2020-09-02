import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int N;
	static boolean[][] adj;
	static int[] pArr;
	static int answer = Integer.MAX_VALUE;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pArr = new int[N];
		adj = new boolean[N][N];
		StringTokenizer st  = new StringTokenizer(br.readLine());
		// 인구수
		for(int i = 0; i < N; i++) pArr[i] = Integer.parseInt(st.nextToken());
		// 인접행렬
		for(int from = 0; from < N; from++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n; j++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				adj[from][to] = true;
			}
		}
		
		dfs(new int[10], new int[10], 0, 0, 0);
		if(answer != Integer.MAX_VALUE)
			System.out.println(answer);
		else
			System.out.println(-1);
	}
	
	private static void canReach(int from, int to, boolean[] visit, int[] arr, int n) {
		if(visit[from]) return;
		else visit[from] = true;
		
		if(from == to) {
			flag = true;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(adj[from][arr[i]]) canReach(arr[i], to, visit, arr, n);
		}
	}
	
	private static void dfs(int arr1[], int arr2[], int cnt1, int cnt2, int goo) {
		if(goo == N) {
			//1. 하나도 없으면 안됨
			if(cnt1 == 0 || cnt2 == 0) return;
			if(canConnection(arr1, cnt1) && canConnection(arr2, cnt2))
				answer = Math.min(answer, pDiff(arr1, arr2, cnt1, cnt2));
			return;
		}
		arr1[cnt1] = goo;
		dfs(arr1, arr2, cnt1 + 1, cnt2, goo + 1);
		arr2[cnt2] = goo;
		dfs(arr1, arr2, cnt1, cnt2 + 1, goo + 1);
	}
	
	private static boolean canConnection(int[] arr, int n) {
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				flag = false;
				canReach(arr[i], arr[j], new boolean[101], arr, n);
				if(!flag) return false;
			}
		}
		return true;
	}
	
	private static int pDiff(int[] arr1, int[] arr2, int cnt1, int cnt2) {
		int diff = 0;
		for(int i = 0; i < cnt1; i++) diff += pArr[arr1[i]];
		for(int i = 0; i < cnt2; i++) diff -= pArr[arr2[i]];
		return Math.abs(diff);
	}
}