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

    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            curr = Math.max(nums[i], curr + nums[i]);
            res = Math.max(res, curr);
        }
        return res;
    }

    public int maxSubArrayRecursive(int[] nums) {
        return recurse(nums, 0, new int[] { Integer.MIN_VALUE, 0 })[0];
    }

    public int[] recurse(int[] nums, int pos, int[] pair) {
        if (pos == nums.length - 1) {
            pair[1] = nums[pos];
            pair[0] = Math.max(pair[0], pair[1]);
            return pair;
        }
        pair[1] = Math.max(nums[pos], nums[pos] + recurse(nums, pos + 1, pair)[1]);
        pair[0] = Math.max(pair[0], pair[1]);
        return pair;
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
