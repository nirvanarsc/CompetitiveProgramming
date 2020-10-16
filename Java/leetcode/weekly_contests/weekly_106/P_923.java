package leetcode.weekly_contests.weekly_106;

import java.util.Arrays;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_923 {

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

    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        final Combinations comb = new Combinations((int) (3e3 + 5));
        final int n = A.length;
        final int[] count = new int[101];
        for (int num : A) {
            count[num]++;
        }
        long res = 0;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && A[i] == A[i - 1]) { continue; }
            int lo = i + 1;
            int hi = n - 1;
            final int currT = target - A[i];
            while (lo < hi) {
                if (A[lo] + A[hi] > currT) {
                    hi--;
                } else if (A[lo] + A[hi] < currT) {
                    lo++;
                } else {
                    if (A[i] == A[lo] && A[lo] == A[hi]) {
                        res += comb.ncr(count[A[lo]], 3);
                    } else if (A[lo] == A[hi]) {
                        res += comb.ncr(count[A[lo]], 2) * count[A[i]];
                    } else if (A[i] == A[lo]) {
                        res += comb.ncr(count[A[lo]], 2) * count[A[hi]];
                    } else {
                        res += count[A[lo]] * count[A[hi]] * count[A[i]];
                    }
                    res %= MOD;
                    while (lo < hi && A[lo + 1] == A[lo]) { lo++; }
                    while (lo < hi && A[hi - 1] == A[hi]) { hi--; }
                    lo++;
                    hi--;
                }
            }
        }
        return (int) res;
    }
}
