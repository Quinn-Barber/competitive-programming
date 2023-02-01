import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int n, m;
            n = in.nextInt();
            m = in.nextInt();
            if (n == 1 || m == 1) {
                System.out.println(n + " " + m);
            } else if (n == 2 && m <= 3) {
                System.out.println(n + " " + 2);
            } else if (m == 2 && n <= 3) {
                System.out.println(2 + " " + m);
            } else if (n == 3 && m == 3) {
                System.out.println(2 + " " + 2);
            } else {
                System.out.println(n + " " + m);
            }
        }

        in.close();
    }
}