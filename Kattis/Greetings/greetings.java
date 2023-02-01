import java.util.*;

public class greetings {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String hey = in.nextLine();
        System.out.print("h");
        for(int i = 0; i < (hey.length()-2)*2; i++){
            System.out.print("e");
        }
        System.out.print("y");
    }
}
