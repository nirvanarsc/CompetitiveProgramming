package binarysearch.weekly_39;

import java.util.Arrays;

public class P_4 {

    public int solve(String s) {
        final int n = s.length();
        final int[][] dp = new int[n][26];
        Arrays.fill(dp[0], -1);
        for (int c = 0; c < 26; c++) {
            final char curr = (char) ('a' + c);
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == curr) {
                    if (curr == 'a') {
                        dp[i][c] = i;
                    } else {
                        dp[i][c] = dp[i][c - 1];
                    }
                } else if (i > 0) {
                    dp[i][c] = dp[i - 1][c];
                }
            }
        }
        int res = (int) 1e9;
        for (int i = 0; i < n; i++) {
            if (dp[i][25] != -1) {
                res = Math.min(res, i - dp[i][25] + 1);
            }
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
