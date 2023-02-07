import java.util.*;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int j = 1; j <= numCases; j++){
            int n = in.nextInt();
            int aliceBlack = 0;
            int bobBlack = 0;
            int alicewWhite = 0;
            int bobWhite = 0;
            boolean bobTurn = false;
            boolean whiteFirst = true;
            int whiteToAdd = 1;
            int blackToAdd = 0;
            while(n >= (whiteToAdd+blackToAdd)){
                if(bobTurn){
                    bobWhite += whiteToAdd;
                    bobBlack += blackToAdd;
                }
                else{
                    alicewWhite += whiteToAdd;
                    aliceBlack += blackToAdd;
                }
                n -= whiteToAdd+blackToAdd;
                if(whiteFirst){
                    whiteToAdd++;
                    blackToAdd += 3;
                }
                else{
                    blackToAdd++;
                    whiteToAdd += 3;
                }
                whiteFirst = !whiteFirst;
                bobTurn = !bobTurn;
            }
            // 1 W 0 B
            // 2 W 3 B
            // 5 W 4 B
            // 6 W 7 B
            if(n > 0){
                if(bobTurn){
                    bobWhite += (n/2);
                    bobBlack += (n/2);
                }
                else{
                    alicewWhite += (n/2);
                    aliceBlack += (n/2);
                }
                if(n%2 == 1){
                    if(bobTurn){
                        if(whiteFirst){
                            bobWhite++;
                        }
                        else{
                            bobBlack++;
                        }
                    }
                    else{
                        if(whiteFirst){
                            alicewWhite++;
                        }
                        else{
                            aliceBlack++;
                        }
                    }
                }
            }

            System.out.println(alicewWhite + " " + aliceBlack + " " + bobWhite + " " + bobBlack);
        }
    }
}