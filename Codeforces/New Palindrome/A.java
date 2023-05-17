import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            String str = in.next();
            int[] freq = new int[26];
            for(int i = 0; i < str.length(); i++){
                freq[str.charAt(i)-'a']++;
            }
            int two = 0;
            for(int i = 0; i < 26; i++){
                if(freq[i] >= 2) two++;
            }
            if(two > 1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
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