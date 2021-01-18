package atcoder.beginner_100_199.beginner_153;

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
        final int n = fs.nextInt();
        final int[][] m = new int[n][2];
        for (int i = 0; i < n; i++) {
            m[i] = new int[] { fs.nextInt(), fs.nextInt() };
        }
        final int[][] dp = new int[h][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(dfs(h, 0, 0, m, dp));
    }

    private static int dfs(int h, int curr, int idx, int[][] m, int[][] dp) {
        if (idx == m.length || curr >= h) {
            return curr >= h ? 0 : (int) 1e9;
        }
        if (dp[curr][idx] != -1) {
            return dp[curr][idx];
        }
        int res = (int) 1e9;
        res = Math.min(res, m[idx][1] + dfs(h, curr + m[idx][0], idx, m, dp));
        res = Math.min(res, dfs(h, curr, idx + 1, m, dp));
        return dp[curr][idx] = res;
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
