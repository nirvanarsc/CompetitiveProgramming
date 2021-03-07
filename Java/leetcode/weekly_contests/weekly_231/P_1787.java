package leetcode.weekly_contests.weekly_231;

import java.util.Arrays;

public class P_1787 {

    public int minChangesTopDown(int[] nums, int k) {
        final int[][] dp = new int[k + 1][1 << 10];
        final int[][] freq = new int[k][1 << 10];
        final int[] count = new int[k];
        for (int i = 0; i < nums.length; ++i) {
            freq[i % k][nums[i]]++;
            count[i % k]++;
        }
        Arrays.fill(dp[0], (int) 1e6);
        dp[0][0] = 0;
        for (int i = 0; i < k; i++) {
            int min = (int) 1e6;
            for (int j = 0; j < 1 << 10; j++) {
                min = Math.min(min, dp[i][j]);
            }
            for (int j = 0; j < 1 << 10; j++) {
                dp[i + 1][j] = min + count[i];
            }
            for (int j = 0; j < 1 << 10; j++) {
                for (int j2 = i; j2 < nums.length; j2 += k) {
                    dp[i + 1][j ^ nums[j2]] = Math.min(dp[i + 1][j ^ nums[j2]],
                                                       dp[i][j] + count[i] - freq[i][nums[j2]]);
                }
            }
        }
        return dp[k][0];
    }

    public int minChanges(int[] nums, int k) {
        final int[][] freq = new int[k][1 << 10];
        for (int i = 0; i < k; i++) {
            for (int j = i; j < nums.length; j += k) {
                freq[i][nums[j]]++;
            }
        }
        final int[][] dp = new int[k][(1 << 10) + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(nums, freq, 0, k, 0, dp);
    }

    private static int dfs(int[] nums, int[][] freq, int idx, int k, int xor, int[][] dp) {
        if (idx == k) {
            return (xor == 0 || xor == 1024) ? 0 : (int) 1e9;
        }
        if (dp[idx][xor] != -1) {
            return dp[idx][xor];
        }
        int res = (int) 1e9;
        final int count = (nums.length - idx + k - 1) / k;
        for (int i = idx; i < nums.length; i += k) {
            final int nextXor = xor == 1024 ? 1024 : xor ^ nums[i];
            res = Math.min(res, count - freq[idx][nums[i]] + dfs(nums, freq, idx + 1, k, nextXor, dp));
        }
        res = Math.min(res, count + dfs(nums, freq, idx + 1, k, 1024, dp));
        return dp[idx][xor] = res;
    }
}
