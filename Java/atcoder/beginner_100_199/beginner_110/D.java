package atcoder.beginner_100_199.beginner_110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

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

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        int m = fs.nextInt();
        final Combinations combinations = new Combinations((int) (1e6 + 5));
        final List<Integer> powerFactors = new ArrayList<>();
        final int limit = m;
        for (int p = 2; p * p <= limit; p++) {
            if (m % p == 0) {
                int fact = 0;
                while (m % p == 0) {
                    fact++;
                    m /= p;
                }
                powerFactors.add(fact);
            }
        }
        if (m > 1) {
            powerFactors.add(1);
        }
        long res = 1;
        for (int f : powerFactors) {
            // combinations with repetition
            res = (res * combinations.ncr(f + n - 1, f)) % MOD;
        }
        System.out.println(res);
    }

    static final class Utils {
        public static void shuffleSort(int[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffleSort(long[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffle(int[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void shuffle(long[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void swap(int[] x, int i, int j) {
            final int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        public static void swap(long[] x, int i, int j) {
            final long t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        private Utils() {}
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        private String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    //noinspection CallToPrintStackTrace
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] nextIntArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long[] nextLongArray(int n) {
            final long[] a = new long[n];
            for (int i = 0; i < n; i++) { a[i] = nextLong(); }
            return a;
        }
    }
}
