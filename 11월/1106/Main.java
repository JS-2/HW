import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	final static int[][] dir = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
	static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragonCurve(x, y, d, g);
		}
		int answer = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[j][i] && map[j + 1][i] && map[j][i + 1] && map[j + 1][i + 1]) ++answer;
			}
		}
		System.out.println(answer);
	}
	
	public static void dragonCurve(int x, int y, int d, int g) {
		map[x][y] = true;
		ArrayList<int[]> posArr = new ArrayList<>();
		posArr.add(new int[] { x, y });
		x += dir[d][0];
		y += dir[d][1];
		map[x][y] = true;

		for(int gi = 1; gi <= g; gi++) {
			int[] nextPos = curve(x, y, posArr);
			posArr.add(new int[] { x, y });
			x = nextPos[0];
			y = nextPos[1];
		}
	}
	
	public static int[] curve(int a, int b, ArrayList<int[]> posArr) {
		int size = posArr.size();
		int[] pos = posArr.get(0);
		int[] lastPos = clockwise(a, b, pos[0], pos[1]);
		posArr.add(lastPos);
		//끝점
		for(int i = 1; i < size; i++) {
			pos = posArr.get(i);
			int[] clockPos = clockwise(a, b, pos[0], pos[1]);
			posArr.add(clockPos);
		}
		return lastPos;
	}
	
	public static int[] clockwise(int a, int b, int x, int y) {
		int newX, newY;
		int diffX = Math.abs(a - x);
		int diffY = Math.abs(b - y);
		if(b > y) newX = a + diffY;
		else newX = a - diffY;
		if(x > a) newY = b + diffX;
		else newY = b - diffX;
		
		map[newX][newY] = true;
		return new int[] { newX, newY };
	}
}