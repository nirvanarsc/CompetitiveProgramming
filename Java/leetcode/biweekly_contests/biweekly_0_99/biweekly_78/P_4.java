package leetcode.biweekly_contests.biweekly_0_99.biweekly_78;

import java.util.Arrays;

public class P_4 {

    static int n;
    static int[][] dp;
    static char[] w;

    public int largestVariance(String s) {
        n = s.length();
        w = s.toCharArray();
        dp = new int[n + 1][4];
        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                res = Math.max(res, maxSubArray(i, j));
                res = Math.max(res, maxSubArray(j, i));
            }
        }
        return res;
    }

    public int maxSubArray(int l, int r) {
        for (int[] row : dp) {
            Arrays.fill(row, (int) -1e9);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int status = 0; status < 4; status++) {
                if (dp[i][status] == (int) -1e9) {
                    continue;
                }
                int u = 0;
                if (w[i] - 'a' == l) { u = 1; }
                if (w[i] - 'a' == r) { u = -1; }
                if (status == 0) {
                    int mask = 1;
                    if (u == -1) {
                        mask = 3;
                    }
                    dp[i + 1][mask] = Math.max(dp[i + 1][mask], dp[i][0] + u);
                    dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][0]);
                } else if (status == 1 || status == 3) {
                    if (u == -1) {
                        dp[i + 1][3] = Math.max(dp[i + 1][3], dp[i][status] + u);
                    } else {
                        dp[i + 1][status] = Math.max(dp[i + 1][status], dp[i][status] + u);
                    }
                }
                if (status == 3) {
                    dp[i + 1][2] = Math.max(dp[i + 1][2], dp[i][3]);
                }
                dp[i + 1][2] = Math.max(dp[i + 1][2], dp[i][2]);
            }
        }
        return Math.max(dp[n][2], dp[n][3]);
    }
}
