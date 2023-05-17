import java.io.*;
import java.util.*;

public class F {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n, m;
            n = in.nextInt();
            m = in.nextInt();
            ArrayList<Integer>[] edges = new ArrayList[n];
            for(int i = 0; i < n; i++){
                edges[i] = new ArrayList<>();
            }
            for(int i = 0; i < m; i++){
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                ArrayList<Integer> uE = edges[u];
                ArrayList<Integer> vE = edges[v];
                uE.add(v);
                vE.add(u);
                edges[u] = uE;
                edges[v] = vE;
            }
            HashMap<Integer, Integer> occ = new HashMap<>();
            TreeSet<Integer> values = new TreeSet<>();
            for(int i = 0; i < n; i++){
                int size = edges[i].size();
                values.add(size);
                Integer check = occ.getOrDefault(size, 0);
                check++;
                occ.put(size, check);
            }
            Iterator<Integer> valuesItr = values.iterator();
            PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[0]-b[0]);
            for(int i = 0; i < values.size(); i++){
                Integer[] add = new Integer[2];
                int oc, e;
                e = valuesItr.next();
                oc = occ.get(e);
                add[0] = oc;
                add[1] = e;
                queue.add(add);
            }
            int x = -1;
            int y = -1;
            while(queue.size() > 0){
                Integer[] cur = queue.poll();
                if(x == -1) x = cur[1];
                else if(y == -1){
                    if(cur[1] == 1){
                        y = x-1;
                    }
                    else{
                        y = cur[1]-1;
                    }
                }
            }
            System.out.println(x + " " + y);
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