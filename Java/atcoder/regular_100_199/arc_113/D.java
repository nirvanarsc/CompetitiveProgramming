package atcoder.regular_100_199.arc_113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static final int MOD = 998244353;

    /*
     * Let A' be the max from all A, and B' be the min of all B.
     * Then it is true that A <= B.
     * If we want to count all such pairs we can do naively for each A' from 1 to 2e5:
     * (A') ^ n * (K - A' + 1) ^ m.
     * However we will double count smaller A' in the (A') ^ n expression, because
     * (A') ^ n is the count of all numbers <= A'.
     * Therefore instead we should count all numbers = A', which is equal to f(A') - f(A' - 1), i.e.
     * (A') ^ n - (A' - 1) ^ n, in other words the formula is
     * ((A') ^ n - (A' - 1) ^ n) * (K - A' + 1) ^ m for all A' from 1 to 2e5
     */
    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int k = fs.nextInt();
        long res = 0;
        if (n == 1) {
            System.out.println(modPow(k, m));
            return;
        }
        if (m == 1) {
            System.out.println(modPow(k, n));
            return;
        }
        for (int i = 1; i <= k; i++) {
            final long ll = (modPow(i, n) - modPow(i - 1, n) + MOD) % MOD;
            final long rr = modPow(k - i + 1, m);
            res = (res + (ll * rr) % MOD) % MOD;
        }
        System.out.println(res);
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

    static final class Utils {
        private static class Shuffler {
            private static void shuffle(int[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void shuffle(long[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void swap(int[] x, int i, int j) {
                final int t = x[i];
                x[i] = x[j];
                x[j] = t;
            }

            private static void swap(long[] x, int i, int j) {
                final long t = x[i];
                x[i] = x[j];
                x[j] = t;
            }
        }

        public static void shuffleSort(int[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
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
