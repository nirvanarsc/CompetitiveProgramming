package leetcode.weekly_contests.weekly_400_499.weekly_430;

public class P_3 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long numberOfSubsequences(int[] nums) {
        final int n = nums.length;
        final int m = (int) (1e3 + 5);
        final int[][] count = new int[m][m];
        long res = 0;
        for (int q = n - 5; q > 1; q--) {
            // Count (r, s) pairs for current q
            for (int r = q + 2, s = q + 4; s < n; s++) {
                final int gcd = gcd(nums[r], nums[s]);
                ++count[nums[r] / gcd][nums[s] / gcd];
            }
            // Count (p, q) pairs and accumulate results
            for (int p = 0; p + 1 < q; p++) {
                final int gcd = gcd(nums[p], nums[q]);
                res += count[nums[q] / gcd][nums[p] / gcd];
            }
        }
        return res;
    }
}
