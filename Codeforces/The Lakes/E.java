import java.io.*;
import java.util.*;

public class E {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n, m;
            n = in.nextInt();
            m = in.nextInt();
            int grid[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    grid[i][j] = in.nextInt();
                }
            }
            LinkedList<Integer[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];
            int max = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    int sz = 0;
                    if(visited[i][j]) continue;
                    Integer[] check = new Integer[2];
                    check[0] = i;
                    check[1] = j;
                    queue.addFirst(check);
                    while(queue.size() > 0){
                        Integer[] curNode = queue.pollFirst();
                        int x = curNode[0];
                        int y = curNode[1];
                        if(visited[x][y]) continue;
                        visited[x][y] = true;
                        if(grid[x][y] == 0) continue;
                        sz += grid[x][y];
                        Integer[] gL = new Integer[2];
                        gL[0] = x-1;
                        gL[1] = y;
                        Integer[] gD = new Integer[2];
                        gD[0] = x;
                        gD[1] = y-1;
                        Integer[] gR = new Integer[2];
                        gR[0] = x+1;
                        gR[1] = y;
                        Integer[] gU = new Integer[2];
                        gU[0] = x;
                        gU[1] = y+1;
                        if(gL[0] >= 0)
                            queue.addFirst(gL);
                        if(gD[1] >= 0)
                            queue.addFirst(gD);
                        if(gR[0] < n)
                            queue.addFirst(gR);
                        if(gU[1] < m)
                            queue.addFirst(gU);
                    }
                    if(sz > max) max = sz;
                }
            }
            System.out.println(max);

        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            if(st.hasMoreTokens())
                return st.nextToken();
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        //#
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
        //$
    }


}