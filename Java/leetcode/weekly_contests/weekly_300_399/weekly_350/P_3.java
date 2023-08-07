package leetcode.weekly_contests.weekly_300_399.weekly_350;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int specialPerm(int[] nums) {
        final int n = nums.length;
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            dp[i][1 << i] = 1;
        }
        final int[] size = new int[n];
        final int[][] g = new int[n][];
        for (int mask = 0; mask < (1 << n) - 1; mask++) {
            size[Integer.bitCount(mask)]++;
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int mask = 0; mask < (1 << n) - 1; mask++) {
            final int u = Integer.bitCount(mask);
            g[u][--size[u]] = mask;
        }
        for (int i = 1; i < n; i++) {
            final int[][] next = new int[n][1 << n];
            for (int j = 0; j < n; j++) {
                for (int mask : g[i]) {
                    for (int k = 0; k < n; k++) {
                        if ((mask & (1 << j)) == 0) {
                            continue;
                        }
                        if ((mask & (1 << k)) != 0) {
                            continue;
                        }
                        if (nums[j] % nums[k] == 0 || nums[k] % nums[j] == 0) {
                            next[k][mask | (1 << k)] = (next[k][mask | (1 << k)] + dp[j][mask]) % MOD;
                        }
                    }
                }
            }
            dp = next;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + dp[i][(1 << n) - 1]) % MOD;
        }
        return res;
    }
}
