package leetcode.weekly_contests.weekly_300_399.weekly_313;

import java.util.Arrays;

public class P_4 {

    // https://cp-algorithms.com/string/z-function.html
    private static int[] zFunction(char[] w) {
        final int n = w.length;
        final int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && w[z[i]] == w[i + z[i]]) {
                ++z[i];
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }

    public int deleteString(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        final int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            final int[] z = zFunction(Arrays.copyOfRange(w, i, n));
            dp[i] = 1;
            for (int j = 1; 2 * j <= z.length; j++) {
                if (z[j] >= j) {
                    dp[i] = Math.max(dp[i], dp[i + j] + 1);
                }
            }
        }
        return dp[0];
    }
}
