import java.util.*;

public class oddecho {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        in.nextLine();
        for(int j = 1; j <= numCases; j++){
            String str = in.nextLine();
            if(j % 2 == 1){
                System.out.println(str);
            }
        }
    }
}
