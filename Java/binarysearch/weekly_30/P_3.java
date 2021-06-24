package binarysearch.weekly_30;

import java.util.ArrayList;
import java.util.List;

public class P_3 {

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

    public int solve(int[] nums, int k) {
        final Combinations comb = new Combinations((int) (1e5 + 5));
        final List<Integer> list = new ArrayList<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= k) {
                int j = i;
                while (j < n && nums[j] >= k) {
                    j++;
                }
                list.add(j - i);
                i = j - 1;
            }
        }
        long res = 0;
        long prev = 0;
        for (int i = 0; i < list.size(); i++) {
            final long nck2 = comb.nck(list.get(i) + 1, 2);
            final long add1 = nck2 * prev;
            // stars and bars with 2 non-empty sets, e.g. |*|*|***|
            final long add2 = comb.nck(list.get(i) - 2 + 4, 4);
            res = (res + add1) % MOD;
            res = (res + add2) % MOD;
            prev = (prev + nck2) % MOD;
        }
        return (int) res;
    }
}
