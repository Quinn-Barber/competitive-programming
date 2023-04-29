import java.io.*;
import java.util.*;

public class classrooms {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        PriorityQueue<int[]> endTimes = new PriorityQueue<>(n, new customComparator());

        for(int i = 0; i < n; i++){
            int start = in.nextInt();
            int end = in.nextInt();
            int[] arr = new int[2];
            arr[0] = start;
            arr[1] = end;
            endTimes.add(arr);
        }

        TreeMap<Integer, Integer> available = new TreeMap<>();
        int count = 0;
        available.put(0, k);

        while(endTimes.size() > 0){
            int[] cur = endTimes.poll();
            if(available.lowerKey(cur[0]) != null){
                count++;
                int key = available.lowerKey(cur[0]);
                int num = available.get(key);
                if(num == 1){
                    available.remove(key);
                }
                else{
                    available.put(key, num-1);
                }

                if(available.containsKey(cur[1])){
                    available.put(cur[1], available.get(cur[1])+1);
                }
                else{
                    available.put(cur[1], 1);
                }
            }
        }

        System.out.println(count);




    }

    static class customComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[1] > b[1])
                return 1;
            else
                return -1;
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
