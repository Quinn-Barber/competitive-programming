import java.util.*;

public class cab {

    public static int n;
    public static HashSet<Integer>[] graph;
    public static String[] words;

    public static void main(String[] args) {

        // Get basic input.
        Scanner stdin = new Scanner(System.in);
        n = (int)(stdin.next().charAt(0) - 'a' + 1);
        int numWords = stdin.nextInt();

        // Set up array for words and our graph (array of hashsets).
        words = new String[numWords];
        graph = new HashSet[n];
        for (int i=0; i<n; i++)
            graph[i] = new HashSet<Integer>();

        // Read through the words.
        for (int i=0; i<numWords; i++) words[i] = stdin.next();

        boolean possible = true;

        // Look for edges to add.
        for (int i=0; i<numWords-1; i++) {

            boolean flag = false;

            // Looking for the first letter between two adjacent words that doesn't match.
            for (int j=0; j<words[i].length() && j<words[i+1].length(); j++) {

                // Get the two letters as numbers.
                int v1 = (int)(words[i].charAt(j) - 'a');
                int v2 = (int)(words[i+1].charAt(j) - 'a');

                // Add the edge.
                if (v1 != v2) {
                    graph[v1].add(v2);
                    flag = true;
                    break;
                }
            }

            // A tricky case where the prefix comes after the longer word.
            if (!flag && words[i].length() > words[i+1].length()) {
                possible = false;
                break;
            }
        }

        // Screen out the obviously impossible cases.
        if (!possible)
            System.out.println("IMPOSSIBLE");

            // Run our top sort.
        else
            System.out.println(topsort());
    }

    public static String topsort() {

        int[] indegree = new int[n];

        // Update the indegree for each vertex.
        for (int i=0; i<n; i++)
            for (Integer x: graph[i])
                indegree[x]++;

        // Store answer here.
        char[] res = new char[n];
        boolean ambiguous = false;

        // Store all unused items of degree 0.
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i=0; i<n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        // Grab each item, one by one.
        for (int i=0; i<n; i++) {

            // We could grab more than 1 thing...
            if (q.size() > 1) ambiguous = true;

            // We still need something to graph.
            if (q.size() == 0) return "IMPOSSIBLE";

            // Safe to put in my ordering.
            int val = q.pollFirst();
            res[i] = (char)(val+'a');

            // Now that we've done val, subtract 1 from each vertex for which we have an edge from
            // val to x.
            for (Integer x: graph[val]) {
                indegree[x]--;

                // A new item that is now safe to do.
                if (indegree[x] == 0)
                    q.offer(x);
            }

        }

        // If we have made it all the way through, and have an ordering, then there must be more than 1 way to do it
        // if the ambiguous flag is on.
        if (ambiguous) return "AMBIGUOUS";

        // Ta da!
        return new String(res);
    }
}