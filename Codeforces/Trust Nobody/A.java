import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n;
            n = in.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                int num = in.nextInt();
                arr[i] = num;
            }

            System.out.println(findNumberOfLiars(arr, n));

        }
    }

    private static int findNumberOfLiars(int[] liars, int n) {
        for (int numOfLiars = 0; numOfLiars <= n; numOfLiars++) {
            int truthfulCount = 0;
            for (int i = 0; i < n; i++) {
                if (liars[i] <= numOfLiars) {
                    truthfulCount++;
                }
            }
            if (truthfulCount == n - numOfLiars) {
                return numOfLiars;
            }
        }
        return -1;
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