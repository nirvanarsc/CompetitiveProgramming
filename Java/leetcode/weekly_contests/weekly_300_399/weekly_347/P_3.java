package leetcode.weekly_contests.weekly_300_399.weekly_347;

import java.util.ArrayList;
import java.util.List;

public class P_3 {

    public long minimumCost(String s) {
        final long[][] pre = f(s);
        final long[][] suff = f(new StringBuilder(s).reverse().toString());
        long res = (long) 9e18;
        final int n = pre.length;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, pre[i][0] + suff[n - i - 1][0]);
            res = Math.min(res, pre[i][1] + suff[n - i - 1][1]);
        }
        return res;
    }

    private static long[][] f(String s) {
        final char[] w = s.toCharArray();
        final List<int[]> leftMost = new ArrayList<>();
        final int m = w.length;
        for (int i = 1; i < m; i++) {
            if (w[i] != w[i - 1]) {
                leftMost.add(new int[] { w[i - 1] - '0', i - 1 });
            }
        }
        leftMost.add(new int[] { w[m - 1] - '0', m - 1 });
        final int[][] g = leftMost.toArray(int[][]::new);
        final int n = g.length;
        final long[][] pre = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                pre[i][j] += pre[i - 1][j];
                if (g[i - 1][0] != j) {
                    pre[i][j] += g[i - 1][1] + 1;
                    if (i > 1) {
                        pre[i][j] += g[i - 2][1] + 1;
                    }
                }
            }
        }
        return pre;
    }
}
