import java.util.*;

public class shatteredcake {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int numCases = in.nextInt();
        int sum = 0;
        for(int j = 1; j <= numCases; j++){
            int wi = in.nextInt();
            int li = in.nextInt();
            sum += (wi*li);
        }
        System.out.println(sum/w);
    }
}
