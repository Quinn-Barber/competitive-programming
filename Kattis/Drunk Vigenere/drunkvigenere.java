

import java.util.*;

public class drunkvigenere {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String message = input.nextLine();
        String key = input.nextLine();

        char endString[] = new char[message.length()];
        for(int i = 0; i < message.length(); i++){
            int newLetter = 0;
            if(i % 2 == 0) {
                newLetter = ((int) message.toCharArray()[i] - (key.toCharArray()[i] - 'A'));
                if(newLetter < 65) newLetter += 26;
            }
            else{
                newLetter = ((int) message.toCharArray()[i] + (key.toCharArray()[i] - 'A'));
                if(newLetter > 90) newLetter -= 26;
            }

            endString[i] = (char) newLetter;

        }
        for(int i = 0; i < endString.length; i++)
            System.out.print(endString[i]);
        System.out.println();
    }
}
