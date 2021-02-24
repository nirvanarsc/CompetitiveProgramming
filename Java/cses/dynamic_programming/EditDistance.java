package cses.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class EditDistance {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final char[] l = fs.next().toCharArray();
        final char[] r = fs.next().toCharArray();
        final int[][] dp = new int[l.length + 1][r.length + 1];
        for (int i = 1; i <= l.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= r.length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l.length; i++) {
            for (int j = 1; j <= r.length; j++) {
                dp[i][j] = (int) 1e9;
            }
        }
        for (int i = 1; i <= l.length; i++) {
            for (int j = 1; j <= r.length; j++) {
                final int replaceCost = l[i - 1] == r[j - 1] ? 0 : 1;
                dp[i][j] = Math.min(dp[i][j], replaceCost + dp[i - 1][j - 1]);
                dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
                dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
            }
        }
        System.out.println(dp[l.length][r.length]);
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
