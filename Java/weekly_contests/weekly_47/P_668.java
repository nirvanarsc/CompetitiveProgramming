package weekly_contests.weekly_47;

public class P_668 {

    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m * n;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (count(mid, m, n) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int count(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }
        return count;
    }

    private static int countBS(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int lo = 1;
            int hi = n;
            while (lo <= hi) {
                final int middle = lo + hi >>> 1;
                if (i * middle <= mid) {
                    lo = middle + 1;
                } else {
                    hi = middle - 1;
                }
            }
            count += lo > n ? n : lo - 1;
        }
        return count;
    }
}
