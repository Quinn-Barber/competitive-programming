import java.util.*;

public class digitswap {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.print(num % 10);
        num /= 10;
        System.out.println(num % 10);
    }
}
