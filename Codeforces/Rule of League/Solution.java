import java.util.*;

public class Solution {
    public static int n, x, y;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int a = 0; a < numCases; a++) {
            n = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            if (y > x) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            if ((x != 0 && y != 0) || (x == 0 && y == 0) || (n - 1) % x != 0) {
                System.out.println("-1");
            } else {
                int winner = 1;
                int curX = x;
                for (int i = 1; i < n; i++) {
                    if (curX > 0) {
                        curX--;
                    } else {
                        curX = x - 1;
                        winner = i + 1;
                    }
                    System.out.print(winner + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean permutation(boolean[] which) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (which[i]) {
                num += x;
            } else {
                num += y;
            }
            if (num > (n - 1))
                return false;
        }
        for (int i = 0; i < n; i++) {

        }
        return true;
    }
}