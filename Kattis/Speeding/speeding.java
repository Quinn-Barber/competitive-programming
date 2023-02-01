import java.util.*;
public class speeding {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[][] = new int[2][2];
        arr[0][0] = input.nextInt();
        arr[0][1] = input.nextInt();
        int max = 0;
        for(int i = 0; i < (n-1); i++){
            arr[1][0] = input.nextInt();
            arr[1][1] = input.nextInt();
            int calc = arr[1][0] - arr[0][0];
            calc = ((arr[1][1]-arr[0][1]) / calc);
            if(calc > max)
                max = calc;
            arr[0][0] = arr[1][0];
            arr[0][1] = arr[1][1];
        }
        System.out.println(max);
    }
}
