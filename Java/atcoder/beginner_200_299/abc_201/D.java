package atcoder.beginner_200_299.abc_201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    static int[][] g;
    static int[][] dp;
    static int n;
    static int m;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        n = fs.nextInt();
        m = fs.nextInt();
        dp = new int[n][m];
        g = new int[n][m];
        for (int i = 0; i < n; i++) {
            final char[] row = fs.next().toCharArray();
            for (int j = 0; j < m; j++) {
                g[i][j] = row[j] == '+' ? 1 : -1;
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        final int res = dfs(0, 0);
        System.out.println(res < 0 ? "Aoki" : res == 0 ? "Draw" : "Takahashi");
    }

    private static int dfs(int i, int j) {
        if (i == n - 1 && j == m - 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = (int) -1e9;
        if (j < m - 1) {
            res = Math.max(res, g[i][j + 1] - dfs(i, j + 1));
        }
        if (i < n - 1) {
            res = Math.max(res, g[i + 1][j] - dfs(i + 1, j));
        }
        return dp[i][j] = res;
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
