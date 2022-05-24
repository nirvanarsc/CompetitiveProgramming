package leetcode.weekly_contests.weekly_200_299.weekly_238;

import java.util.Arrays;

public class P_1838 {

    public int maxFrequencyBS(int[] nums, int k) {
        Arrays.sort(nums);
        final int n = nums.length;
        final int[] diff = new int[n];
        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            diff[j] = nums[n - 1] - nums[i];
        }
        final int[] pre = new int[n];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + diff[i];
        }
        int res = 0;
        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            int lo = j;
            int hi = n - 1;
            while (lo < hi) {
                final int mid = lo + hi + 1 >>> 1;
                final int L = mid - j + 1;
                final int currPre = pre[mid] - (j > 0 ? pre[j - 1] : 0);
                final int cost = currPre - (L * diff[j]);
                if (cost > k) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }
            res = Math.max(res, lo - j + 1);
        }
        return res;
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int j = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum + k < (long) nums[i] * (i - j + 1)) {
                sum -= nums[j++];
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
