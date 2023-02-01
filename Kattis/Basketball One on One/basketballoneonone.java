import java.util.*;
public class basketballoneonone {
    static public void main(String[] args){
        Scanner input = new Scanner(System.in);
        Stack<Character> arr = new Stack<>();
        String given = input.nextLine();

        for(int i = 0; i < given.length(); i++)
            arr.add(given.toCharArray()[i]);
        arr.pop();
        System.out.println(arr.pop());
    }
}
