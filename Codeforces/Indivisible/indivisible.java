import java.io.*;
import java.util.*;

public class indivisible {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            if(n == 1){
                System.out.println(1);
                continue;
            }
            else if(n == 2){
                System.out.println(1 + " " + 2);
                continue;
            }
            if(n % 2 == 1 && n >= 3){
                System.out.println(-1);
            }
            else{
                int maxOdd = n-1;
                int maxEven = n;
                for(int a = 0; a < n; a+=2){
                    System.out.print(maxOdd + " " + maxEven + " ");
                    maxOdd -= 2;
                    maxEven -= 2;
                }
                System.out.println();
            }


        }
    }


}
