import java.util.*;

public class fedya {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int cases = 1; cases <= numCases; cases++) {
            long x, y;
            x = in.nextInt();
            y = in.nextInt();

            long n = 2 * (x - y);

            System.out.println(n);
            long arr[] = new long[(int) n];
            int idx = 0;
            for (long c = y; c <= x; c++) {
                arr[idx] = c;
                idx++;
            }
            for (long c = x - 1; c > y; c--) {
                arr[idx] = c;
                idx++;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

        }
    }
}