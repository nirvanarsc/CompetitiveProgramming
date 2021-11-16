package leetcode.weekly_contests.weekly_47;

public class P_668 {

    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m * n;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (f(m, n, mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int f(int m, int n, int mid) {
        int res = 0;
        for (int i = 1; i <= m; i++) {
            res += Math.min(mid / i, n);
        }
        return res;
    }
}
