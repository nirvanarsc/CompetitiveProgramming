package atcoder.regular_100_199.arc_116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final long[][][] dp = new long[n + 5][m + 5][2 * (m + 5)];
        dp[0][0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int xor = 0; xor <= 2 * j; xor++) {
                    for (int k = 0; k <= j; k++) {
                        if ((xor ^ k) <= 2 * m) {
                            dp[i][j][xor] += dp[i - 1][j - k][xor ^ k];
                        }
                    }
                }
                System.out.println(Arrays.toString(dp[i][j]) + " " + j);
            }
        }
        for (long[] row : dp[n - 1]) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(dp[n - 1][0][0]);
    }

    private static long dfs(int n, int m, int xor, long[][][] dp) {
        if (n == 0) {
            return m == 0 && xor == 0 ? 1 : 0;
        }
        if (dp[n][m][xor] != -1) {
            return dp[n][m][xor];
        }
        long res = 0;
        for (int i = 0; i <= m; i++) {
            res = (res + dfs(n - 1, m - i, xor ^ i, dp)) % MOD;
        }
        return dp[n][m][xor] = res;
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
