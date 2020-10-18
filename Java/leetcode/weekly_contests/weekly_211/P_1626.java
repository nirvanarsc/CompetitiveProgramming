package leetcode.weekly_contests.weekly_211;

import java.util.Arrays;

public class P_1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        final int[][] pairs = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            pairs[i] = new int[] { ages[i], scores[i] };
        }
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1])
                                                  : Integer.compare(a[0], b[0]));
        final int[] dp = new int[scores.length + 1];
        int res = 0;
        for (int i = 1; i <= scores.length; i++) {
            dp[i] = pairs[i - 1][1];
            for (int k = 1; k < i; k++) {
                if (pairs[i - 1][1] >= pairs[k - 1][1]) {
                    dp[i] = Math.max(dp[i], dp[k] + pairs[i - 1][1]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
