import java.util.*;

public class leaders {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCows = in.nextInt();
        in.nextLine();
        String cows = in.nextLine();
        int startG = -1;
        int endG = -1;
        int startH = -1;
        int endH = -1;

        for(int i = 0; i < cows.length(); i++){
            if(cows.charAt(i) == 'G'){
                if(startG == -1){
                    startG = i;
                }
                if(endG == -1 || endG < i){
                    endG = i;
                }
            }
            else{
                if(startH == -1){
                    startH = i;
                }
                if(endH == -1 || endH < i){
                    endH = i;
                }
            }
        }

        ArrayList<Integer> lbg = new ArrayList<>();
        ArrayList<Integer> lbh = new ArrayList<>();

        int[] cur = new int[numCows];
        for(int i = 0; i < numCows; i++){
            cur[i] = in.nextInt() - 1;
            if(cows.charAt(i) == 'G'){
                if(i <= startG && cur[i] >= endG){
                    lbg.add(i);
                }
            }
            else{
                if(i <= startH && cur[i] >= endH){
                    lbh.add(i);
                }
            }
        }

        int result = lbg.size() * lbh.size();

        for(int i = 0; i < numCows; i++){
            ArrayList<Integer> leaders;
            if(cows.charAt(i) == 'G'){
                leaders = lbh;
            }
            else{
                leaders = lbg;
            }
            for(int j = 0; j < leaders.size(); j++){
                int curL = leaders.get(j);
                if(curL != i){
                    if(curL > i && curL <= cur[i]){
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
