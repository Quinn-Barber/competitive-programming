import java.util.*;
public class fyi {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int digits[] = new int[7];
        int i = 0;
        while(n != 0){
            digits[i] = n % 10;
            n /= 10;
            i++;
        }
        if(digits[4] == 5 && digits[5] == 5 && digits[6] == 5)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
