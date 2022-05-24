package leetcode.weekly_contests.weekly_200_299.weekly_213;

public class P_1643 {

    private static final int MOD = (int) (1e9 + 7);

    private static class Combinations {
        long[] factorial;
        long[] facInverse;
        long[] inverse;

        Combinations(int n) {
            final int MAX = n + 2;
            factorial = new long[MAX];
            facInverse = new long[MAX];
            inverse = new long[MAX];
            factorial[0] = factorial[1] = 1;
            facInverse[0] = facInverse[1] = 1;
            inverse[1] = 1;
            for (int i = 2; i < MAX; i++) {
                factorial[i] = factorial[i - 1] * i % MOD;
                final long inv = inverse[i] = MOD - inverse[MOD % i] * (MOD / i) % MOD;
                facInverse[i] = facInverse[i - 1] * inv % MOD;
            }
        }

        long ncr(int n, int r) {
            if (n < r) { return 0; }
            if (n < 0 || r < 0) { return 0; }
            return factorial[n] * (facInverse[r] * facInverse[n - r] % MOD) % MOD;
        }

        long modpow(long a, long n) {
            long res = 1;
            while (n > 0) {
                if (n % 2 == 1) {
                    res = res * a % MOD;
                }
                a = a * a % MOD;
                n /= 2;
            }
            return res;
        }
    }

    public String kthSmallestPath(int[] destination, int k) {
        final Combinations comb = new Combinations(100);
        final int steps = destination[0] + destination[1];
        int down = destination[0];
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < steps; i++) {
            final int currSteps = steps - (i + 1);
            final int combinations = (int) comb.ncr(currSteps, down);
            if (combinations >= k) {
                sb.append('H');
            } else {
                down--;
                k -= combinations;
                sb.append('V');
            }
        }
        return sb.toString();
    }
}
