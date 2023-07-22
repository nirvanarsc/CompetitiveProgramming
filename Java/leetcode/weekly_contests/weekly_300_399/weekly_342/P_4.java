package leetcode.weekly_contests.weekly_300_399.weekly_342;

public class P_4 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minOperations(int[] nums) {
        final int n = nums.length;
        int ones = 0;
        for (int num : nums) {
            ones += num == 1 ? 1 : 0;
        }
        if (ones > 0) {
            return n - ones;
        }
        int res = (int) 1e9;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    res = Math.min(res, j - i + (n - 1));
                    break;
                }
            }
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
