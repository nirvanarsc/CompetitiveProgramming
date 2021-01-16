package atcoder.beginner_100_199.beginner_151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F2 {

    // ternary search
    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i] = new int[] { fs.nextInt(), fs.nextInt() };
        }
        double lo = 0;
        double hi = 1000;
        for (int i = 0; i < 100; i++) {
            final double m1 = (lo * 2 + hi) / 3;
            final double m2 = (lo + hi * 2) / 3;
            if (g(m1, p) > g(m2, p)) {
                lo = m1;
            } else {
                hi = m2;
            }
        }
        System.out.printf("%.6f\n", g(lo, p));
    }

    private static double f(double x, double y, int[][] p) {
        double res = 0;
        for (int[] pp : p) {
            res = Math.max(res, Math.hypot(pp[0] - x, pp[1] - y));
        }
        return res;
    }

    private static double g(double x, int[][] p) {
        double lo = 0;
        double hi = 1000;
        for (int i = 0; i < 100; i++) {
            final double m1 = (lo * 2 + hi) / 3;
            final double m2 = (lo + hi * 2) / 3;
            if (f(x, m1, p) > f(x, m2, p)) {
                lo = m1;
            } else {
                hi = m2;
            }
        }
        return f(x, lo, p);
    }

    static final class Utils {
        public static void shuffleSort(int[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffle(int[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void shuffle(long[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void swap(int[] arr, int i, int j) {
            final int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        public static void swap(long[] arr, int i, int j) {
            final long t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
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
