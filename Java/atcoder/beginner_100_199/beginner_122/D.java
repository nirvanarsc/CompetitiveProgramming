package atcoder.beginner_100_199.beginner_122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("RedundantIfStatement")
public final class D {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        System.out.println(dfs(n, 4, 4, 4, new Integer[n + 1][5][5][5]));
    }

    private static int dfs(int n, int x3, int x2, int x1, Integer[][][][] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n][x1][x2][x3] != null) {
            return dp[n][x1][x2][x3];
        }
        int res = 0;
        for (int next = 0; next < 4; next++) {
            if (ok(x3, x2, x1, next) && ok(x3, x2, next, x1) && ok(x3, x1, x2, next) && ok(x2, x3, x1, next)) {
                res = (res + dfs(n - 1, x2, x1, next, dp)) % MOD;
            }
        }
        return dp[n][x1][x2][x3] = res;
    }

    // 0123
    // ACGT
    private static boolean ok(int x1, int x2, int x3, int x4) {
        if (x1 == 0 && x2 == 2 && x3 == 1) {
            return false;
        }
        if (x2 == 0 && x3 == 2 && x4 == 1) {
            return false;
        }
        return true;
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
