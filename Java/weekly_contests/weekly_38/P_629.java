package weekly_contests.weekly_38;

public class P_629 {

    private static final int MOD = (int) (1e9 + 7);

    public int kInversePairs(int n, int k) {
        int[] dp = new int[1001];
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            final int[] next = new int[1001];
            int sum = 0;
            for (int j = 0; j < next.length; j++) {
                sum = Math.floorMod(sum + dp[j] - (j >= i ? dp[j - i] : 0), MOD);
                next[j] = sum;
                if (next[j] == 0) {
                    break;
                }
            }
            dp = next;
        }
        return dp[k];
    }
}
