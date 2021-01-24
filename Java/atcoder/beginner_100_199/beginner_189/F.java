package atcoder.beginner_100_199.beginner_189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    static class Pair {
        double a;
        double b;

        Pair(double a, double b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int k = fs.nextInt();
        final int[] arr = new int[n + 1];
        for (int i = 0; i < k; i++) {
            arr[fs.nextInt()] = 1;
        }
        final Pair[] dp = new Pair[n + 1];
        Arrays.fill(dp, new Pair(0, 0));
        final Pair curr = new Pair(0, 0);
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                dp[i] = new Pair(1, 0);
            } else {
                dp[i] = new Pair(curr.a / m, curr.b / m + 1);
            }
            curr.a += dp[i].a;
            curr.b += dp[i].b;
            if (i + m <= n) {
                curr.a -= dp[i + m].a;
                curr.b -= dp[i + m].b;
            }
        }
        final double a = dp[0].a;
        final double b = dp[0].b;
        if (a + 1e-6 > 1) {
            System.out.println(-1);
            return;
        }
        final double res = b / (1 - a);
        System.out.printf("%.6f", res);
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
