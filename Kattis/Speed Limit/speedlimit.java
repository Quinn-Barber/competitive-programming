import java.util.*;

public class speedlimit {

    public static ArrayList<int[]> map;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        while(numCases != -1){

            int prevHr = 0;
            int sum = 0;
            for(int i = 0; i < numCases; i++){
                int mph = input.nextInt();
                int curHr = input.nextInt();
                sum += (mph * (curHr - prevHr));
                prevHr = curHr;
            }

            System.out.println(sum + " miles");

            numCases = input.nextInt();

        }


    }
}
