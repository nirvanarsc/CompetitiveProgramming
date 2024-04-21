package leetcode.biweekly_contests.biweekly_100_199.biweekly_118;

public class P_4 {

    public int findMaximumLength(int[] nums) {
        final int n = nums.length;
        final long[] pre = new long[n + 1];
        final int[] dp = new int[n + 1];
        final int[] index = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            pre[i] = nums[i - 1] + pre[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            index[i] = Math.max(index[i], index[i - 1]);
            dp[i] = dp[index[i]] + 1;
            final int next = lowerBound(pre, i, 2 * pre[i] - pre[index[i]]);
            index[next] = i;
        }
        return dp[n];
    }

    private static int lowerBound(long[] arr, int from, long target) {
        int lo = from, hi = arr.length;
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
}
