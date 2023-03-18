package leetcode.biweekly_contests.biweekly_0_99.biweekly_50;

public class P_1830 {

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

    public int makeStringSorted(String s) {
        final Combinations comb = new Combinations((int) (3e3 + 5));
        final int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }
        long res = 0;
        int total = s.length();
        for (char c : s.toCharArray()) {
            final int id = c - 'a';
            for (int i = 0; i < id; i++) {
                if (f[i] == 0) {
                    continue;
                }
                f[i]--;
                long curr = 1;
                for (int j = 0; j < 26; j++) {
                    // deal with repetitions (divide by repetition! for each repetition count)
                    curr = (curr * comb.facInverse[f[j]]) % MOD;
                }
                curr = (curr * comb.factorial[total - 1]) % MOD;
                res = (res + curr) % MOD;
                f[i]++;
            }
            f[id]--;
            total--;
        }
        return (int) res;
    }
}
