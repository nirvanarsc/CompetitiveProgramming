package leetcode.weekly_contests.weekly_200;

import java.util.HashMap;
import java.util.Map;

public class P_1537 {

    public int maxSumGreedy(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final int m = nums2.length;
        int i = 0, j = 0;
        long a = 0, b = 0, res = 0;
        while (i < n || j < m) {
            if (i < n && (j == m || nums1[i] < nums2[j])) {
                a += nums1[i++];
            } else if (j < m && (i == n || nums1[i] > nums2[j])) {
                b += nums2[j++];
            } else {
                res += Math.max(a, b) + nums1[i];
                i++;
                j++;
                a = 0;
                b = 0;
            }
        }
        return (int) ((res + Math.max(a, b)) % MOD);
    }

    private static final int MOD = (int) (1e9 + 7);

    public int maxSum(int[] nums1, int[] nums2) {
        final Map<Integer, Integer> idx1 = new HashMap<>();
        final Map<Integer, Integer> idx2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            idx1.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            idx2.put(nums2[i], i);
        }
        final Long[][] dp = new Long[Math.max(nums1.length, nums2.length)][2];
        return (int) (Math.max(dfs(nums1, nums2, 0, 1, idx1, idx2, dp),
                               dfs(nums1, nums2, 0, 0, idx1, idx2, dp)) % MOD);
    }

    private static long dfs(int[] nums1, int[] nums2, int idx, int left,
                            Map<Integer, Integer> idx1,
                            Map<Integer, Integer> idx2, Long[][] dp) {
        if (idx >= nums1.length && idx >= nums2.length) {
            return 0;
        }
        if (dp[idx][left] != null) {
            return dp[idx][left];
        }
        long res = 0;
        if (left == 0 && idx < nums1.length) {
            res = Math.max(res, nums1[idx] + dfs(nums1, nums2, idx + 1, 0, idx1, idx2, dp));
            if (idx2.containsKey(nums1[idx])) {
                res = Math.max(res, nums1[idx] +
                                    dfs(nums1, nums2, idx2.get(nums1[idx]) + 1, 1, idx1, idx2, dp));
            }
        }
        if (left == 1 && idx < nums2.length) {
            res = Math.max(res, nums2[idx] + dfs(nums1, nums2, idx + 1, 1, idx1, idx2, dp));
            if (idx1.containsKey(nums2[idx])) {
                res = Math.max(res, nums2[idx] +
                                    dfs(nums1, nums2, idx1.get(nums2[idx]) + 1, 0, idx1, idx2, dp));
            }
        }
        return dp[idx][left] = res;
    }
}
