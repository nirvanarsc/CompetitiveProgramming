package leetcode.weekly_contests.weekly_12;

public class P_474 {

    public int findMaxForm(String[] strs, int m, int n) {
        final int[][] count = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int currZero = 0;
            int currOne = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    currZero++;
                } else {
                    currOne++;
                }
            }
            count[i][0] = currZero;
            count[i][1] = currOne;
        }
        return dfs(count, 0, m, n, new Integer[count.length][m + 1][n + 1]);
    }

    private static int dfs(int[][] count, int i, int zeroes, int ones, Integer[][][] dp) {
        if (i == count.length) {
            return 0;
        }
        if (dp[i][zeroes][ones] != null) {
            return dp[i][zeroes][ones];
        }
        int take = 0;
        if (count[i][0] <= zeroes && count[i][1] <= ones) {
            take = 1 + dfs(count, i + 1, zeroes - count[i][0], ones - count[i][1], dp);
        }
        final int skip = dfs(count, i + 1, zeroes, ones, dp);
        return dp[i][zeroes][ones] = Math.max(take, skip);
    }
}
