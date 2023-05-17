import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n = in.nextInt();
            int both = (int)(1E9);
            int left = (int)(1E9);
            int right = (int)(1E9);
            for(int i = 0; i < n; i++){
                int min = in.nextInt();
                int next = in.nextInt();
                if(next == 0) continue;
                if(next == 1){
                    if(min < right) right = min;
                }
                if(next == 10){
                    if(min < left) left = min;
                }
                if(next == 11){
                    if(min < both) both = min;
                }
            }
            int best = Math.min(left+right, both);
            if(best >= (int)(1E9)){
                System.out.println(-1);
            }
            else{
                System.out.println(best);
            }
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