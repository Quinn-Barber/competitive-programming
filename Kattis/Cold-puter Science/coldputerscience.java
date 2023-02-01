import java.util.*;

public class coldputerscience {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        int count = 0;
        for(int j = 1; j <= numCases; j++){
            int temp = in.nextInt();
            if(temp < 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
