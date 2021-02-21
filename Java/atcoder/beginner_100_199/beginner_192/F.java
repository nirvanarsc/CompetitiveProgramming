package atcoder.beginner_100_199.beginner_192;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final long x = fs.nextLong();
        final int[] arr = fs.nextIntArray(n);
        long res = (long) 9e18;
        for (int len = 1; len <= n; len++) {
            final int[][][] dp = new int[n][len + 1][len + 1];
            for (int[][] r1 : dp) {
                for (int[] r2 : r1) {
                    Arrays.fill(r2, -1);
                }
            }
            final int currBest = dfs(arr, 0, 0, len, len, (int) (x % len), dp);
            if (currBest != (int) -1e9) {
                res = Math.min(res, (x - currBest) / len);
            }
        }
        System.out.println(res);
    }

    private static int dfs(int[] arr, int idx, int mod, int len, int currMod, int tarMod, int[][][] dp) {
        if (idx == arr.length) {
            if (mod == tarMod && len == 0) {
                return 0;
            }
            return (int) -1e9;
        }
        if (dp[idx][mod][len] != -1) {
            return dp[idx][mod][len];
        }
        int res = (int) -1e9;
        res = Math.max(res, dfs(arr, idx + 1, mod, len, currMod, tarMod, dp));
        if (len > 0) {
            final int nextMod = (currMod == 0) ? 0 : (mod + arr[idx]) % currMod;
            final int dfs = dfs(arr, idx + 1, nextMod, len - 1, currMod, tarMod, dp);
            if (dfs != (int) -1e9) {
                res = Math.max(res, arr[idx] + dfs);
            }
        }
        return dp[idx][mod][len] = res;
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
