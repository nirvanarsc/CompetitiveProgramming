package leetcode.medium;

import java.util.Arrays;

public class P_334 {

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean increasingTripletBinarySearch(int[] nums) {
        final int[] dp = new int[3];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
            if (len == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTripletMemory(int[] nums) {
        final int n = nums.length;
        final int[] min = new int[n];
        final int[] max = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            final int prev = i == 0 ? Integer.MAX_VALUE : min[i - 1];
            min[i] = Math.min(min[i], Math.min(nums[i], prev));
        }
        for (int i = n - 1; i >= 0; i--) {
            final int prev = i == n - 1 ? Integer.MIN_VALUE : max[i + 1];
            max[i] = Math.max(max[i], Math.max(nums[i], prev));
        }
        for (int i = 0; i < n; i++) {
            if (min[i] < nums[i] && nums[i] < max[i]) {
                return true;
            }
        }
        return false;
    }
}
