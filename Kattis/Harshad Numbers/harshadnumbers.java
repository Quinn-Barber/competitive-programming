import java.util.*;

public class harshadnumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sumDig;
        n--;
        do{
            n++;
            sumDig = 0;
            int a = n;
            while(a != 0){
                sumDig += a % 10;
                a /= 10;
            }
        }while( n % sumDig != 0);
        System.out.println(n);

    }
}
