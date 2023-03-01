import java.util.*;

public class mocha {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int cases = 1; cases <= numCases; cases++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            boolean ans = false;
            for (int i = 0; i < (n - 1); i++) {
                for (int j = (i + 1); j < n; j++) {
                    if (gcd(arr[i], arr[j]) <= 2) {
                        System.out.println("Yes");
                        ans = true;
                        break;
                    }
                }
                if (ans)
                    break;
            }
            if (!ans)
                System.out.println("No");
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}