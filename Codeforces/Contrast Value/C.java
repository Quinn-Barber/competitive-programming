import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n = in.nextInt();
            int arr[] = new int[n];
            int size = n;
            int inc = 0;
            int dec = 0;
            int same = 0;
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
                if(i >= 1){
                    if(arr[i-1] > arr[i]){
                        if(dec >= 2){
                            size -= dec-1;
                        }
                        if(same > 0){
                            size -= same;
                        }
                        dec = 0;
                        same = 0;
                        inc++;
                    }
                    else if(arr[i-1] < arr[i]){
                        if(inc >= 2){
                            size -= inc-1;
                        }
                        if(same > 0){
                            size -= same;
                        }
                        same = 0;
                        inc = 0;
                        dec++;
                    }
                    else{
                        if(inc > 0 && dec == 0){
                            inc++;
                        }
                        else if(dec > 0 && inc == 0){
                            dec++;
                        }
                        else{
                            same++;
                        }
                    }
                }
            }
            if(same > 0){
                size -= same;
            }
            if(inc >= 2){
                size -= inc-1;
            }
            if(dec >= 2 ){
                size -= dec-1;
            }
            System.out.println(size);

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