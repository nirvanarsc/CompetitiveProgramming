package leetcode.weekly_contests.weekly_300_399.weekly_358;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_4 {

    static List<Integer> primes;
    static boolean[] sieve;

    private static final int MOD = (int) (1e9 + 7);

    public int maximumScore(List<Integer> nums, int k) {
        if (primes == null) {
            sieve = sieveOfEratosthenes();
            //noinspection NonThreadSafeLazyInitialization
            primes = new ArrayList<>();
            for (int i = 0; i < sieve.length; i++) {
                if (sieve[i]) {
                    primes.add(i);
                }
            }
        }
        final int n = nums.size();
        final int[][] paired = new int[n][3];
        final int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            final int v = c(nums.get(i));
            paired[i] = new int[] { nums.get(i), v, i };
            scores[i] = v;
        }
        Arrays.sort(paired, (a, b) -> Integer.compare(b[0], a[0]));
        long res = 1;
        for (int i = 0; i < n && k > 0; i++) {
            final int[] curr = paired[i];
            final int u = paired[i][2];
            int l = u - 1;
            int r = u + 1;
            while (l >= 0 && scores[l] < scores[u]) {
                l--;
            }
            while (r < n && scores[r] <= scores[u]) {
                r++;
            }
            final int take = Math.min(k, (u - l) * (r - u));
            k -= take;
            res = (res * modPow(curr[0], take)) % MOD;
        }
        return (int) res;
    }

    private static long modPow(long a, long n) {
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

    private static int c(int num) {
        int curr = 0;
        for (int p : primes) {
            if (num % p == 0) {
                while (num % p == 0) {
                    num /= p;
                }
                curr++;
            }
            if (sieve[num]) {
                curr++;
                break;
            }
            if (num == 1) {
                break;
            }
        }
        return curr;
    }

    private static boolean[] sieveOfEratosthenes() {
        final int n = (int) 1e5;
        final boolean[] prime = new boolean[n + 5];
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
