import java.util.*;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int j = 1; j <= numCases; j++){
            boolean valid = true;
            int n, w, h;
            n = in.nextInt();
            w = in.nextInt();
            h = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = in.nextInt();
            }
            int[] b = new int[n];
            for(int i = 0; i < n; i++){
                b[i] = in.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            ArrayList<Integer[]> cakeRange = new ArrayList<>();
            ArrayList<Integer[]> chocRange = new ArrayList<>();

            int moveBy = (a[0]+w)-(b[0]+h);
            int diff = 0;

            // 13 22 29
            // 5 16 25

            // 10-16 19-25 26-32
            // 3-7 14-18 23-27

            // 1-7 10-16 17-23
            // 3-7 14-18 23-27


            for(int i = 0; i < n; i++){
                Integer[] curChoc = new Integer[2];
                curChoc[0] = b[i]-h;
                curChoc[1] = b[i]+h;
                chocRange.add(curChoc);

                Integer[] curCake = new Integer[2];
                curCake[0] = a[i]-w-moveBy;
                curCake[1] = a[i]+w-moveBy;
                cakeRange.add(curCake);

                if(curCake[0] > curChoc[0]){
                    valid = false;
                    break;
                }
                if(curCake[1] < curChoc[1]){
                    if(diff < curChoc[1]-curCake[1]){
                        diff = curChoc[1]-curCake[1];
                    }
                }
            }

            for(int i = 0; i < n; i++){
                if(!valid) break;
                Integer[] curChoc = chocRange.get(i);
                Integer[] curCake = cakeRange.get(i);

                if(curCake[0]+diff > curChoc[0]){
                    valid = false;
                }
            }



            if(valid){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}