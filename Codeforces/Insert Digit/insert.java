import java.io.*;
import java.util.*;

public class insert {
    static int N;

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        for (int cases = 1; cases <= N; cases++) {
            int a = in.nextInt();
            int b = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder();
            boolean found = false;
            for(int i = 0; i < str.length(); i++){
                if(Character.getNumericValue(str.charAt(i)) < b && !found){
                    sb.append(b);
                    found = true;
                }
                sb.append(str.charAt(i));
            }
            if(!found) sb.append(b);
            System.out.println(sb);
        }
    }


}
