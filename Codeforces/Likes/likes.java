import java.util.*;

public class likes {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int cases = 1; cases <= numCases; cases++){
            int n = in.nextInt();
            int arr[] = new int[n];
            int pos = 0;
            int neg = 0;
            for(int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if(arr[i] < 0){
                    neg++;
                }
                else{
                    pos++;
                }
            }
            int moves = 0;
            int savedPos = pos;
            int savedNeg = neg;
            for(int i = 0; i < n; i++){
                if(pos == 0){
                    moves--;
                }
                else{
                    moves++;
                    pos--;
                }
                System.out.print(moves + " ");
            }
            pos = savedPos;
            neg = savedNeg;
            moves = 0;
            System.out.println();
            for(int i = 0; i < n; i++){
                if(pos > 0 && moves == 0){
                    moves++;
                    pos--;
                }
                else if(pos > 0 && neg <= 0){
                    moves++;
                    pos--;
                }
                else{
                    moves--;
                    neg--;
                }
                System.out.print(moves + " ");
            }
            System.out.println();
        }
    }

    public static long gcd(long a, long b){
        while(b != 0){
            long t = a;
            a = b;
            b = t % b;
        }
        return a;
    }


}
