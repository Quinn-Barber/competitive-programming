import java.util.*;
public class thisaintyourgrandpascheckerboard {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        char arr[][] = new char[n][n];
        for(int i = 0; i < n; i++){
            arr[i] = input.next().toCharArray();
        }
        for(int i = 0; i < n; i++){
            int cntRow = 0;
            int cntCol = 0;
            int lastCol = -1;
            int lastRow = -1;
            int sameCol = 1;
            int sameRow = 1;
            for(int j = 0; j < n; j++){
                if(arr[j][i] == 'W') {
                    if(lastCol == 0) {
                        sameCol++;
                    }
                    else{
                        sameCol = 1;
                    }
                    lastCol = 0;
                    cntCol++;
                }
                else if(arr[j][i] == 'B') {
                    if(lastCol == 1) {
                        sameCol++;
                    }
                    else{
                        sameCol = 1;
                    }
                    lastCol = 1;
                    cntCol--;
                }
                if(arr[i][j] == 'W') {
                    if(lastRow == 0) {
                        sameRow++;
                    }
                    else{
                        sameRow = 1;
                    }
                    lastRow = 0;
                    cntRow++;
                }
                else if(arr[i][j] == 'B') {
                    if(lastRow == 1) {
                        sameRow++;
                    }
                    else{
                        sameRow = 1;
                    }
                    lastRow = 1;
                    cntRow--;
                }
                if(sameRow >= 3 || sameCol >= 3) {
                    System.out.println(0);
                    return;
                }
            }
            if(cntRow != 0 || cntCol != 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);

    }

}
