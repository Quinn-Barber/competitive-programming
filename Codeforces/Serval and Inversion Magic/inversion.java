import java.sql.SQLOutput;
import java.util.*;

public class inversion {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int cases = 1; cases <= numCases; cases++){
            int n = in.nextInt();
            StringBuilder sb = new StringBuilder();
            in.nextLine();
            sb.append(in.nextLine());
            if(isPalindrome(sb.toString())){
                System.out.println("Yes");
                continue;
            }
            boolean mult = false;
            boolean single = false;
            boolean cur = false;
            int j = sb.length()/2 + 1;
            int i = sb.length()/2;
            if(sb.length()%2 == 1){
                i--;
            }
            else{
                i--;
                j--;
            }
            for(i = i; i >= 0; i--){
                if(sb.charAt(i) != sb.charAt(j)){
                    if(cur == false && single == true){
                        mult = true;
                        break;
                    }
                    single = true;
                    cur = true;
                }
                else{
                    cur = false;
                }
                j++;
            }
            if(mult)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
    }

    public static boolean isPalindrome(String str){
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }
}