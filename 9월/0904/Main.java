import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//미완
public class Main {

	final static int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int sharkRow = 0, sharkCol = 0, sharkSize = 2; // 아기상어 위치
		ArrayList<int[]> fishes = new ArrayList<>(); // 물고기들 위치
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] >= 1 && map[r][c] <= 6) fishes.add(new int[] { r, c, map[r][c] }); 
				else if(map[r][c] == 9) {
					sharkRow = r;
					sharkCol = c;
				} 
			}
		}
		
		while(!fishes.isEmpty()) {
			// 아기상어 <-> 물고기 거리 다 구하고 정렬
			// 가장 가까운 물고기(만약 아기상어보다 크면 다음으로 작은 물고기로 진행) bfs로 4방 탐색 진행
			// 만약 4방탐색으로 직접 이동했을때 장애물이 있어서 거리가 더 멀어지면
			// 그것보다 작은 최소 물고기로 다시 진행
			ArrayList<int[]> distances = new ArrayList<int[]>();
			Iterator<int[]> iter = fishes.iterator();
			while(iter.hasNext()) {
				int[] fish = iter.next();
				int diffR = Math.abs(fish[0] - sharkRow);
				int diffC = Math.abs(fish[1] - sharkCol);
				distances.add(new int[] { fish[0], fish[1], diffR + diffC, fish[2] });
			}
			Collections.sort(distances, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			}); // 물고기의 거리들 오름차순 정렬
			
			//4방탐색
			for(int i = 0; i < distances.size(); i++) {
				int[] fish = distances.get(i);
				if(fish[3] >= sharkSize) continue; // 작은 물고기중 가장 가까운거 찾는다.
				Queue<int[]> q = new LinkedList<>();
				q.offer(new int[] { fish[0], fish[1], 0 });
				int realDistance = 0;
				int r = 0, c = 0;
				while(q.isEmpty()) {
					int[] pos = q.poll();
					r = pos[0];
					c = pos[1];
					int distanceCnt = pos[2];
					if(sharkRow == r && sharkCol == c) {
						realDistance = distanceCnt;
						break;
					}// 실제거리 찾음 
					for(int[] d: direction) {
						int newR = r + d[0];
						int newC = r + d[1];
						if(map[newR][newC] > sharkSize) continue;
						q.offer(new int[] { newR, newC, distanceCnt + 1 });
					}
				}
				int indexCnt = 1;
				if(fish[2] == realDistance) {
					sharkRow = r;
					sharkCol = c;
					++sharkSize;
				} else if(fish[2] < realDistance) {
					while(realDistance < distances.get(i + indexCnt)[2]) {
						if(realDistance >= distances.get(i + indexCnt)[2]) i+= indexCnt -1;
						++indexCnt;
					}
				}
			}
			
		}
	}
}