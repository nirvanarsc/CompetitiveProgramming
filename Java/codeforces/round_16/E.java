package codeforces.round_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final double[][] grid = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = Double.parseDouble(fs.next());
            }
        }
        final Double[] dp = new Double[1 << n];
        for (int i = 0; i < n; i++) {
            System.out.print(dfs(1 << i, grid, dp) + " ");
        }
        System.out.println();
    }

    private static double dfs(int mask, double[][] grid, Double[] dp) {
        if (Integer.bitCount(mask) == grid.length) {
            return 1;
        }
        if (dp[mask] != null) {
            return dp[mask];
        }
        double res = 0;
        for (int deadFish = 0; deadFish < grid.length; deadFish++) {
            if ((mask & (1 << deadFish)) == 0) {
                final int prevMask = mask | (1 << deadFish);
                res += move(prevMask, deadFish, grid) * dfs(prevMask, grid, dp);
            }
        }
        return dp[mask] = res;
    }

    private static double move(int mask, int deadFish, double[][] grid) {
        final int k = Integer.bitCount(mask);
        final double total = (k * (k - 1)) / 2.0;
        double res = 0;
        for (int i = 0; i < grid.length; i++) {
            if ((mask & (1 << i)) != 0) {
                res += grid[i][deadFish];
            }
        }
        return res / total;
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
