import java.util.*;

public class dora {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int j = 1; j <= numCases; j++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            int l = 0;
            int r = n-1;
            int min = 1;
            int max = n;
            while(arr[l] == min || arr[l] == max || arr[r] == min || arr[r] == max){
                if(arr[l] == min){
                    l++;
                    min++;
                }
                else if(arr[l] == max){
                    l++;
                    max--;
                }
                else if(arr[r] == min){
                    r--;
                    min++;
                }
                else if(arr[r] == max){
                    r--;
                    max--;
                }
                if(l >= r) break;
            }
            if(l >= r){
                System.out.println(-1);
            }
            else{
                System.out.println((l+1) + " " + (r+1));
            }
        }
    }
}