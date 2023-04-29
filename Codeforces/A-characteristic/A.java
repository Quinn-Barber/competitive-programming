import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n, k;
            n = in.nextInt();
            k = in.nextInt();
            int low = n/2;
            int high = n;
            boolean found = false;
            for(int a = low; a <= high; a++){
                int check = a*(a-1)/2;
                int b = n-a;
                check += b*(b-1)/2;
                if(check == k){
                    found = true;
                    System.out.println("YES");
                    for(int j = 0; j < a; j++){
                        System.out.print(1 + " ");
                    }
                    for(int j = 0; j < b; j++){
                        System.out.print(-1 + " ");
                    }
                    System.out.println();
                    break;
                }
            }
            if(!found){
                System.out.println("NO");
            }

        }

    }


}
