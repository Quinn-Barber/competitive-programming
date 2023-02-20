import java.util.*;

public class ideal {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int j = 1; j <= numCases; j++){

            int n, k;
            n = in.nextInt();
            k = in.nextInt();

            ArrayList<Integer> containsK = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                int l, r;
                l = in.nextInt();
                r = in.nextInt();

                if (l <= k && k <= r) {
                    for (int h = 1; h < l; h++) {
                        if (containsK.contains(h)) {
                            containsK.remove(Integer.valueOf(h));
                        }
                    }
                    for (int h = r + 1; h < 51; h++) {
                        if (containsK.contains(h)) {
                            containsK.remove(Integer.valueOf(h));
                        }
                    }
                    if(containsK.size() == 0){
                        for (int h = l; h <= r; h++) {
                            containsK.add(h);
                        }
                    }
                }
            }


            if(containsK.size() != 1){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }

        }
    }
}