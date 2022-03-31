package leetcode.weekly_contests.weekly_7;

public class P_410 {

    public int splitArray(int[] nums, int m) {
        int lo = 0;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (!f(nums, m, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static boolean f(int[] nums, int m, int mid) {
        int sum = 0;
        for (int num : nums) {
            if (num > mid) {
                return false;
            }
            if (sum + num > mid) {
                m--;
                sum = num;
            } else {
                sum += num;
            }
        }
        return m > 0;
    }
}
