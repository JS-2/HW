import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N, M, T;
        Object[] strs1;
        Set<String> set;
         
        T = Integer.parseInt(br.readLine());
         
        for(int Ti = 1; Ti <= T; Ti++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 첫번째 집합의 원소 수
            set = new HashSet<String>();
            M = Integer.parseInt(st.nextToken()); // 두번째 집합의 원소 수
             
            // 문자열 집합1 초기화
            st = new StringTokenizer(br.readLine());
            for(int Ni = 0; Ni < N; Ni++) {
                set.add(st.nextToken());
            }
             
            // binarySearch 
            int cnt = 0;
            String compare;
            st = new StringTokenizer(br.readLine());
            for(int Mi = 0; Mi < M; Mi++) {
                compare = st.nextToken();
                if(set.contains(compare))
                    ++cnt;
            }
             
            sb.append("#").append(Ti).append(" ").append(cnt).append("\n");
        }
         
        System.out.println(sb.toString());
    }
}