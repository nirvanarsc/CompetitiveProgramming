package atcoder.beginner_100_199.beginner_129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    private static final String d = "LURD";

    // ternary search
    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] points = new int[n][3];
        for (int i = 0; i < n; i++) {
            final int x = fs.nextInt();
            final int y = fs.nextInt();
            final String dir = fs.next();
            points[i] = new int[] { x, y, d.indexOf(dir) };
        }
        double lo = 0;
        double hi = 1e12;
        double res = 1e18;
        for (int i = 0; i < 300; i++) {
            final double m1 = lo + ((hi - lo) / 3.0);
            final double m2 = hi - ((hi - lo) / 3.0);
            final double left = f(points, m1);
            final double right = f(points, m2);
            if (Double.compare(left, right) > 0) {
                lo = m1;
            } else {
                hi = m2;
            }
            res = Math.min(res, left);
            res = Math.min(res, right);
        }
        System.out.println(String.format("%.10f", res));
    }

    private static double f(int[][] points, double mid) {
        double minX = 1e18;
        double maxX = -1e18;
        double minY = 1e18;
        double maxY = -1e18;
        for (int[] p : points) {
            final double x = p[0] + DIRS[p[2]][0] * mid;
            final double y = p[1] + DIRS[p[2]][1] * mid;
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }
        return (maxX - minX) * (maxY - minY);
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
