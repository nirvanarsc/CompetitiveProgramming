package leetcode.weekly_contests.weekly_100_199.weekly_128;

public class P_1011 {

    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (f(weights, mid) > days) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int f(int[] weights, int mid) {
        int curr = 0;
        int res = 0;
        for (int w : weights) {
            if (w > mid) {
                return (int) 1e9;
            }
            curr += w;
            if (curr > mid) {
                curr = w;
                res++;
            }
        }
        return res + (curr > 0 ? 1 : 0);
    }
}
