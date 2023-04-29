import java.io.*;
import java.util.*;

public class li {
    static int N;

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        for (int cases = 1; cases <= N; cases++) {
            int n, m;
            n = in.nextInt();
            m = in.nextInt();
            int x1, y1, x2, y2;
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();
            if(isCorner(x1,y1,n,m) || isCorner(x2,y2,n,m)){
                System.out.println(2);
                continue;
            }
            if(isSide(x1,y1,n,m) || isSide(x2,y2,n,m)){
                System.out.println(3);
                continue;
            }
            System.out.println(4);
        }
    }

    public static boolean isCorner(int x, int y, int n, int m){
        if(x == n && y == m){
            return true;
        }
        if(x == 1 && y == m){
            return true;
        }
        if(x == n && y == 1){
            return true;
        }
        if(x == 1 && y == 1){
            return true;
        }
        return false;
    }

    public static boolean isSide(int x, int y, int n, int m){
        if(x == n || x == 1 || y == m || y == 1) return true;
        return false;
    }


}
