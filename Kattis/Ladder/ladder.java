import java.io.*;
import java.util.*;

public class ladder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double h, v;
        h = in.nextDouble();
        v = in.nextDouble();
        double sine = Math.sin(Math.toRadians(v));
        double check = h/sine;
        int ans = (int)Math.ceil(check);
        System.out.println(ans);
    }


}
