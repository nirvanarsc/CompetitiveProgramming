package leetcode.medium;

public class P_1884 {

    static int[][] dp;

    public int twoEggDrop(int n) {
        dp = new int[n + 1][3];
        return dfs(n, 2);
    }

    private static int dfs(int floors, int eggs) {
        if (eggs == 1 || floors <= 1) {
            return floors;
        }
        if (dp[floors][eggs] > 0) {
            return dp[floors][eggs];
        }
        int res = (int) 1e9;
        for (int f = 1; f <= floors; f++) {
            res = Math.min(res, 1 + Math.max(dfs(f - 1, eggs - 1),
                                             dfs(floors - f, eggs)));
        }
        return dp[floors][eggs] = res;
    }
}
