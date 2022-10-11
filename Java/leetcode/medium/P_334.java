package leetcode.medium;

import java.util.Arrays;

public class P_334 {

    public boolean increasingTriplet(int[] nums) {
        final int n = nums.length;
        final int[] l = new int[n + 1];
        final int[] r = new int[n + 1];
        l[0] = Integer.MAX_VALUE;
        r[n] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            l[i] = Math.min(l[i - 1], nums[i - 1]);
        }
        for (int i = n - 1; i >= 0; i--) {
            r[i] = Math.max(r[i + 1], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (l[i + 1] < nums[i] && nums[i] < r[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTripletLIS(int[] nums) {
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
}
