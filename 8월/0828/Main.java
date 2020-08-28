
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());;
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] check = new int[d + 1];
		int[] dishes = new int[k];
		int[] sushies = new int[N + k - 1];
		int sushi, answer, remove, unique = 1;
		
		for(int i = 0; i < N; i++)
			sushies[i] = Integer.parseInt(br.readLine());
		for(int i = 0; i <k - 1; i++)
			sushies[N + i] = sushies[i];
		
		check[c] = 1;
		
		for(int i = 0; i < k; i++) {
			sushi = sushies[i];
			if(check[sushi] == 0) ++unique;
			++check[sushi];
			dishes[i] = sushi;
		}

		answer = unique;
		
		for(int i = k, cnt = 0; i < N + k - 1; i++, cnt = (cnt + 1) % k) {
			sushi = sushies[i];
			remove = dishes[cnt];
			--check[remove];
			if(check[remove] == 0) --unique;
			dishes[cnt] = sushi;
			if(check[sushi] == 0) ++unique;
			++check[sushi];
			answer = Math.max(answer, unique);
		}
		
		System.out.println(answer);
	}
}
