package leetcode.biweekly_contests.biweekly_44;

public class P_1735 {

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

    public int[] waysToFillArray(int[][] queries) {
        final Combinations comb = new Combinations((int) 1e5);
        final int[] res = new int[queries.length];
        int idx = 0;
        for (int[] q : queries) {
            final int n = q[0];
            int num = q[1];
            long curr = 1;
            for (int p = 2; p * p <= q[1]; p++) {
                int count = 0;
                while (num % p == 0) {
                    num /= p;
                    count++;
                }
                if (count > 0) {
                    curr = (curr * comb.ncr(n, count)) % MOD;
                }
            }
            if (num > 1) {
                curr = (curr * comb.ncr(n, 1)) % MOD;
            }
            res[idx++] = (int) curr;
        }
        return res;
    }
}
