package leetcode.weekly_contests.weekly_42;

import java.util.Arrays;

public class P_646 {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        final int[] dp = new int[pairs.length];
        int res = 0;
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
