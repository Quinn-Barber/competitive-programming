import java.io.*;
import java.util.*;

public class legs {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int cases = 1; cases <= N; cases++) {
            st = new StringTokenizer(reader.readLine());
            long a, b;
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            double ans = a+b+100;
            for(long m = 1; m <= Math.max(a, b); m++){
                double curAns = Math.ceil((double)a/m) + Math.ceil((double)b/m) + m-1;
                if(curAns < ans){
                    ans = curAns;
                }
                if(m > ans) break;
            }
            writer.printf("%.0f\n", ans);
        }

        reader.close();
        writer.close();
    }


}
