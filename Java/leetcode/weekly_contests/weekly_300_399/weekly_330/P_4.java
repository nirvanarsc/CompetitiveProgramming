package leetcode.weekly_contests.weekly_300_399.weekly_330;

public class P_4 {

    public long countQuadruplets(int[] nums) {
        final int n = nums.length;
        final int[][] g = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            nums[i]--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i > nums[j - 1]) {
                    g[i][j]++;
                }
                g[i][j] += g[i][j - 1];
            }
        }
        long res = 0L;
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (nums[j] > nums[k]) {
                    final long l = g[nums[k]][j];
                    final long r = n - k - (g[nums[j]][n] - g[nums[j]][k]);
                    res += l * r;
                }
            }
        }
        return res;
    }
}
