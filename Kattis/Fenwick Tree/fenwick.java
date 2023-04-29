import java.io.PrintWriter;
import java.util.*;
import java.io.*;

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}

public class fenwick {

    private long[] tree;
    private int n;

    public fenwick(int n) {
        this.tree = new long[n + 1];
        this.n = n;
    }

    public long query(int index) {
        index--;
        if (index == -1) {
            return 0;
        }
        long sum = tree[0];
        while (index > 0) {
            sum += tree[index];
            index -= (index & -index);
        }
        return sum;
    }

    public void update(int index, long delta) {
        if (index == 0) {
            tree[0] += delta;
        } else {
            while (index <= n) {
                tree[index] += delta;
                index += (index & -index);
            }
        }
    }

    public static void main(String[] args) {

        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt();
        int q = io.getInt();

        fenwick fenwick = new fenwick(n);

        for (int i = 0; i < q; i++) {
            char op = io.getWord().charAt(0);
            int index = io.getInt();

            switch (op) {
                case '+':
                    long delta = io.getLong();
                    fenwick.update(index, delta);
                    break;
                case '?':
                    io.println(fenwick.query(index));
                    break;
                default:
                    System.exit(-1);
                    break;
            }
        }

        io.close();

    }
}