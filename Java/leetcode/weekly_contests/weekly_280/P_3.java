package leetcode.weekly_contests.weekly_280;

public class P_3 {

    public long minimumRemoval(int[] beans) {
        final int m = (int) (1e5 + 5);
        final int n = beans.length;
        final int[] f = new int[m];
        long sum = 0;
        for (int num : beans) {
            sum += num;
            f[num]++;
        }
        final long[] hi = new long[m];
        final long[] lo = new long[m];
        final long[] c = new long[m];
        hi[0] = sum;
        lo[0] = 0;
        c[0] = n;
        for (int i = 1; i < m; i++) {
            hi[i] = hi[i - 1] - (long) f[i - 1] * (i - 1);
            lo[i] = lo[i - 1] + (long) f[i - 1] * (i - 1);
            c[i] = c[i - 1] - f[i];
        }
        long res = sum;
        for (int i = 1; i < m - 1; i++) {
            res = Math.min(res, lo[i] + hi[i + 1] - c[i] * i);
        }
        return res;
    }
}
