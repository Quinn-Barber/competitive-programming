import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n, k;
            n = in.nextInt();
            k = in.nextInt();
            int arr[] = new int[n];
            long sum = 0;
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
                sum += arr[i];
            }
            Arrays.sort(arr);
            long lArr[] = new long[k];
            long rArr[] = new long[k];
            int lIdx = 0;
            int rIdx = n-1;
            long cSum = 0;
            for(int i = 0; i < k; i++){
                lArr[i] = arr[lIdx] + arr[lIdx+1];
                cSum += lArr[i];
                rArr[i] = arr[rIdx];
                lIdx += 2;
                rIdx--;
            }
            long min = cSum;
            for(int i = 0; i < k; i++){
                cSum -= lArr[k-i-1];
                cSum += rArr[i];
                if(min > cSum) min = cSum;
            }
            System.out.println(sum - min);

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