import java.util.*;

public class sorttwonumbers {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if(a < b){
            System.out.println(a + " " + b);
        }
        else{
            System.out.println(b + " " + a);
        }
    }
}
