import java.util.*;

public class practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int j = 1; j <= numCases; j++) {
            int n, m, d;
            n = in.nextInt();
            m = in.nextInt();
            d = in.nextInt();
            HashMap<Integer, Integer> perm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                perm.put(in.nextInt(), i);
            }
            int arr[] = new int[m];
            int lastNum = 0;
            int pushApart = -1;
            int pushTogether = -1;

            boolean good = false;

            for (int i = 0; i < m; i++) {
                arr[i] = perm.get(in.nextInt());
                if (i == 0) {
                    lastNum = arr[i];
                    continue;
                }
                if (n > (d + 1)) {
                    if ((d + 1) - (arr[i] - lastNum) < pushApart || pushApart == -1) {
                        pushApart = (d + 1) - (arr[i] - lastNum);
                    }
                }
                if ((arr[i] - lastNum) < pushTogether || pushTogether == -1) {
                    pushTogether = arr[i] - lastNum;
                }
                if (arr[i] <= lastNum || arr[i] - lastNum > d) {
                    good = true;
                }
                lastNum = arr[i];
            }

            if (good) {
                System.out.println(0);
            } else {
                if (pushTogether <= pushApart || pushApart == -1) {
                    System.out.println(pushTogether);
                } else {
                    System.out.println(pushApart);
                }
            }
        }
    }
}