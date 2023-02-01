import java.util.*;

public class qaly {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        float sum = 0;
        for(int j = 1; j <= numCases; j++){
            float a = in.nextFloat();
            float b = in.nextFloat();
            sum += a * b;
        }
        System.out.printf("%.3f", sum);
    }
}
