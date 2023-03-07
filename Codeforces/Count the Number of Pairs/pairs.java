import java.util.*;

public class pairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int cases = 1; cases <= numCases; cases++) {
            int n, k;
            n = in.nextInt();
            k = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            int[] lowercase = new int[26];
            int[] uppercase = new int[26];
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    lowercase[str.charAt(i) - 'a']++;
                } else {
                    uppercase[str.charAt(i) - 'A']++;
                }
            }

            int numOps = 0;
            for (int i = 0; i < 26; i++) {
                if (lowercase[i] != uppercase[i]) {
                    int numDiff = Math.abs(lowercase[i] - uppercase[i]);
                    numDiff /= 2;
                    if ((numDiff + numOps) > k) {
                        if (lowercase[i] < uppercase[i]) {
                            lowercase[i] += (k - numOps);
                            uppercase[i] -= (k - numOps);
                        } else {
                            uppercase[i] += (k - numOps);
                            lowercase[i] -= (k - numOps);
                        }
                        break;
                    } else {
                        if (lowercase[i] < uppercase[i]) {
                            lowercase[i] += numDiff;
                            uppercase[i] -= numDiff;
                        } else {
                            uppercase[i] += numDiff;
                            lowercase[i] -= numDiff;
                        }
                        numOps += numDiff;
                    }
                }
            }
            int numBurles = 0;
            for (int i = 0; i < 26; i++) {
                numBurles += Math.min(lowercase[i], uppercase[i]);
            }

            System.out.println(numBurles);

        }
    }
}