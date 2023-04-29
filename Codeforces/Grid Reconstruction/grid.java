import java.io.*;
import java.util.*;

public class grid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int num = in.nextInt();
            int prtHE = num+2;
            int prtHO = num*2 - 1;
            int prtLE = 2;
            int prtLO = 1;
            for(int j = 0; j < 2; j++){
                boolean odd = true;
                boolean high = true;
                if(j == 1) {
                    odd = false;
                    high = false;
                }
                for(int h = 0; h < num; h++){
                    if(odd){
                        if(high){
                            System.out.print(prtHO + " ");
                            prtHO -= 2;
                        }
                        else{
                            System.out.print(prtLO + " ");
                            prtLO += 2;
                        }
                    }
                    else{
                        if(high){
                            System.out.print(prtHE + " ");
                            prtHE += 2;
                        }
                        else{
                            System.out.print(prtLE + " ");
                            prtLE += 2;
                        }
                    }
                    high = !high;
                }
                System.out.println();
            }
        }
    }
}
