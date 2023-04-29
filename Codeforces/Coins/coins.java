import java.io.*;
import java.util.*;

public class coins {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int cases = 1; cases <= N; cases++) {
            st = new StringTokenizer(reader.readLine());
            long n, k;
            n = Long.parseLong(st.nextToken());
            k = Long.parseLong(st.nextToken());
            if(n%2 == 0){
                writer.println("YES");
            }
            else{
                if(k%2 == 0){
                    writer.println("NO");
                }
                else{
                    writer.println("YES");
                }
            }
        }

        reader.close();
        writer.close();
    }


}
