import java.io.*;
import java.util.*;

class knigsoftheforest {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int y = in.nextInt();
        int s = in.nextInt();
        int min = (int)1E9;
        int max = y;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n+k-2; i++){
            int yr = in.nextInt();
            int str = in.nextInt();
            if(yr > max) max = yr;
            if(map.containsKey(yr)){
                ArrayList<Integer> list = map.get(yr);
                list.add(str);
                map.put(yr, list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(str);
                map.put(yr, list);
            }
        }


        PriorityQueue<Integer> curStrengths = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        boolean good = false;
        int i = 0;
        while(true){
            int curYear = 2011 + i;
            if(curYear == y){
                curStrengths.add(s);
            }
            if(curYear > max) break;
            if(map.containsKey(curYear)){
                curStrengths.addAll(map.get(curYear));
            }
            int num = curStrengths.poll();
            if(num == s){
                good = true;
                System.out.println(curYear);
                break;
            }
            i++;
        }

        if(!good){
            System.out.println("unknown");
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
