package leetcode.weekly_contests.weekly_300_399.weekly_302;

import java.util.Arrays;

public class P_3 {

    static class Pair {
        String s;
        int idx;

        Pair(String s, int idx) {
            this.s = s;
            this.idx = idx;
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        final int n = nums.length;
        final int m = nums[0].length();
        final Pair[][] g = new Pair[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = new Pair(nums[j].substring(m - i - 1), j);
            }
        }
        for (int i = 0; i < m; i++) {
            Arrays.sort(g[i], (a, b) -> a.s.equals(b.s) ? Integer.compare(a.idx, b.idx) : a.s.compareTo(b.s));
        }
        final int q = queries.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int k = queries[i][0] - 1;
            final int u = queries[i][1] - 1;
            res[i] = g[u][k].idx;
        }
        return res;
    }
}
