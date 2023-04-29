import java.io.*;
import java.util.*;

public class step {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n, k;
            n = in.nextInt();
            k = in.nextInt();
            int arr[] = new int[n];
            int wrong = 0;
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
                if(arr[i]%k != (i+1)%k) wrong++;
            }

            if(wrong == 0){
                System.out.println(0);
            }
            else if(wrong == 2){
                System.out.println(1);
            }
            else{
                System.out.println(-1);
            }
        }
    }


}
