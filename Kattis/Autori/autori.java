import java.util.*;

public class autori {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String out = "" + str.charAt(0);
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == '-'){
                out += str.charAt(i+1);
                i++;
            }
        }
        System.out.println(out);
    }
}
