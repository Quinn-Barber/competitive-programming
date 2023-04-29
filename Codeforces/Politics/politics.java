import java.io.*;
import java.util.*;

public class politics {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n, k;
            n = in.nextInt();
            k = in.nextInt();
            in.nextLine();

            int agree[][] = new int[n][k];
            for(int i = 0; i < n; i++){
                String str = in.nextLine();
                for(int j = 0; j < k; j++){
                    if(str.charAt(j) == '+'){
                        agree[i][j]++;
                    }
                    else{
                        agree[i][j]--;
                    }
                }
            }

            boolean count[] = new boolean[n];
            Arrays.fill(count, true);
            for(int i = 0; i < k; i++){
                int stay = 0;
                for(int j = 0; j < n; j++){
                    if(j == 0){
                        stay = agree[j][i];
                        continue;
                    }
                    if(agree[j][i] != stay){
                        count[j] = false;
                    }
                }
            }

            int ans = 0;
            for(int i = 0; i < n; i++){
                if(count[i]) ans++;
            }
            System.out.println(ans);



        }
    }


}
