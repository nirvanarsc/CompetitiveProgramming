package codeforces.custom.sit_star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class J {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int m = fs.nextInt();
        final int n = fs.nextInt();
        final int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i] = new int[] { fs.nextInt(), fs.nextInt() };
        }
        final int[][][][][] dp = new int[m][n + 1][n + 1][n + 1][n + 1];
        for (int[][][][] r1 : dp) {
            for (int[][][] r2 : r1) {
                for (int[][] r3 : r2) {
                    for (int[] r4 : r3) {
                        Arrays.fill(r4, -1);
                    }
                }
            }
        }
        System.out.println(dfs(m, n, 0, n, n, n, n, p, dp));
    }

    private static int dfs(int m, int n, int b, int i4, int i3, int i2, int i1, int[][] p, int[][][][][] dp) {
        if (b >= m) {
            return 0;
        }
        if (dp[b][i4][i3][i2][i1] != -1) {
            return dp[b][i4][i3][i2][i1];
        }
        int res = (int) 1e9;
        if (i4 != n || i3 != n || i2 != n || i1 != n) {
            res = Math.min(res, 1 + dfs(m, n, b, i3, i2, i1, n, p, dp));
        }
        for (int i = 0; i < n; i++) {
            if (i == i4) {
                if (p[i][1] < 4) { res = Math.min(res, 1 + dfs(m, n, b + p[i][0], i3, i2, i1, i, p, dp)); }
            } else if (i == i3) {
                if (p[i][1] < 3) { res = Math.min(res, 1 + dfs(m, n, b + p[i][0], n, i2, i1, i, p, dp)); }
            } else if (i == i2) {
                if (p[i][1] < 2) { res = Math.min(res, 1 + dfs(m, n, b + p[i][0], i3, n, i1, i, p, dp)); }
            } else if (i == i1) {
                if (p[i][1] < 1) { res = Math.min(res, 1 + dfs(m, n, b + p[i][0], i3, i2, n, i, p, dp)); }
            } else {
                res = Math.min(res, 1 + dfs(m, n, b + p[i][0], i3, i2, i1, i, p, dp));
            }
        }
        return dp[b][i4][i3][i2][i1] = res;
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
