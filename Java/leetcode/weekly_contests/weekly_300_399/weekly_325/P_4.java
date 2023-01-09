package leetcode.weekly_contests.weekly_300_399.weekly_325;

public class P_4 {

    private static final int MOD = (int) 1e9 + 7;

    public int countPartitions(int[] nums, int k) {
        final int[] dp = new int[k + 1];
        dp[0] = 1;
        int res = 1;
        long sum = 0;
        for (int num : nums) {
            for (int j = k; j >= 0; j--) {
                if (j + num <= k) {
                    dp[j + num] = (dp[j + num] + dp[j]) % MOD;
                }
            }
            res = (res * 2) % MOD;
            sum += num;
        }
        for (int i = 0; i < k; i++) {
            if (sum < i + k) {
                res = (res - dp[i] + MOD) % MOD;
            } else {
                res = (res - (2 * dp[i]) % MOD + MOD) % MOD;
            }
        }
        return res;
    }
}
