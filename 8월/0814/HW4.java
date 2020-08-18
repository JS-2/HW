import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
  
class HW4
{
    static int N;
    static int[] array;
    static int[] dp;
      
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
          
        for(int Ti = 1; Ti <= T; Ti++) {
            int input;
            dp = new int[1000001];
            N = Integer.parseInt(br.readLine());
            array = new int[N];
            st = new StringTokenizer(br.readLine());
              
            for(int i = 0; i < N; i++) {
                input = Integer.parseInt(st.nextToken());
                array[i] = input;
                dp[input] = 1;
            }
              
            Arrays.sort(array);
              
            for(int index = 0; index < N; index++) {
                int next = array[index];
                 
                for(int i = 2; next * i <= array[N-1]; i++) {
                    if(dp[next * i] > 0)
                        dp[next * i] = dp[next * i] < dp[next] + 1 ? dp[next] + 1 : dp[next * i];
                }
            }
             
            int answer = Integer.MIN_VALUE;
             
            for(int i = 0; i < N; i++)
                answer = answer < dp[array[i]] ? dp[array[i]] : answer;
              
            sb.append("#").append(Ti).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}