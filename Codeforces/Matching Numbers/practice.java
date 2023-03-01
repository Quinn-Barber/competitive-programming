import java.util.*;

public class practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int j = 1; j <= numCases; j++) {
            int n = in.nextInt();
            if (n % 2 == 0) {
                System.out.println("No");
                continue;
            } else {
                System.out.println("Yes");
            }
            int x = 1;
            int sum = (n * 3 + 3) / 2;
            int i;
            for (i = 0; i < (n + 1) / 2; i++) {
                System.out.println(x + " " + (sum - x));
                x += 2;
                sum++;
            }
            x = 2;
            for (; i < n; i++) {
                System.out.println(x + " " + (sum - x));
                x += 2;
                sum++;
            }
        }
    }
}