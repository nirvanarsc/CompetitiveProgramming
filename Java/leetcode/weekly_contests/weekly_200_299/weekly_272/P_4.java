package leetcode.weekly_contests.weekly_200_299.weekly_272;

public class P_4 {

    public int kIncreasing(int[] arr, int k) {
        final int n = arr.length;
        int res = 0;
        for (int i = 0; i < k; i++) {
            final int m = (n + k - 1 - i) / k;
            final int[] f = new int[m];
            for (int j = i, idx = 0; j < n; j += k, idx++) {
                f[idx] = arr[j];
            }
            res += m - lengthOfLIS(f);
        }
        return res;
    }

    private static int lengthOfLIS(int[] nums) {
        final int[] dp = new int[nums.length];
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
            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
