package leetcode.medium;

import java.util.Arrays;

public class P_300 {

    public int lengthOfLIS(int[] nums) {
        final int n = nums.length;
        final int[] dp = new int[n];
        int len = 0;
        for (int num : nums) {
            final int idx = lowerBound(dp, num, len);
            if (idx == len) {
                len++;
            }
            dp[idx] = num;
        }
        return len;
    }

    private static int lowerBound(int[] arr, int target, int to) {
        int lo = 0;
        int hi = to;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int lengthOfLISLibrary(int[] nums) {
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

    public static int lengthOfLISBottomUp(int[] nums) {
        final int n = nums.length;
        final int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
