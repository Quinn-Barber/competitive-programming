import java.io.*;
import java.util.*;

public class pattern {
    static int N;

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        for (int cases = 1; cases <= N; cases++) {
            int n, k;
            n = in.nextInt();
            k = in.nextInt();
            int[][] chart = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chart[i][j] = in.nextInt();
                }
            }
            int differences = 0;
            int maxI = n/2;
            boolean odd = false;
            if(n%2 == 1) {
                odd = true;
                maxI++;
            }
            for (int i = 0; i < maxI; i++) {
                for (int j = 0; j < n; j++) {
                    if(i == maxI-1 && j >= n/2 && odd) continue;
                    if(chart[i][j] != chart[n-i-1][n-j-1]) differences++;
                }
            }
            if(differences > k){
                System.out.println("NO");
            }
            else{
                k -= differences;
                if(k % 2 == 0 || odd){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}
