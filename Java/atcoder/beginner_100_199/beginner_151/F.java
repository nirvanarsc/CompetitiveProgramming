package atcoder.beginner_100_199.beginner_151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i] = new int[] { fs.nextInt(), fs.nextInt() };
        }
        double res = 1e9;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    final double[] circle = getCircle(p[i], p[j], p[k]);
                    if (circle != null) {
                        final double[] center = { circle[0], circle[1] };
                        final double radius = circle[2];
                        if (ok(center, radius, p)) {
                            res = Math.min(res, radius);
                        }
                    }
                }
            }
        }
        for (int[] p1 : p) {
            for (int[] p2 : p) {
                final double[] center = { 0.5 * (p1[0] + p2[0]), 0.5 * (p1[1] + p2[1]) };
                final double radius = Math.hypot(p1[0] - p2[0], p1[1] - p2[1]) / 2.0;
                if (ok(center, radius, p)) {
                    res = Math.min(res, radius);
                }
            }
        }
        System.out.printf("%.6f\n", res);
    }

    @SuppressWarnings("ReturnOfNull")
    private static double[] getCircle(int[] a, int[] b, int[] c) {
        final double bx = b[0] - a[0];
        final double by = b[1] - a[1];
        final double cx = c[0] - a[0];
        final double cy = c[1] - a[1];
        final double B = bx * bx + by * by;
        final double C = cx * cx + cy * cy;
        final double D = bx * cy - by * cx;
        if (D == 0) {
            return null;
        }
        final double[] center = { a[0] + (cy * B - by * C) / (2 * D), a[1] + (bx * C - cx * B) / (2 * D) };
        final double radius = Math.hypot(a[0] - center[0], a[1] - center[1]);
        return new double[] { center[0], center[1], radius };
    }

    private static boolean ok(double[] center, double radius, int[][] p) {
        for (int[] pp : p) {
            final double d = Math.hypot(center[0] - pp[0], center[1] - pp[1]);
            if (Double.compare(d, radius + 1e-8) > 0) {
                return false;
            }
        }
        return true;
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
