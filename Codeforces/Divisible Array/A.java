import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n = in.nextInt();
            long sum = 0;
            int arr[] = new int[n];
            for(int i = 1; i <= n; i++){
                sum += i;
                arr[i-1] = i;
            }
            while(sum%n != 0){
                for(int i = 0; i < n; i++){
                    sum += (i+1);
                    arr[i] += (i+1);
                }
            }
            for(int i = 0; i < n; i++){
                if(i == n-1){
                    System.out.println(arr[i]);
                    break;
                }
                System.out.print(arr[i] + " ");
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