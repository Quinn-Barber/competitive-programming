import java.util.*;

public class heroeasy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int cases = 1; cases <= numCases; cases++) {
            int n = in.nextInt();
            long score = 0;
            PriorityQueue<Integer> pairing = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
            for (int i = 0; i < n; i++) {
                int curNum = in.nextInt();
                if (curNum == 0 && pairing.size() > 0) {
                    score += pairing.poll();
                } else if (curNum != 0) {
                    pairing.add(curNum);
                }
            }
            System.out.println(score);
        }
    }
}