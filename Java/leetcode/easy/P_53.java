package leetcode.easy;

import java.util.Arrays;

public class P_53 {

    public int maxSubArrayEPI(int[] nums) {
        int minSum = 0, sum = 0, maxSum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
            minSum = Math.min(minSum, sum);
            maxSum = Math.max(maxSum, sum - minSum);
        }
        return max < 0 ? max : maxSum;
    }

    public int maxSubArrayKadane(int[] nums) {
        int curr = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            curr = Math.max(nums[i], curr + nums[i]);
            res = Math.max(res, curr);
        }
        return res;
    }

    static int[][] dp;
    static boolean[][] seen;

    public int maxSubArray(int[] nums) {
        final int n = nums.length;
        dp = new int[n][3];
        seen = new boolean[n][3];
        return dfs(nums, 0, 0);
    }

    private static int dfs(int[] nums, int idx, int status) {
        if (idx == nums.length) {
            return status != 0 ? 0 : (int) -1e9;
        }
        if (seen[idx][status]) {
            return dp[idx][status];
        }
        int res = (int) -1e9;
        if (status == 0) {
            res = Math.max(res, dfs(nums, idx + 1, 0));
            res = Math.max(res, nums[idx] + dfs(nums, idx + 1, 1));
        } else if (status == 1) {
            res = Math.max(res, nums[idx] + dfs(nums, idx + 1, 1));
            res = Math.max(res, dfs(nums, idx + 1, 2));
        } else {
            res = Math.max(res, dfs(nums, idx + 1, 2));
        }
        seen[idx][status] = true;
        return dp[idx][status] = res;
    }

    public int maxSubArrayDC(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        final int mid = n - 1 >>> 1;
        int bestLeft = Integer.MIN_VALUE;
        int bestRight = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= 0; i--) {
            sum += nums[i];
            bestLeft = Math.max(bestLeft, sum);
        }
        sum = 0;
        for (int i = mid + 1; i < n; i++) {
            sum += nums[i];
            bestRight = Math.max(bestRight, sum);
        }
        final int left = maxSubArrayDC(Arrays.copyOfRange(nums, 0, mid + 1));
        final int right = maxSubArrayDC(Arrays.copyOfRange(nums, mid + 1, n));
        return Math.max(Math.max(left, right), bestLeft + bestRight);
    }
}
