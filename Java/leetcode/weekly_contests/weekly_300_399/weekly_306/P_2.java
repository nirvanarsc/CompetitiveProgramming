package leetcode.weekly_contests.weekly_300_399.weekly_306;

public class P_2 {

    public int edgeScore(int[] edges) {
        final int n = edges.length;
        final long[] f = new long[n];
        for (int i = 0; i < n; i++) {
            f[edges[i]] += i;
        }
        long max = -1;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (max < f[i]) {
                max = f[i];
                res = i;
            }
        }
        return res;
    }
}
