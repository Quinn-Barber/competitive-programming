import java.util.*;

public class tarifa {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int n = in.nextInt();
        int meg = (n+1) * x;
        for(int j = 1; j <= n; j++){
            int p = in.nextInt();
            meg -= p;
        }
        System.out.println(meg);
    }
}
