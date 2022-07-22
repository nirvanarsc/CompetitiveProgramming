package leetcode.weekly_contests.weekly_300_399.weekly_301;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int idealArrays(int n, int maxValue) {
        final Combinations comb = new Combinations((int) 2e4 + 5);
        final boolean[] sieve = sieveOfEratosthenes(maxValue);
        final List<Integer> primes = new ArrayList<>();
        for (int p = 2; p <= maxValue; p++) {
            if (sieve[p]) {
                primes.add(p);
            }
        }
        long res = 0;
        for (int prev = 1; prev <= maxValue; prev++) {
            int curr = prev;
            long add = 1;
            for (int p : primes) {
                if (sieve[curr]) {
                    add = (add * comb.ncr(2, n - 1)) % MOD;
                    curr = 1;
                }
                if (curr == 1) {
                    break;
                }
                if (curr % p == 0) {
                    int count = 0;
                    while (curr % p == 0) {
                        count++;
                        curr /= p;
                    }
                    add = (add * comb.ncr(count + 1, n - 1)) % MOD;
                }
            }
            res = (res + add) % MOD;
        }
        return (int) res;
    }

    private static boolean[] sieveOfEratosthenes(int maxValue) {
        final int n = maxValue + 5;
        final boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }
}
