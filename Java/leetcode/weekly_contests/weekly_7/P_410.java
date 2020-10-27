package leetcode.weekly_contests.weekly_7;

public class P_410 {

    public int splitArray(int[] nums, int m) {
        int lo = 0, hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (!f(nums, mid, m)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static boolean f(int[] nums, int mid, int m) {
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            if (num > mid) {
                return false;
            }
            if (sum + num > mid) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }
        if (sum > 0) {
            count++;
        }
        return count <= m;
    }
}
