package leetcode.biweekly_contests.biweekly_11;

import java.util.Arrays;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_1231 {

    public int maximizeSweetness(int[] sweetness, int K) {
        int lo = 0;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (!f(sweetness, mid, K + 1)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo + 1;
    }

    private static boolean f(int[] arr, int mid, int k) {
        int cuts = 1;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum > mid) {
                cuts++;
                sum = 0;
            }
        }
        return cuts <= k;
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int count = 0;
                int max = 0;
                if (nums[j] < nums[i]) {
                    if (max < 1 + dp[j][0]) {
                        max = 1 + dp[j][0];
                        count = 1;
                    } else if (max == 1 + dp[j][0]) {
                        count++;
                    }
                }
                dp[j][0] = max;
                dp[j][1] = count;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return 5;
    }

}
