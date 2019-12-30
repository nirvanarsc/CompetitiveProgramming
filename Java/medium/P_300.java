package medium;

import java.util.Arrays;

public class P_300 {

    public int lengthOfLIS1(int[] nums) {
        final int[] dp = new int[nums.length];
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
        }
        return len;
    }

    public static int lengthOfLIS2(int[] nums) {
        final int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int lengthOfLIS3(int[] nums) {
        final int[][] memo = new int[nums.length + 1][nums.length];
        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
        return recurse(nums, -1, 0, memo);
    }

    public static int recurse(int[] nums, int previndex, int start, int[][] memo) {
        if (start == nums.length) {
            return 0;
        }
        if (memo[previndex + 1][start] >= 0) {
            return memo[previndex + 1][start];
        }
        int taken = 0;
        if (previndex < 0 || nums[start] > nums[previndex]) {
            taken = 1 + recurse(nums, start, start + 1, memo);
        }

        final int nottaken = recurse(nums, previndex, start + 1, memo);

        return memo[previndex + 1][start] = Math.max(taken, nottaken);
    }
}
