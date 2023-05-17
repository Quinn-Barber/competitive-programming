import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n = in.nextInt();
            int bs = 0;
            int max = 0;
            boolean bsb = false;
            for(int i = 0; i < n; i++){
                int num = in.nextInt();
                if(bsb){
                    if(num == 0) bs++;
                    else{
                        bsb = false;
                        if(bs > max) max = bs;
                        bs = 0;
                    }
                }
                else{
                    if(num == 1) continue;
                    bsb = true;
                    bs++;
                }
            }
            if(bs > max) max = bs;
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