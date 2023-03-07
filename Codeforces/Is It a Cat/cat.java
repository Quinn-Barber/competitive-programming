import java.util.*;

public class cat {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int cases = 1; cases <= numCases; cases++){
            int n = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            int passes = 0;
            boolean meow = true;
            if(str.charAt(0) != 'M' && str.charAt(0) != 'm') meow = false;
            for(int i = 0; i < n; i++){
                if(passes == 0 && (str.charAt(i) != 'M' && str.charAt(i) != 'm')){
                    if(str.charAt(i) != 'e' && str.charAt(i) != 'E'){
                        meow = false;
                        break;
                    }
                    passes++;
                }
                if(passes == 1 && (str.charAt(i) != 'E' && str.charAt(i) != 'e')){
                    if(str.charAt(i) != 'O' && str.charAt(i) != 'o'){
                        meow = false;
                        break;
                    }
                    passes++;
                }
                if(passes == 2 && (str.charAt(i) != 'o' && str.charAt(i) != 'O')){
                    if(str.charAt(i) != 'w' && str.charAt(i) != 'W'){
                        meow = false;
                        break;
                    }
                    passes++;
                }
                if(passes == 3 && (str.charAt(i) != 'w' && str.charAt(i) != 'W')){
                    meow = false;
                    break;
                }
            }
            if(meow && passes >= 3){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}