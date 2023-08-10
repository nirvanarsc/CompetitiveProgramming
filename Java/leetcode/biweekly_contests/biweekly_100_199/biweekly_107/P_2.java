package leetcode.biweekly_contests.biweekly_100_199.biweekly_107;

public class P_2 {

    static boolean[][][][] seen;
    static int[][][][] dp;

    public int longestString(int x, int y, int z) {
        seen = new boolean[4][x + 1][y + 1][z + 1];
        dp = new int[4][x + 1][y + 1][z + 1];
        return dfs(0, x, y, z);
    }

    private static int dfs(int prev, int x, int y, int z) {
        if (seen[prev][x][y][z]) {
            return dp[prev][x][y][z];
        }
        int res = 0;
        if (prev == 0) {
            if (x > 0) {
                res = Math.max(res, 1 + dfs(1, x - 1, y, z));
            }
            if (y > 0) {
                res = Math.max(res, 1 + dfs(2, x, y - 1, z));
            }
            if (z > 0) {
                res = Math.max(res, 1 + dfs(3, x, y, z - 1));
            }
        } else if (prev == 1) {
            if (y > 0) {
                res = Math.max(res, 1 + dfs(2, x, y - 1, z));
            }
        } else if (prev == 2) {
            if (x > 0) {
                res = Math.max(res, 1 + dfs(1, x - 1, y, z));
            }
            if (z > 0) {
                res = Math.max(res, 1 + dfs(3, x, y, z - 1));
            }
        } else {
            if (x > 0) {
                res = Math.max(res, 1 + dfs(1, x - 1, y, z));
            }
            if (z > 0) {
                res = Math.max(res, 1 + dfs(3, x, y, z - 1));
            }
        }
        seen[prev][x][y][z] = true;
        return dp[prev][x][y][z] = res;
    }
}
