import java.text.DecimalFormat;
import java.util.*;

public class ornaments {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double r, h, s;
        r = in.nextDouble();
        h = in.nextDouble();
        s = in.nextDouble();
        while(h != 0 || r != 0 || s != 0){

            double missingSide = Math.sqrt((h*h) - (r*r));
            double angle = Math.atan(missingSide/r) * (180/Math.PI);
            double arc = 2 * Math.PI * r * ((angle*2)/360);
            double circle = (2 * Math.PI * r) - arc;
            double perim = circle + (missingSide*2);
            perim += perim * (s/100);
            double roundOff = Math.round(perim * 100.0) / 100.0;
            DecimalFormat f = new DecimalFormat("##.00");
            System.out.println(f.format(roundOff));

            r = in.nextDouble();
            h = in.nextDouble();
            s = in.nextDouble();
        }
    }
}