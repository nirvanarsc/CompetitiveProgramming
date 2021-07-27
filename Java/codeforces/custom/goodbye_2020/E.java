package codeforces.custom.goodbye_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final PrintWriter pw = new PrintWriter(System.out);
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final long[] arr = fs.nextLongArray(n);
            long sum = 0;
            final int[] bits = new int[60];
            final long[] pow2 = new long[60];
            for (int i = 0; i < 60; i++) {
                pow2[i] = (1L << i) % MOD;
            }
            for (long num : arr) {
                sum = (sum + num) % MOD;
                for (int i = 0; i < 60; i++) {
                    if ((num & (1L << i)) != 0) {
                        bits[i]++;
                    }
                }
            }
            long res = 0;
            for (int i = 0; i < n; i++) {
                final long nn = arr[i];
                long ll = sum;
                long rr = sum;
                for (int j = 0; j < 60; j++) {
                    if ((nn & (1L << j)) != 0) {
                        final long diff = (pow2[j] * (n - bits[j])) % MOD;
                        ll = (ll + diff) % MOD;
                    } else {
                        final long diff = (pow2[j] * bits[j]) % MOD;
                        rr = (rr - diff + MOD) % MOD;
                    }
                }
                final long curr = (ll * rr) % MOD;
                res = (res + curr) % MOD;
            }
            pw.println(res);
        }
        pw.close();
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
