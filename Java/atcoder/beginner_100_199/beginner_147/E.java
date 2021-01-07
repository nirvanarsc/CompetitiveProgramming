package atcoder.beginner_100_199.beginner_147;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int h = fs.nextInt();
        final int w = fs.nextInt();
        final int[][] grid = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grid[i][j] = fs.nextInt();
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grid[i][j] = Math.abs(grid[i][j] - fs.nextInt());
            }
        }
        final int[][][] dp = new int[h][w][(h + w) * 80];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < (h + w) * 80; k++) {
                    dp[i][j][k] = (int) -1e9;
                }
            }
        }
        System.out.println(dfs(grid, 0, 0, 0, dp));
    }

    private static int dfs(int[][] grid, int r, int c, int sum, int[][][] dp) {
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return Math.min(sum + grid[r][c], Math.abs(sum - grid[r][c]));
        }
        if (dp[r][c][sum] != (int) -1e9) {
            return dp[r][c][sum];
        }
        int res = (int) 1e9;
        if (r < grid.length - 1) {
            res = Math.min(res, dfs(grid, r + 1, c, sum + grid[r][c], dp));
            res = Math.min(res, dfs(grid, r + 1, c, Math.abs(sum - grid[r][c]), dp));
        }
        if (c < grid[0].length - 1) {
            res = Math.min(res, dfs(grid, r, c + 1, sum + grid[r][c], dp));
            res = Math.min(res, dfs(grid, r, c + 1, Math.abs(sum - grid[r][c]), dp));
        }
        return dp[r][c][sum] = res;
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
