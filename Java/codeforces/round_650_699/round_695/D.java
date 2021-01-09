package codeforces.round_650_699.round_695;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int k = fs.nextInt();
        final int q = fs.nextInt();
        final long[] arr = fs.nextLongArray(n);
        final int[] count = pre(n, k);
        long curr = 0;
        for (int i = 0; i < n; i++) {
            curr = (curr + (arr[i] * count[i]) % MOD) % MOD;
        }
        for (int i = 0; i < q; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt();
            long diff = ((v - arr[u]) * count[u]) % MOD;
            diff = (diff + MOD) % MOD;
            arr[u] = v;
            curr = (curr + diff) % MOD;
            pw.println(curr);
        }
        pw.close();
    }

    private static int[] pre(int n, int k) {
        final int[][] dp = new int[n][k + 1];
        final int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= k; j++) {
            dp[0][j] = dp[1][j - 1];
            for (int i = 1; i < n - 1; i++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i + 1][j - 1]) % MOD;
            }
            dp[n - 1][j] = dp[n - 2][j - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                count[i] = (count[i] + (dp[i][j] * dp[i][k - j]) % MOD) % MOD;
            }
        }
        return count;
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
