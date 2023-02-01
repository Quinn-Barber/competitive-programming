import java.util.*;

public class knightpacking {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if(N*N % 2 == 0){
            System.out.println("second");
        }
        else{
            System.out.println("first");
        }
    }
}
