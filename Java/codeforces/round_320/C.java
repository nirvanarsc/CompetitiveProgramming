package codeforces.round_320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    // ternary search
    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        double lo = -1e6;
        double hi = 1e6;
        for (int i = 0; i < 200; i++) {
            final double m1 = lo + ((hi - lo) / 3.0);
            final double m2 = hi - ((hi - lo) / 3.0);
            final double left = f(arr, m1);
            final double right = f(arr, m2);
            if (Double.compare(left, right) > 0) {
                lo = m1;
            } else {
                hi = m2;
            }
        }
        System.out.printf("%.6f\n", f(arr, lo));
    }

    private static double f(int[] arr, double in) {
        final double[] seq = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            seq[i] = arr[i] - in;
        }
        double curr = 0, res = 0, min = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += seq[i];
            final double temp1 = Math.abs(curr - min);
            final double temp2 = Math.abs(curr - max);
            res = Math.max(res, temp1);
            res = Math.max(res, temp2);
            min = Math.min(min, curr);
            max = Math.max(curr, max);
        }
        return res;
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
