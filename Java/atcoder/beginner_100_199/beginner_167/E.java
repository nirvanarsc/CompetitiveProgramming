package atcoder.beginner_100_199.beginner_167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    private static final int MOD = 998244353;

    static class Solver {
        long[] factorial;
        long[] facInverse;
        long[] inverse;

        void solve(int n, int m, int k) {
            init(n);
            int sum = 0;
            for (int i = 0; i <= k; i++) {
                final long edge = ncr(n - 1, i);
                sum = (int) ((sum + (edge * (m * modpow(m - 1, n - 1 - i) % MOD)) % MOD) % MOD);
            }
            System.out.println(sum);
        }

        void init(int n) {
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

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int m = in.nextInt();
        final int k = in.nextInt();
        in.nextLine();
        new Solver().solve(n, m, k);
    }
}
