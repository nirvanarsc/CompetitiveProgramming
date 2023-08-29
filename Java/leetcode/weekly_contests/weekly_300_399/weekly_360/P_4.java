package leetcode.weekly_contests.weekly_300_399.weekly_360;

import java.util.List;

public class P_4 {

    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        final int n = receiver.size();
        final long[][] sum = new long[40][n];
        final int[][] next = new int[40][n];
        k++;
        for (int i = 0; i < n; i++) {
            sum[0][i] = i;
            next[0][i] = receiver.get(i);
        }
        for (int i = 1; i < 40; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i - 1][next[i - 1][j]];
                next[i][j] = next[i - 1][next[i - 1][j]];
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            long curr = 0;
            int u = i;
            for (int j = 0; j < 40; j++) {
                if ((k & (1L << j)) != 0) {
                    curr += sum[j][u];
                    u = next[j][u];
                }
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
