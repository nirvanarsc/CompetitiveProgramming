package leetcode.weekly_contests.weekly_300_399.weekly_366;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_3 {

    public int minOperations(String s1, String s2, int x) {
        final List<Integer> diffs = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffs.add(i);
            }
        }
        final int n = diffs.size();
        if (n % 2 != 0) {
            return -1;
        }
        final double[] dp = new double[n + 1];
        Arrays.fill(dp, 1e9);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + x * 0.5);
            if ((i + 2) <= n) {
                dp[i + 2] = Math.min(dp[i + 2], dp[i] + diffs.get(i + 1) - diffs.get(i));
            }
        }
        return (int) dp[n];
    }
}
