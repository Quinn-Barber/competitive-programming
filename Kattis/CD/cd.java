import java.util.*;
import java.io.*;

public class cd {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int m, n;
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        while(m != 0 || n != 0)
        {
            TreeSet<Integer> compare = new TreeSet<>();
            int total = 0;

            for (int i = 0; i < n; i++) {
                compare.add(Integer.parseInt(reader.readLine()));
            }
            for (int i = 0; i < m; i++) {
                if(compare.contains(Integer.parseInt(reader.readLine())))
                {
                    total++;
                }
            }

            System.out.println(total);

            tokenizer = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(tokenizer.nextToken());
            m = Integer.parseInt(tokenizer.nextToken());
        }
    }
}