package leetcode.weekly_contests.weekly_256;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int numberOfUniqueGoodSubsequences(String binary) {
        int n = binary.length();
        int[] dp = new int[2];
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int c = binary.charAt(i - 1) - '0';
            int curr = (ans + 1 - dp[c] + MOD) % MOD;
            ans = (ans + curr) % MOD;
            dp[c] = (dp[c] + curr) % MOD;
        }
        return ans;
    }
}
