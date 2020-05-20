package weekly_contests.weekly_7;

public class P_410 {

    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        long lo = max;
        long hi = (long) 1e18;
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            if (helper(nums, mid) <= m) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int) lo;
    }

    private static int helper(int[] nums, long mid) {
        int curr = 0;
        int res = 0;
        for (int w : nums) {
            if (curr + w > mid) {
                curr = 0;
                res++;
            }
            curr += w;
        }
        return res;
    }
}
