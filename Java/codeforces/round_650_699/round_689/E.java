package codeforces.round_650_699.round_689;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        // TODO
        long k = fs.nextLong();
        final long l = fs.nextLong();
        final long r = fs.nextLong();
        final long t = fs.nextLong();
        final long x = fs.nextLong();
        final long y = fs.nextLong();
        // can never fill
        if (y > (r - l + 1)) {
            final long diff = x - l;
            final long safeDays = diff / x;
            if (safeDays < t) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
            // can fill
        } else {
            // can fill first day
            if (r - k >= y) {
                k += y;
            }

            // can drain first day
            if (k - x < l) {
                System.out.println("No");
                return;
            }

//            if (y >= x) {
//                System.out.println("Yes");
//                return;
//            }

            final BigInteger kk = BigInteger.valueOf(k);
            final BigInteger xx = BigInteger.valueOf(x);
            final BigInteger tt = BigInteger.valueOf(t);
            final BigInteger yy = BigInteger.valueOf(y);
            final BigInteger lowest = kk.subtract(
                    tt.multiply(xx).subtract(tt.subtract(BigInteger.ONE).multiply(yy)));

            if (lowest.compareTo(BigInteger.valueOf(l)) < 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
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
