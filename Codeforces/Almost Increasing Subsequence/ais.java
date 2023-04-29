import java.io.*;
import java.util.*;

public class ais {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int arr[] = new int[n+2];
        int inc[] = new int[n+2];
        for(int i = 1; i < n+1; i++){
            arr[i] = in.nextInt();
        }
        inc[1] = 1;
        for(int i = 2; i < n+1; i++){
            if(arr[i] > arr[i-1]){
                inc[i] = inc[i-1] = 1;
            }
        }
        inc[n] = 1;
        int psum[] = psum(inc);

        for(int i = 0; i < q; i++){
            int l, r;
            l = in.nextInt();
            r = in.nextInt();
            if((r-l)+1 < 3){
                System.out.println((r-l)+1);
            }
            else{
                int count = psum[r+1]-psum[l];
                if(inc[r] == 0) count++;
                if(inc[l] == 0) count++;
                System.out.println(count);
            }
        }
    }

    public static int[] psum(int[] a){
        int[] psums = new int[a.length+1];
        for(int i = 0; i < a.length; i++){
            psums[i+1] = psums[i] + a[i];
        }
        return psums;
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
