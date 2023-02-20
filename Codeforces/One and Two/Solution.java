import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int j = 1; j <= numCases; j++){
            boolean neg = true;
            int n = in.nextInt();
            int arr[] = new int[n];
            int numTwosLeft = 0;
            int numTwosRight = 0;
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
                if(arr[i] == 2){
                    numTwosRight++;
                }
            }
            if(numTwosRight == 0){
                System.out.println(1);
                continue;
            }

            for(int i = 0; i < n-1; i++){
                if(arr[i] == 2){
                    numTwosRight--;
                    numTwosLeft++;
                }
                if(numTwosRight == numTwosLeft){
                    System.out.println(i+1);
                    neg = false;
                    break;
                }
            }

            if(neg) System.out.println(-1);
        }
    }
}