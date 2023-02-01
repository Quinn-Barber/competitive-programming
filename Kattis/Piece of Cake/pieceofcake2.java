import java.util.*;
public class pieceofcake2
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        int a, b, c;
        a = input.nextInt();
        b = input.nextInt();
        if( (a - b) > b ){
            b = (a-b);
        }
        c = input.nextInt();
        if( (a - c) > c){
            c = (a-c);
        }
        System.out.println(b*c*4);
    }
}
