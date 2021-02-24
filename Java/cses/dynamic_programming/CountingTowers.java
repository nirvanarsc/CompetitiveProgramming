package cses.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public final class CountingTowers {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final StringBuilder sb = new StringBuilder();
        final int t = fs.nextInt();
        final int[][] dp = new int[(int) 1e6][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        final int[][] q = new int[t][2];
        for (int i = 0; i < t; i++) {
            q[i] = new int[] { fs.nextInt(), i };
        }
        Arrays.sort(q, Comparator.comparingInt(a -> a[0]));
        int prev = 1;
        final int[] res = new int[t];
        for (int i = 0; i < t; i++) {
            for (int j = prev; j < q[i][0]; j++) {
                dp[j][0] = add(dp[j][0], dp[j - 1][1]);
                dp[j][0] = add(dp[j][0], dp[j - 1][0]);
                dp[j][0] = add(dp[j][0], dp[j - 1][0]);
                dp[j][0] = add(dp[j][0], dp[j - 1][0]);
                dp[j][0] = add(dp[j][0], dp[j - 1][0]);
                dp[j][1] = add(dp[j][1], dp[j - 1][1]);
                dp[j][1] = add(dp[j][1], dp[j - 1][1]);
                dp[j][1] = add(dp[j][1], dp[j - 1][0]);
            }
            res[q[i][1]] = add(dp[q[i][0] - 1][0], dp[q[i][0] - 1][1]);
            prev = q[i][0];
        }
        for (int i = 0; i < t; i++) {
            sb.append(res[i]);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int add(int a, int b) {
        a += b;
        if (a > MOD) {
            a -= MOD;
        }
        return a;
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
