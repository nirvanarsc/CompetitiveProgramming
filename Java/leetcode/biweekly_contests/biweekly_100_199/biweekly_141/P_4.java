package leetcode.biweekly_contests.biweekly_100_199.biweekly_141;

public class P_4 {

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

        long nck(int n, int k) {
            if (n < k) { return 0; }
            if (n < 0 || k < 0) { return 0; }
            return factorial[n] * (facInverse[k] * facInverse[n - k] % MOD) % MOD;
        }

        // combinations with repetition
        long ncr(int n, int k) {
            return nck(n + k - 1, k);
        }

        // permutations with repetition
        long npk(int n, int k) {
            if (n < k) { return 0; }
            if (n < 0 || k < 0) { return 0; }
            return factorial[n] * facInverse[n - k] % MOD;
        }

        long modPow(long a, long n) {
            long res = 1;
            while (n > 0) {
                if (n % 2 != 0) {
                    res = res * a % MOD;
                }
                a = a * a % MOD;
                n /= 2;
            }
            return res;
        }
    }

    public int numberOfWays(int n, int x, int y) {
        // Stirling numbers of the second kind
        // https://en.wikipedia.org/wiki/Stirling_numbers_of_the_second_kind
        final long[][] stirling = new long[n + 1][x + 1];
        stirling[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                if (j == 0 || j > i) {
                    stirling[i][j] = 0; // stirling(n, 0) = 0 for n > 0, and stirling(n, j) = 0 if j > n.
                } else if (j == 1 || i == j) {
                    stirling[i][j] = 1; // stirling(n, 1) = 1 and stirling(n, n) = 1
                } else {
                    // Use the recurrence relation stirling(n, j) = stirling(n-1, j-1) + j * stirling(n-1, j)
                    stirling[i][j] =
                            (stirling[i - 1][j - 1] + (j * stirling[i - 1][j] % MOD)) % MOD;
                }
            }
        }
        final long[] p = new long[x + 1];
        p[0] = 1;
        final Combinations comb = new Combinations(x + 1);
        for (int i = 1; i <= x; i++) {
            p[i] = (p[i - 1] * y) % MOD;
        }
        long res = 0;
        for (int i = 1; i <= x; i++) {
            // res = (res + (stirling[n][i] * comb.factorial[i] * comb.nck(x, i) * p[i]) % MOD) % MOD;
            // reduces to i! x choose i = i! * (x! / (x-i)! * i!)
            // cancel i! to get x! / (x-i)!
            final long stageAssignments = (comb.factorial[x] * comb.facInverse[x - i]) % MOD;
            final long scoreAssignments = (stageAssignments * p[i]) % MOD;
            res = (res + (stirling[n][i] * scoreAssignments) % MOD) % MOD;
        }
        return (int) res;
    }
}
