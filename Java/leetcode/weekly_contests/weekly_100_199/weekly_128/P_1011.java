package leetcode.weekly_contests.weekly_100_199.weekly_128;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_1011 {

    public int shipWithinDays(int[] weights, int D) {
        int lo = 0, hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (!f(weights, mid, D)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static boolean f(int[] weights, int mid, int D) {
        int curr = 0;
        int days = 0;
        for (int w : weights) {
            if (w > mid) {
                return false;
            }
            if (curr + w > mid) {
                curr = w;
                days++;
            } else {
                curr += w;
            }
        }
        if (curr > 0) {
            days++;
        }
        return days <= D;
    }
}
