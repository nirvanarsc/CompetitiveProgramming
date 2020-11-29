package leetcode.biweekly_contests.biweekly_40;

@SuppressWarnings("ManualArrayCopy")
public class P_1671 {

    public static int lengthOfLIS(int[] nums) {
        final int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            final int i = lowerBound(dp, len, num);
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static int lowerBound(int[] nums, int to, int target) {
        int lo = 0, hi = to;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int minimumMountainRemovals(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            final int[] left = new int[i + 1];
            final int[] right = new int[nums.length - i];
            for (int j = 0; j <= i; j++) {
                left[j] = nums[j];
            }
            for (int j = nums.length - 1, idx = 0; idx < right.length; j--, idx++) {
                right[idx] = nums[j];
            }
            res = Math.max(res, lengthOfLIS(left) + lengthOfLIS(right) - 1);
        }
        return nums.length - res;
    }
}
