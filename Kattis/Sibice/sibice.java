import java.util.*;

public class sibice {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        int h = in.nextInt();
        double fits = Math.sqrt(w*w + h*h);
        for(int i = 0; i < n; i++){
            int a = in.nextInt();
            if(a <= fits){
                System.out.println("DA");
            }
            else{
                System.out.println("NE");
            }
        }
    }
}
