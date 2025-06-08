package leetcode.biweekly_contests.biweekly_100_199.biweekly_158;

public class P_3 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long maxGCDScore(int[] nums, int k) {
        final int n = nums.length;
        long res = 0;
        final int[][] pre = new int[n + 1][32];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 32; j++) {
                pre[i][j] = pre[i - 1][j] + (nums[i - 1] % (1 << j) != 0 ? 1 : 0);
            }
        }
        for (int i = 0; i < n; i++) {
            int gcd = nums[i];
            for (int j = i; j < n; j++) {
                gcd = gcd(gcd, nums[j]);
                final int len = j - i + 1;
                res = Math.max(res, (long) gcd * len);
                final int p = Long.numberOfTrailingZeros(gcd);
                if (k >= (pre[j + 1][p + 1] - pre[i][p + 1])) {
                    res = Math.max(res, 2L * len * gcd);
                }
            }
        }
        return res;
    }
}
