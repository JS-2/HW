import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
 
class HW2
{
    final static int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static boolean[][] matrix;
    static int N;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayList<Point> rowColList;
        String temp;
         
        int T = Integer.parseInt(br.readLine());
         
        for(int Ti = 1; Ti <= T; Ti++) {
            rowColList = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            matrix = new boolean[N][N];
             
            for(int row = 0; row < N; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col < N; col++) {
                    temp = st.nextToken();
                    matrix[row][col] = temp.equals("0") ? false : true;
                }
            }
             
            int cnt = 0;
            for(int row = 0; row < N; row++) {
                for(int col = 0; col < N; col++) {
                    if(matrix[row][col] == true) {
                        rowColList.add(findRowCol(row, col));
                        check(row,col);
                        cnt++;
                    }
                }
            }
             
            sb.append("#").append(Ti).append(" ").append(cnt);
            rowColList.sort(new Comparator<Point>() {
                @Override
                public int compare(Point p1, Point p2) {
                    if(p1.x * p1.y != p2.x * p2.y)
                        return p1.x * p1.y - p2.x * p2.y;
                    else
                        return p1.x - p2.x;
                } 
            });
             
            Iterator<Point> iter = rowColList.iterator();
            while(iter.hasNext()) {
                Point p = iter.next();
                sb.append(" ").append(p.x).append(" ").append(p.y);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
     
    private static Point findRowCol(int row, int col) {
        int rowLength = 0, colLength = 0;
        int tempRow = row, tempCol = col;
        while(tempRow < N && matrix[tempRow++][col]) rowLength++;
        while(tempCol < N && matrix[row][tempCol++]) colLength++;
         
        return new Point(rowLength, colLength);
    }
     
    private static void check(int row, int col) {
        int newRow, newCol;
        matrix[row][col] = false;
         
        for(int d = 0; d < 4; d++) {
            newRow = direction[d][0] + row;
            newCol = direction[d][1] + col;
            if(newRow >= 0 && newRow < N && newCol >= 0 && newCol < N
                    && matrix[newRow][newCol] == true ) {
                check(newRow, newCol);
            }
        }
    }
}