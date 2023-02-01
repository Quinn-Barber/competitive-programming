import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int j = 0; j < numCases; j++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            long max = 0;
            if (k == 1) {
                for (int i = 0; i < n; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }
            } else {
                for (int i = 0; i < k; i++) {
                    int maxRow = arr[i];
                    for (int g = i; g < n; g += k) {
                        if (arr[g] > maxRow) {
                            maxRow = arr[g];
                        }
                    }
                    max += maxRow;
                }
            }
            System.out.println(max);
        }
    }
}