import java.io.*;
import java.util.*;

public class mary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int a, b;
            a = in.nextInt();
            b = in.nextInt();
            int num = (int)gcd(a, b);
            if(num != 1){
                System.out.println(2);
                System.out.println((a-1) + " " + num);
                System.out.println(a + " " + b);
            }
            else{
                System.out.println(1);
                System.out.println(a + " " + b);
            }
        }
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
