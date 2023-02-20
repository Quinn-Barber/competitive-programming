import java.util.*;

public class blocks {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int j = 1; j <= numCases; j++){
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            String firstTower = in.nextLine();
            String secondTower = in.nextLine();
            boolean possible = true;

            boolean lastBlue = true;
            int twoInARowCount = 0;

            for(int i = 0; i < n; i++){
                if(i == 0){
                    lastBlue = firstTower.charAt(i) == 'B' ? true : false;
                    continue;
                }
                if(firstTower.charAt(i) == 'B'){
                    if(lastBlue){
                        twoInARowCount++;
                    }
                    lastBlue = true;
                }
                else{
                    if(!lastBlue){
                        twoInARowCount++;
                    }
                    lastBlue = false;
                }
            }


            for(int i = 0; i < m; i++){
                if(i == 0){
                    lastBlue = secondTower.charAt(i) == 'B' ? true : false;
                    continue;
                }
                if(secondTower.charAt(i) == 'B'){
                    if(lastBlue){
                        twoInARowCount++;
                    }
                    lastBlue = true;
                }
                else{
                    if(!lastBlue){
                        twoInARowCount++;
                    }
                    lastBlue = false;
                }
            }


            if(twoInARowCount >= 2){
                possible = false;
            }
            else if(twoInARowCount == 1){
                if(firstTower.charAt(n-1) == secondTower.charAt(m-1))
                    possible = false;
            }


            if(possible){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}