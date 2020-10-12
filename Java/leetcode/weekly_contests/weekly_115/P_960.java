package leetcode.weekly_contests.weekly_115;

import java.util.Arrays;

public class P_960 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int minDeletionSize(String[] A) {
        final int row = A.length;
        final int col = A[0].length();
        int res = col - 1;
        int k;
        final int[] dp = new int[col];
        Arrays.fill(dp, 1);
        for (int i = 0; i < col; ++i) {
            for (int j = 0; j < i; ++j) {
                for (k = 0; k < row; ++k) {
                    if (A[k].charAt(j) > A[k].charAt(i)) {
                        break;
                    }
                }
                if (k == row) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.min(res, col - dp[i]);
        }
        return res;
    }
}
