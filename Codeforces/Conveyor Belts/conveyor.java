import java.io.*;
import java.util.*;

public class conveyor {
    static int N;

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        for (int cases = 1; cases <= N; cases++) {
            long n, x1, y1, x2, y2;
            n = in.nextLong();
            x1 = in.nextLong();
            y1 = in.nextLong();
            x2 = in.nextLong();
            y2 = in.nextLong();
            long layer1 = layer(x1, y1, n);
            long layer2 = layer(x2, y2, n);
            if(layer2>layer1){
                System.out.println(layer2-layer1);
            }
            else{
                System.out.println(layer1-layer2);
            }
        }
    }

    public static long layer(long x, long y, long n){
        boolean higherX, higherY;
        higherX = false;
        higherY = false;
        if(x > n/2){
            higherX=true;
        }
        if(y > n/2){
            higherY=true;
        }
        long row = 0;
        if(higherX && higherY){
            row = Math.min((n-x)+1, (n-y)+1);
        }
        else if(higherX){
            row = Math.min((n-x)+1, y);
        }
        else if(higherY){
            row = Math.min(x, (n-y)+1);
        }
        else{
            row = Math.min(x, y);
        }

        return row;
    }
}
