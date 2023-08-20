package leetcode.biweekly_contests.biweekly_100_199.biweekly_111;

import java.util.List;

public class P_3 {

    public int minimumOperations(List<Integer> nums) {
        return nums.size() - lengthOfLIS(nums.stream().mapToInt(Integer::intValue).toArray());
    }

    public int lengthOfLIS(int[] nums) {
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

    public int lowerBound(int[] nums, int to, int target) {
        int lo = 0, hi = to;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
