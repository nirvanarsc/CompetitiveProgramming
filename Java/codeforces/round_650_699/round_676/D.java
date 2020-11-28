package codeforces.round_650_699.round_676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("SuspiciousNameCombination")
public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            int x = fs.nextInt();
            int y = fs.nextInt();
            final long c1 = fs.nextLong();
            long c2 = fs.nextLong();
            long c3 = fs.nextLong();
            final long c4 = fs.nextLong();
            long c5 = fs.nextLong();
            long c6 = fs.nextLong();
            long res = Long.MAX_VALUE;
            if (x >= 0 && y >= 0) {
                if (x > y) {
                    final int temp = x;
                    x = y;
                    y = temp;
                    long tt = c6;
                    c6 = c2;
                    c2 = tt;
                    tt = c3;
                    c3 = c5;
                    c5 = tt;
                }
                res = Math.min(res, f(x, y - x, c1, c2));
                res = Math.min(res, f(y, y - x, c1, c3));
                res = Math.min(res, f(x, y, c6, c2));
            } else if (x <= 0 && y <= 0) {
                if (x > y) {
                    final int temp = x;
                    x = y;
                    y = temp;
                    long tt = c6;
                    c6 = c2;
                    c2 = tt;
                    tt = c3;
                    c3 = c5;
                    c5 = tt;
                }
                res = Math.min(res, f(Math.abs(x), Math.abs(y - x), c4, c2));
                res = Math.min(res, f(Math.abs(y), Math.abs(y - x), c4, c3));
                res = Math.min(res, f(Math.abs(x), Math.abs(y), c3, c5));
            } else if (x < 0) {
                res = Math.min(res, f(Math.abs(x), Math.abs(x) + y, c4, c2));
                res = Math.min(res, f(y, Math.abs(x) + y, c1, c3));
                res = Math.min(res, f(Math.abs(x), y, c3, c2));
            } else {
                res = Math.min(res, f(x, x + Math.abs(y), c1, c5));
                res = Math.min(res, f(Math.abs(y), x + Math.abs(y), c4, c6));
                res = Math.min(res, f(x, Math.abs(y), c6, c5));
            }
            System.out.println(res);
        }
    }

    private static long f(int ll, int rr, long cost1, long cost2) {
        return cost1 * ll + cost2 * rr;
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
