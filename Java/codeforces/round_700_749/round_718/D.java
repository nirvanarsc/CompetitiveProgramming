package codeforces.round_700_749.round_718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    static int[][][][] g;
    static int[][][] dp;
    static int n;
    static int m;
    static int k;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();
        g = new int[n][m][][];
        dp = new int[n][m][1 + (k / 2)];
        for (int[][] r1 : dp) {
            for (int[] r2 : r1) {
                Arrays.fill(r2, -1);
            }
        }
        final int[][] size = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                size[i][j] = 4;
                if (i == 0 || i == n - 1) {
                    size[i][j]--;
                }
                if (j == 0 || j == m - 1) {
                    size[i][j]--;
                }
                g[i][j] = new int[size[i][j]][3];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (m - 1); j++) {
                final int cost = fs.nextInt();
                g[i][j][--size[i][j]] = new int[] { i, j + 1, cost };
                g[i][j + 1][--size[i][j + 1]] = new int[] { i, j, cost };
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                final int cost = fs.nextInt();
                g[i][j][--size[i][j]] = new int[] { i + 1, j, cost };
                g[i + 1][j][--size[i + 1][j]] = new int[] { i, j, cost };
            }
        }
        final StringBuilder sb = new StringBuilder();
        if (k % 2 != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(-1);
                    sb.append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, k / 2);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(2 * dp[i][j][k / 2]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int dfs(int i, int j, int k) {
        if (k == 0) {
            return 0;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        int res = (int) 1e9;
        for (int[] next : g[i][j]) {
            res = Math.min(res, next[2] + dfs(next[0], next[1], k - 1));
        }
        return dp[i][j][k] = res;
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
