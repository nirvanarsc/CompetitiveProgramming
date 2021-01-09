package codeforces.round_650_699.round_695;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final int[] dp = new int[n];
            int total = 0;
            for (int i = 1; i < n - 1; i++) {
                if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                    dp[i]++;
                    total++;
                }
                if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
                    dp[i]++;
                    total++;
                }
            }
            int res = total;
            for (int i = 1; i < n - 1; i++) {
                final int curr = dp[i - 1] + dp[i] + dp[i + 1];
                int left = 0;
                int right = 0;
                if (i > 1) {
                    if (arr[i - 2] < arr[i - 1] && arr[i - 1] > arr[i + 1]) { left++; }
                    if (arr[i - 2] > arr[i - 1] && arr[i - 1] < arr[i + 1]) { left++; }
                }
                if (i < n - 2) {
                    if (arr[i - 1] < arr[i + 1] && arr[i + 1] > arr[i + 2]) { right++; }
                    if (arr[i - 1] > arr[i + 1] && arr[i + 1] < arr[i + 2]) { right++; }
                }
                res = Math.min(res, total - curr + left);
                res = Math.min(res, total - curr + right);
            }
            System.out.println(res);
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
