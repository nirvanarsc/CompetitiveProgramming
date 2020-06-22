package hard;

public class P_174 {

    public int calculateMinimumHP(int[][] dungeon) {
        return dfs(dungeon, 0, 0, new Integer[dungeon.length][dungeon[0].length]);
    }

    private static int dfs(int[][] d, int r, int c, Integer[][] dp) {
        if (r == d.length - 1 && c == d[0].length - 1) {
            return Math.max(1, 1 - d[r][c]);
        }
        if (dp[r][c] != null) {
            return dp[r][c];
        }
        int down = Integer.MAX_VALUE;
        if (r < d.length - 1) {
            down = Math.max(1, dfs(d, r + 1, c, dp) - d[r][c]);
        }
        int right = Integer.MAX_VALUE;
        if (c < d[0].length - 1) {
            right = Math.max(1, dfs(d, r, c + 1, dp) - d[r][c]);
        }
        return dp[r][c] = Math.min(down, right);
    }
}
