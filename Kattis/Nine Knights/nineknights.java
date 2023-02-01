import java.util.*;
public class nineknights {
    public static char[][] board;
    public static int[] DX = {-2, -1, -2, -1, 2, 1, 2, 1};
    public static int[] DY = {1, 2, -1, -2, 1, 2, -1, -2};
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        board = new char[5][5];
        for(int i = 0; i < 5; i++){
            board[i] = input.next().toCharArray();
        }
        int knightcount = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(board[i][j] == 'k') {
                    knightcount++;
                    if (!valid(i, j)) {
                        System.out.println("invalid");
                        return;
                    }
                }
            }
        }
        if(knightcount != 9){
            System.out.println("invalid");
            return;
        }
        System.out.println("valid");
    }

    public static boolean valid(int i, int j){

        for(int h = 0; h < DX.length; h++){
            if(!inbounds(i+DX[h], j+DY[h])) continue;
            if(board[i+DX[h]][j+DY[h]] == 'k') {
                return false;
            }
        }

        return true;
    }

    public static boolean inbounds(int i, int j){
        if(i >= 5 || i < 0 || j >= 5 || j < 0)
            return false;
        return true;
    }
}
