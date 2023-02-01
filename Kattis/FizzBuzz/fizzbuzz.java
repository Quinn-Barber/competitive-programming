import java.util.*;

public class fizzbuzz {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int n = in.nextInt();

        for(int i = 1; i <= n; i++){
            String fizzbuzz = "";
            if(i % x == 0){
                fizzbuzz += "Fizz";
            }
            if(i % y == 0){
                fizzbuzz += "Buzz";
            }
            if(fizzbuzz.length() == 0){
                System.out.println(i);
            }
            else{
                System.out.println(fizzbuzz);
            }
        }

    }
}
