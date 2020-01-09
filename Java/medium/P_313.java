package medium;

public class P_313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        final int[] dp = new int[n];
        dp[0] = 1;
        final int[] indices = new int[primes.length];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], dp[indices[j]] * primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == dp[indices[j]] * primes[j]) {
                    indices[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
