package cses.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class SumOfDivisors {

    private static final int MOD = (int) (1e9 + 7);

    private static long mul(long a, long b) {
        return (a * b) % MOD;
    }

    private static long add(long a, long b) {
        long sum = a + b;
        if (sum < 0) {
            sum += MOD;
        }
        return sum % MOD;
    }

    private static long f(long n, long p) {
        final long hi = (n / p) % MOD;
        final long lo = (n / p + 1) % MOD;
        return ((lo * hi) / 2) % MOD;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final long n = fs.nextLong();
        long res = 0;
        for (long p = 1; p * p <= n; p++) {
            res = add(res, mul(p, n / p));
            if (n / p != p) {
                res = add(res, mul(p, f(n, p)));
                res = add(res, -mul(p, f(n, p + 1)));
            }
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
