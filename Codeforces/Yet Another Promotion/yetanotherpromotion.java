import java.util.*;

public class yetanotherpromotion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int cases = 1; cases <= numCases; cases++) {
            long a, b;
            a = in.nextInt();
            b = in.nextInt();
            long n, m;
            n = in.nextInt();
            m = in.nextInt();
            long q = (long) Math.floor(n / (m + 1));
            long r = n - (q * (m + 1));
            long ans = q * Math.min((a * m), (b * (m + 1))) + r * Math.min(a, b);
            System.out.println(ans);
        }
    }
}