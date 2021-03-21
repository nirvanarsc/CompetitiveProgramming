package leetcode.weekly_contests.weekly_233;

public class P_1802 {

    public int maxValue(int n, int index, int maxSum) {
        int lo = 1;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            int actualL = 0;
            long l = ((long) mid * (mid + 1)) / 2;
            actualL += mid;
            long diff = Math.max(0, mid - (index + 1));
            actualL -= diff;
            l -= (diff * (diff + 1)) / 2;
            long r = ((long) mid * (mid + 1)) / 2;
            actualL += mid;
            diff = Math.max(0, mid - (n - index));
            actualL -= diff;
            r -= (diff * (diff + 1)) / 2;
            r -= mid;
            actualL -= 1;
            if (l + r + (n - actualL) > maxSum) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
