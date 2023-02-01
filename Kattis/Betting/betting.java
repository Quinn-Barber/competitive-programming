import java.util.*;

public class betting {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int ratio = in.nextInt();
        double percent = ratio/100.0;
        System.out.println(1.0/percent);
        System.out.println(1.0/(1-percent));
    }
}
