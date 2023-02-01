import java.util.*;

public class detaileddifferences {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        in.nextLine();
        for(int j = 1; j <= numCases; j++){
            String a = in.nextLine();
            String b = in.nextLine();
            String diff = "";
            for(int i = 0; i < a.length(); i++){
                if(a.charAt(i) != b.charAt(i)){
                    diff += "*";
                }
                else{
                    diff += ".";
                }
            }
            System.out.println(a);
            System.out.println(b);
            System.out.println(diff);
            System.out.println();
        }
    }
}
