import java.util.*;

public class moo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        in.nextLine();
        for(int i = 1; i <= numCases; i++){
            String startingStr = in.nextLine();
            if(startingStr.length() < 3){
                System.out.println("-1");
                continue;
            }
            else if(startingStr.length() == 3){
                if(startingStr.charAt(1) != 'O'){
                    System.out.println("-1");
                    continue;
                }
            }

            System.out.println(solveRecurse(startingStr));

        }
    }
    // To solve, find if there is "MOO" substring
    // If there is, the answer is the number of characters to delete
    // If there isn't, the answer is the number of characters to delete plus the lowest operations needed to form "MOO" substring


    public static int solveRecurse(String curStr){

        int minOperations = -1;
        for(int i = 0; i < curStr.length()-2; i++){
            if(curStr.charAt(i+1) == 'O'){
                int curOperations = 2;
                if(curStr.charAt(i) == 'M'){
                    curOperations--;
                }
                if(curStr.charAt(i+2) == 'O'){
                    curOperations--;
                }
                if(minOperations == -1 || curOperations < minOperations){
                    minOperations = curOperations;
                }
            }
        }

        if(minOperations == -1)
            return minOperations;
        else
            return (minOperations + (curStr.length()-3));

    }

}
