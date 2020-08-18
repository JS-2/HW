import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class HW1
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue;
        int N;
        int[][] linkArr;
        boolean[] visit;
         
        for(int Ti = 1; Ti <= 10; Ti++) {
            linkArr = new int[2][100];
            Arrays.fill(linkArr[0], -1);
            Arrays.fill(linkArr[1], -1);
            visit = new boolean[100];
             
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            N = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
             
            int to, from;
            for(int i = 0; i < N; i++) {
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                if(linkArr[0][from] == -1) {
                    linkArr[0][from] = to;
                } else { 
                    linkArr[1][from] = to;
                }
            }
             
            int answer = 0;
            queue = new LinkedList<>();
            queue.add(0);
            while(!queue.isEmpty()) {
                 
                if(queue.peek() == 99) {
                    answer = 1;
                    break; 
                }
                from = queue.poll();
                 
                if(visit[from]) continue;
                else visit[from] = true;
                 
                if(linkArr[0][from] != -1) {
                    queue.offer(linkArr[0][from]);
                    if(linkArr[1][from] != -1) 
                        queue.offer(linkArr[1][from]);
                }
            }           
            sb.append("#").append(Ti).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}