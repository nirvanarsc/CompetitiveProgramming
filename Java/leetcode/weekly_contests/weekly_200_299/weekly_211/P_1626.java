package leetcode.weekly_contests.weekly_200_299.weekly_211;

import java.util.Arrays;

public class P_1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        final int n = scores.length;
        final int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] { ages[i], scores[i] };
        }
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1])
                                                  : Integer.compare(a[0], b[0]));
        final int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = pairs[i][1];
            for (int k = 0; k < i; k++) {
                if (pairs[k][1] <= pairs[i][1]) {
                    dp[i] = Math.max(dp[i], dp[k] + pairs[i][1]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
