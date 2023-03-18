package leetcode.biweekly_contests.biweekly_0_99.biweekly_74;

public class P_4 {

    static boolean[][] seen;
    static int[][] dp;
    static int n;
    static int c;
    static int cL;
    static char[] w;

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        w = floor.toCharArray();
        n = w.length;
        c = numCarpets;
        cL = carpetLen;
        seen = new boolean[n][c + 1];
        dp = new int[n][c + 1];
        return dfs(0, c);
    }

    private static int dfs(int idx, int c) {
        if (idx >= w.length) {
            return 0;
        }
        if (seen[idx][c]) {
            return dp[idx][c];
        }
        int res = (int) 1e9;
        if (c > 0) {
            res = Math.min(res, dfs(idx + cL, c - 1));
        }
        res = Math.min(res, w[idx] - '0' + dfs(idx + 1, c));
        seen[idx][c] = true;
        return dp[idx][c] = res;
    }
}
