package weekly_contests.weekly_128;

public class P_1011 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int shipWithinDays(int[] weights, int D) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }
        int lo = max;
        int hi = sum;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (helper(weights, mid) >= D) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int helper(int[] weights, int mid) {
        int curr = 0;
        int res = 0;
        for (int w : weights) {
            if (curr + w > mid) {
                curr = 0;
                res++;
            }
            curr += w;
        }
        return res;
    }
}
