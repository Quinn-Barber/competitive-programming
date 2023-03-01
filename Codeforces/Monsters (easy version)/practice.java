import java.util.*;

public class practice {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int j = 1; j <= numCases; j++) {
            int n = in.nextInt();
            int[] health = new int[n];
            for (int i = 0; i < n; i++) {
                health[i] = in.nextInt();
            }
            Arrays.sort(health);
            long moves = 0;
            int curNum = 1;
            for (int i = 0; i < health.length; i++, curNum++) {
                if (health[i] < curNum)
                    curNum--;
                moves += health[i] - curNum;
            }

            System.out.println(moves);
        }
    }
}