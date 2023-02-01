import java.util.*;

public class electricaloutlets {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int j = 1; j <= numCases; j++){
            int numStrips = in.nextInt();
            int sum = 0;
            for(int i = 0; i < numStrips; i++){
                int o = in.nextInt();
                if(i == numStrips-1){
                    sum += o;
                }
                else{
                    sum += (o-1);
                }
            }
            System.out.println(sum);
        }
    }
}
