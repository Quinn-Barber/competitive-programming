/*
Quinn Barber
Dance Recital
February 15th, 2022
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dancerecital {
    // Declare global variables here
    // min set to -1 to check if a value has been set yet later
    public static int n, min = -1;
    // 2D array for the quick changes required between two recitals at element i & j
    public static int[][] change;
    // recitals that are in input
    public static String[] recitals;

    public static void main(String[] args) throws IOException {
        // BufferedReader and StringTokenizer for faster input than Scanner
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        // Get number of recitals 2 <= n <= 10
        n = Integer.parseInt(tokenizer.nextToken());

        // Initialize recitals to scan
        recitals = new String[n];

        // Scan for recitals
        for(int i = 0; i < n; i++) {
            recitals[i] = reader.readLine();
        }

        // Calculate the quick changes required for every pair possible
        ComputeChanges();
        // Solve with permutations
        solve(0, new int[n], new boolean[n]);
        // Print minimum value found
        System.out.println(min);
    }

    public static void solve(int k, int[] perm, boolean[] used)
    {
        // If min is 0, skip as there is no lower possibility
        if(min == 0)
            return;
        // If at the end of permutation, check to see if # of quick changes is lower than min
        if (k == n) {
            checkValue(perm);
            return;
        }
        // Start from 0 and loop till highest element number of recitals
        for(int i=0; i<n; i++) {
            // If it is already used it doesn't go through
            if( !used[i] ) {
                // Two cases : either try it (set used to true and perm to current position)
                used[i] = true;
                perm[k] = i;

                // Recursion to next data point
                solve(k+1, perm, used);

                // Or don't (set used to false; the current position
                // in perm will change so no need to update it)
                used[i] = false;
            }
        }
        return;
    }

    public static void ComputeChanges()
    {
        // Initialize change variable
        change = new int[n][n];
        // Loop so that no duplicates are found ( [i][j] == [j][i] )
        for (int i = 0; i < (n-1); i++) {
            for(int j = (i+1); j < n; j++) {
                // Set value of quick changes to 0
                int value = 0;
                // Find characters that are shared in both recitals to add to the # of quick changes (i.e. value)
                for(int h = 0; h < recitals[i].length(); h++) {
                    if(recitals[j].contains("" + recitals[i].charAt(h)))
                        value++;
                }
                // Set to both [i][j] and [j][i] so that if a permutation has it in either order it is stored
                change[i][j] = value;
                change[j][i] = value;
            }
        }

    }

    public static void checkValue(int[] perm)
    {
        // Initialize quick changes found to 0
        int val = 0;
        // Loop through each pair, which is until (n-1) as n would be a singular point in the array
        for(int i = 0; i < (n-1); i++){
            // Add from saved quick change values calculated before permutation
            val += change[perm[i]][perm[i+1]];
        }
        // If min isn't set or quick changes in this permutation is less than min, change it
        if(min == -1 || val < min)
            min = val;
    }

}
