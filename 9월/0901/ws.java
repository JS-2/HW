import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()) - 1;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		ArrayList<LinkedList<int[]>> edges = new ArrayList<>();
		for(int i = 0; i < V; i++) edges.add(new LinkedList<>());
		
		boolean[] visit = new boolean[V];
		int[] answer = new int[V];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());	
			edges.get(u).add(new int[] { v, w });
		}
		
		int INFINITY = Integer.MAX_VALUE;
		pq.offer(new int[] { K, 0 });
		Arrays.fill(answer, INFINITY);
		answer[K] = 0;
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			int[] currentVertex = pq.poll();
			int current = currentVertex[0];
			int weight = currentVertex[1];
			
			if(visit[current]) continue;
			visit[current] = true;
			if(++cnt == V) break;
			 
			// 방문한적 없고, 간선이 있고, 거리가 가장 작은 간선
			// 2단계: 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 update
			
			LinkedList<int[]> nextEdge = edges.get(current);
			Iterator<int[]> iter = nextEdge.iterator();
			while(iter.hasNext()) {
				int[] edge = iter.next();
				int v = edge[0];
				int w = edge[1];
				if(answer[v] > weight + w) {
					answer[v] = weight + w;
					pq.offer(new int[] { v, answer[v] });
				}
			}
		}
		for(int i = 0; i < V; i++) {
			if(answer[i] != INFINITY)
				System.out.println(answer[i]);
			else
				System.out.println("INF");
		}
	}
}