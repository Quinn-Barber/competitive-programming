import java.util.*;

public class lameking {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int cases = 1; cases <= numCases; cases++){
            int a = in.nextInt();
            int b = in.nextInt();
            a = Math.abs(a);
            b = Math.abs(b);
            int min = Math.min(a, b);
            a -= min;
            b -= min;
            int seconds = min*2;
            if(a > 0){
                seconds += a * 2 - 1;
            }
            if(b > 0){
                seconds += b * 2 - 1;
            }
            System.out.println(seconds);

        }
    }


}
