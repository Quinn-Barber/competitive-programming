import java.util.*;

public class lastfactorialdigit {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for(int i = 0; i < numCases; i++){
            int n = input.nextInt();
            int lastDig = 1;

            while(n != 0){
                lastDig *= n;
                if(lastDig > 10) lastDig %= 10;
                n--;
            }

            System.out.println(lastDig);
        }

    }
}
