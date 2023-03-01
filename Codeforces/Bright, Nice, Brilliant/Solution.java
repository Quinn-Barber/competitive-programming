import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int n = in.nextInt();
            System.out.println("1");
            if (n == 1) {
                continue;
            }
            System.out.println("1 1");
            if (n == 2) {
                continue;
            }
            for (int j = 2; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append("1 ");
                for (int h = 0; h < j - 1; h++) {
                    sb.append("0 ");
                }
                sb.append("1");
                System.out.println(sb.toString());
            }
        }
    }
}