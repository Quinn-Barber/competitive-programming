import java.io.*;
import java.util.*;

public class stacking {
    static int N, K;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("stacking.in"));
        PrintWriter writer = new PrintWriter(new FileWriter("stacking.out"));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] diff = new int[N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(reader.readLine());
            int A, B;
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            diff[A - 1]++;
            diff[B]--;
            // st = new StringTokenizer(reader.readLine());
            // int num = Integer.parseInt(st.nextToken());
            // long num = Long.parseLong(st.nextToken());
            // writer.println(...);

            // st = new StringTokenizer(reader.readLine(), delimiters);
            // String token = null;
            // while(st.hasMoreTokens())
            // token = st.nextToken();
            // writer.close(); to see right away OR sout
        }

        int psumArr[] = psum(diff);
        Arrays.sort(psumArr);

        writer.println(psumArr[psumArr.length / 2]);

        reader.close();
        writer.close();
    }

    public static int[] psum(int[] a) {
        int[] psums = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            psums[i + 1] = psums[i] + a[i];
        }
        return psums;
    }

}
