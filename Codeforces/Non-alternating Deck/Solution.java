import java.util.*;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int j = 1; j <= numCases; j++){
            int n = in.nextInt();
            int alice = 1;
            int bob = 0;
            if(n == 1){
                System.out.println(alice + " " + bob);
                continue;
            }
            n--;
            boolean bobTurn = true;
            int numToAdd = 5;
            while(n >= numToAdd){
                if(bobTurn){
                    bob += numToAdd;
                }
                else{
                    alice += numToAdd;
                }
                n -= numToAdd;
                numToAdd += 4;
                bobTurn = !bobTurn;
            }
            if(n > 0){
                if(bobTurn){
                    bob += n;
                }
                else{
                    alice += n;
                }
            }

            System.out.println(alice + " " + bob);
        }
    }
}