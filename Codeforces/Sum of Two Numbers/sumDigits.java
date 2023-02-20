import java.util.*;

public class sumDigits {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int j = 1; j <= numCases; j++){
            int n = in.nextInt();
            if(n % 2 == 0){
                System.out.println(n/2 + " " + n/2);
            }
            else{
                int x = n/2;
                int y = (n/2)+1;
                int sumDigX = 0;
                int sumDigY = 0;
                int xCopy = x;
                int yCopy = y;
                while(xCopy > 0){
                    sumDigX += xCopy % 10;
                    xCopy /= 10;
                }
                while(yCopy > 0){
                    sumDigY += yCopy % 10;
                    yCopy /= 10;
                }
                int numDiff = 0;
                int pow = 0;
                if(Math.abs(sumDigX-sumDigY) > 1){
                    while(Math.abs(sumDigX-sumDigY) > 9){
                        numDiff *= 10;
                        pow += 1;
                        numDiff += 9;
                        sumDigX -= 9;
                        sumDigY += 9;
                    }
                    int singleDiff = 1;
                    while(Math.abs(sumDigX-sumDigY) > 1){
                        singleDiff += 1;
                        sumDigX -= 1;
                        sumDigY += 1;
                    }
                    for(int i = 0; i < pow; i++){
                        singleDiff *= 10;
                    }
                    numDiff += (singleDiff);
                }
                System.out.println((y-numDiff) + " " + (x+numDiff));
            }
        }
    }
}