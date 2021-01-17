package atcoder.regular_100_199.keyence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C implements Runnable {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        new Thread(null, new C(), "whatever", 1 << 26).start();
    }

    @Override
    public void run() {
        final FastScanner fs = new FastScanner();
        final int h = fs.nextInt();
        final int w = fs.nextInt();
        final int k = fs.nextInt();
        final char[][] g = new char[h][w];
        for (int i = 0; i < k; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final char c = fs.next().toCharArray()[0];
            g[u][v] = c;
        }
        final long[][] dp = new long[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(dp[i], -1L);
        }
        final long inv = modPow(3, MOD - 2);
        final long pow = modPow(3, h * w - k);
        System.out.println((dfs(g, 0, 0, h, w, inv, dp) * pow) % MOD);
    }

    private static long dfs(char[][] g, int i, int j, int n, int m, long inv, long[][] dp) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        long res = 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        final char curr = g[i][j];
        if (curr == 'X') {
            if (j < m - 1) {
                res = (res + dfs(g, i, j + 1, n, m, inv, dp)) % MOD;
            }
            if (i < n - 1) {
                res = (res + dfs(g, i + 1, j, n, m, inv, dp)) % MOD;
            }
        } else if (curr == 'R') {
            if (j < m - 1) {
                res = (res + dfs(g, i, j + 1, n, m, inv, dp)) % MOD;
            }
        } else if (curr == 'D') {
            if (i < n - 1) {
                res = (res + dfs(g, i + 1, j, n, m, inv, dp)) % MOD;
            }
        } else {
            if (j < m - 1) {
                res = (res + (2L * inv * dfs(g, i, j + 1, n, m, inv, dp)) % MOD) % MOD;
            }
            if (i < n - 1) {
                res = (res + (2L * inv * dfs(g, i + 1, j, n, m, inv, dp)) % MOD) % MOD;
            }
        }
        return dp[i][j] = res;
    }

    private static long modPow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n /= 2;
        }
        return res;
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
