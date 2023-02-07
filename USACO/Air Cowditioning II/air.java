import java.util.*;

public class air {
    public static int min = -1;
    public static int[] coolBy;
    public static int[] a;
    public static int[] b;
    public static int[] p;
    public static int[] m;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCows = in.nextInt();
        int numAC = in.nextInt();

        coolBy = new int[100];

        for(int i = 0; i < numCows; i++){
            // Cow occupies stall s to stall t
            // Ex: s = 1, t = 100, cow occupies 1-100
            int s = in.nextInt() - 1;
            int t = in.nextInt() - 1;

            // Cooling required in the stalls occupied
            // Ex: c = 10, 10 units of cooling needed in stalls 1-100
            int c = in.nextInt();

            // Fill this in the array
            for(int j = s; j <= t; j++){
                coolBy[j] = c;
            }
        }

        a = new int[numAC];
        b = new int[numAC];
        p = new int[numAC];
        m = new int[numAC];
        for(int i = 0; i < numAC; i++){
            // Cools range of stalls from stall a to stall b
            // Ex: a = 1, b = 100, cools from 1-100
            a[i] = in.nextInt() - 1;
            b[i] = in.nextInt() - 1;
            // How many units this AC cools its range
            // Ex: p = 10, cools 10 units from stalls 1-100
            p[i] = in.nextInt();
            // The money required to operate
            m[i] = in.nextInt();
        }

        perm(new boolean[numAC]);
        System.out.println(min);

    }

    public static void perm(boolean[] perm){
        checkPerm(perm);

        boolean through = false;

        for(int i = 0; i < perm.length; i++){
            if(!perm[i]){
                perm[i] = true;
                through = true;
                break;
            }
            else{
                perm[i] = false;
            }
        }

        if(through)
            perm(perm);

    }

    public static void checkPerm(boolean[] perm){

        int[] coolByCopy = new int[100];
        System.arraycopy(coolBy, 0, coolByCopy, 0, 100);

        int money = 0;
        for(int i = 0; i < perm.length; i++){
            if(perm[i]){
                money += m[i];
                for(int j = a[i]; j <= b[i]; j++){
                    coolByCopy[j] -= p[i];
                }
            }
        }

        boolean works = true;
        for(int i = 0; i < 100; i++){
            if(coolByCopy[i] > 0){
                works = false;
                break;
            }
        }

        if(works){
            if(min == -1 || money < min){
                min = money;
            }
        }

    }




}
