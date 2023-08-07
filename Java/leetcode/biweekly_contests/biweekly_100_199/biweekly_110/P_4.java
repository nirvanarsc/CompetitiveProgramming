package leetcode.biweekly_contests.biweekly_100_199.biweekly_110;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P_4 {

    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        final int n = nums1.size();
        final int[][] sorted = new int[n][2];
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[] { nums1.get(i), nums2.get(i) };
            l += nums1.get(i);
            r += nums2.get(i);
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[1]));
        final int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + (j + 1) * sorted[i][1] + sorted[i][0]);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (l + i * r - dp[i] <= x) {
                return i;
            }
        }
        return -1;
    }
}
