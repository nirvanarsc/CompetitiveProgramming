package leetcode.biweekly_contests.biweekly_100_199.biweekly_112;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_4 {

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

    private static final int MOD = (int) (1e9 + 7);

    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        if (k > 26) {
            return 0;
        }
        final Combinations comb = new Combinations((int) 2e5);
        final Map<Integer, Integer> ff = new HashMap<>();
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }
        Arrays.sort(f);
        for (int i = 0; i < 26; i++) {
            ff.merge(f[i], 1, Integer::sum);
        }
        f = reverse(f, 26);
        long res = 1;
        int u = k;
        for (int i = 0; i < k; i++) {
            res = (res * f[i]) % MOD;
            if (f[i] != f[k - 1]) {
                u--;
            }
        }
        res = (res * comb.nck(ff.get(f[k - 1]), u)) % MOD;
        return (int) res;
    }

    private static int[] reverse(int[] nums, int n) {
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[n - 1 - i] = nums[i];
        }
        return res;
    }
}
