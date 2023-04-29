import java.io.*;
import java.util.*;

public class array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = in.nextInt();
            }
            if(n == 2){
                if(arr[0] > arr[1]){
                    System.out.println("NO");
                }
                else{
                    System.out.println("YES");
                }
            }
            else{
                if(n % 2 == 1){
                    System.out.println("YES");
                }
                else{
                    long num = 0;
                    for(int j = 0; j < n-1; j+=2){
                        num += arr[j+1]-arr[j];
                    }
                    if(num < 0){
                        System.out.println("NO");
                    }
                    else{
                        System.out.println("YES");
                    }
                }
            }
        }
    }
}
