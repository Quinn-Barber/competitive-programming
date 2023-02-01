class Solution {
    int dp[][];

    public int maximumScore(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        dp = new int[m][m]; // because left index > m will never be in use
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return f(0, 0, a, b);
    }

    int f(int l, int idx, int a[], int b[]) {
        if (idx == b.length) {
            return 0;
        }
        if (dp[l][idx] != Integer.MAX_VALUE)
            return dp[l][idx];
        int r = a.length - (idx - l) - 1; // calculate right index based on current b idx and left index of a
        if (l == r) {
            return a[l] * b[idx];
        }
        int x = f(l + 1, idx + 1, a, b) + a[l] * b[idx];
        int y = f(l, idx + 1, a, b) + a[r] * b[idx];
        return dp[l][idx] = Math.max(x, y);
    }
}