import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int i = 1; i <= numCases; i++){
            int n = in.nextInt();
            int sum = 0;
            int arr[] = new int[n];
            for(int j = 0; j < n; j++){
                int cur = in.nextInt();
                arr[j] = cur;
                sum += cur;
            }

            boolean foundOne = false;
            boolean foundTwo = false;
            for(int j = 0; j < (n-1); j++){
                if(arr[j] == -1 || arr[j+1] == -1){
                    foundOne = true;
                }
                if(arr[j] == -1 && arr[j+1] == -1){
                    foundTwo = true;
                    break;
                }
            }
            if(!foundOne && !foundTwo){
                sum -= 4;
            }
            else if(foundTwo){
                sum += 4;
            }

            System.out.println(sum);
        }
    }
}