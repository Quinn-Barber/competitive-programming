
/*
Quinn Barber
March 2nd, 2022
 */
import java.util.*;

public class ternarianweights {
    // right pan is intuitive through powers at the end
    public static ArrayList<Long> leftpan;
    public static int[] mod;

    // take in cases and call solve function (weightCalculator)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int i = 1; i <= numCases; i++) {
            long weigh = input.nextLong();
            weightCalculator(weigh);
        }
    }

    public static void weightCalculator(long weight) {
        // initialize variables
        leftpan = new ArrayList<>();
        mod = new int[40];
        int modidx = 0;
        int num = (int) weight;

        // fill array with the modulus of the weight as it is divided down to 0 by 3.
        while (num > 0) {
            mod[modidx] = (num % 3);
            modidx++;
            num /= 3;

        }
        int idx = modidx;

        /*
         * Through the logic in this code, currently any power of 3 in the mod array
         * (mod[i] = 3 ^ i) that isn't a remainder
         * of 0 is going to be in the right pan, to add to the weight. This
         * automatically gives the closest number possible
         * to the number we are looking for. In order to expand this into the number we
         * need, we must use subtractions. We
         * do this by finding remainders of 2, and adding them as subtractions then
         * pushing the remainder to the next
         * available spot. If it is then set to 3, we change it back to 0 as 3 mod 3 is
         * 0. In doing so, it also finds
         * the smallest amount of weights possible used.
         */
        for (int i = 0; i < modidx; i++) {
            if (mod[i] == 2) {
                leftpan.add((long) Math.pow(3, i));
                mod[i] = 0;
                mod[i + 1]++;
                if (i == modidx - 1) {
                    idx++;
                }
            }
            if (mod[i] == 3) {
                mod[i] = 0;
                mod[i + 1]++;
                if (i == modidx - 1) {
                    idx++;
                }
            }
        }

        System.out.print("left pan: ");
        for (int i = leftpan.size() - 1; i >= 0; i--) {
            System.out.print(leftpan.get(i) + " ");
        }
        System.out.println();
        System.out.print("right pan: ");
        for (int i = idx - 1; i >= 0; i--) {
            if (mod[i] != 0)
                System.out.print((long) Math.pow(3, i) + " ");
        }
        System.out.println();

    }

}
