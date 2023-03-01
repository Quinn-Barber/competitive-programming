import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int i = 1; i <= numCases; i++){
            int n = in.nextInt();
            int sticks[] = new int[n];
            for(int j = 0; j < n; j++){
                sticks[j] = in.nextInt();
            }
            Arrays.sort(sticks);
            int minChanged = -1;
            for(int j = 2; j < sticks.length; j++){
                int curMin = 0;
                int a,b,c;
                a = sticks[j-2];
                b = sticks[j-1];
                c = sticks[j];
                curMin += b-a;
                curMin += c-b;
                if(minChanged == -1){
                    minChanged = curMin;
                }
                else if(curMin < minChanged){
                    minChanged = curMin;
                }
            }
            System.out.println(minChanged);
        }
    }
}