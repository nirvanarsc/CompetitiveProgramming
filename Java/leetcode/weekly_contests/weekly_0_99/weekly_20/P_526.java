package leetcode.weekly_contests.weekly_0_99.weekly_20;

import java.util.stream.IntStream;

public class P_526 {

    public int countArrangement(int n) {
        final int[] nums = IntStream.rangeClosed(1, n).toArray();
        final int[] res = { 0 };
        permute(nums, nums.length - 1, res);
        return res[0];
    }

    private void permute(int[] arr, int idx, int[] res) {
        if (idx == 0) {
            res[0]++;
        }
        for (int i = idx; i >= 0; i--) {
            swap(arr, idx, i);
            if (arr[idx] % (idx + 1) == 0 || (idx + 1) % arr[idx] == 0) {
                permute(arr, idx - 1, res);
            }
            swap(arr, idx, i);
        }
    }

    public void swap(int[] nums, int x, int y) {
        final int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public int countArrangementDP(int n) {
        return dfs(n, 1, 0, new Integer[n + 1][1 << n]);
    }

    private static int dfs(int n, int idx, int mask, Integer[][] dp) {
        if (idx > n) {
            return 1;
        }
        if (dp[idx][mask] != null) {
            return dp[idx][mask];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                if ((i + 1) % idx == 0 || idx % (i + 1) == 0) {
                    res += dfs(n, idx + 1, mask | (1 << i), dp);
                }
            }
        }
        return dp[idx][mask] = res;
    }
}
