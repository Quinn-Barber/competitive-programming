import java.io.*;
import java.util.*;

public class chess {
    static int N;

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        for (int cases = 1; cases <= N; cases++) {
            int n, m;
            n = in.nextInt();
            m = in.nextInt();
            int p, q, k;
            System.out.println("? 1 1");
            k = in.nextInt();
            if(k == 0){
                System.out.println("! 1 1");
            }
            else if(k+1 > m){
                System.out.println("? " + (k+1) + " " + 1);
                p = in.nextInt();
                System.out.println("! " + (k+1) + " " + (1+p));
            }
            else if(k+1 > n){
                System.out.println("? " + 1 + " " + (k+1));
                q = in.nextInt();
                System.out.println("! " + (1+q) + " " + (k+1));
            }
            else{
                System.out.println("? " + (k+1) + " " + 1);
                p = in.nextInt();
                System.out.println("? " + 1 + " " + (k+1));
                q = in.nextInt();
                if(p < k){
                    System.out.println("! " + (k+1) + " " + (1+p));
                }
                else{
                    System.out.println("! " + (1+q) + " " + (k+1));
                }
            }
            System.out.flush();
        }
    }
}
