import java.io.*;
import java.util.*;

public class lucky {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int cases = 1; cases <= N; cases++) {
            st = new StringTokenizer(reader.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int max = l;
            int maxNum = -1;
            for(int i = l; i <= r; i++){
                int copy = i;
                int maxDigit = copy%10;
                int minDigit = copy%10;
                while(copy > 0){
                    int digit = copy%10;
                    copy /= 10;
                    if(digit > maxDigit){
                        maxDigit = digit;
                    }
                    if(digit < minDigit){
                        minDigit = digit;
                    }
                }
                if(maxNum == -1 || maxDigit-minDigit > maxNum){
                    max = i;
                    maxNum = maxDigit-minDigit;
                }
                if(maxNum == 9) break;
            }
            writer.println(max);
        }

        reader.close();
        writer.close();
    }


}
