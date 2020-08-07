
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main
{
	static Queue<int[]> queue;
	static int N, K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int cnt = 0;
		queue = new LinkedList<int[]>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		queue.offer(new int[] {N,0,1});
		queue.offer(new int[] {N,1,1});
		queue.offer(new int[] {N,2,1});
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int subin = arr[0];
			int choice = arr[1];
			cnt = arr[2];
			switch(choice) {
			case 0:
				subin = subin - 1;
				break;
			case 1:
				subin = subin + 1;
				break;
			case 2:
				subin = subin * 2;
			}
			
			if(subin == K)
				break;
			
			queue.offer(new int[] {subin, 0, cnt + 1});
			queue.offer(new int[] {subin, 1, cnt + 1});
			queue.offer(new int[] {subin, 2, cnt + 1});
		}
		
		System.out.println(cnt);
	}
	
}