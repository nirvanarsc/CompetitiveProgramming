package weekly_contests.weekly_128;

import java.util.Arrays;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_1011 {

    public int shipWithinDays(int[] weights, int D) {
        int lo = Arrays.stream(weights).summaryStatistics().getMax(), hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (f(weights, mid, D)) {
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
            if (curr + w > mid) {
                curr = 0;
                days++;
            }
            curr += w;
        }
        return days > D;
    }
}
