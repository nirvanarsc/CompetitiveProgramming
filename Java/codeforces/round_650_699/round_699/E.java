package codeforces.round_650_699.round_699;

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
        final int[] arr = fs.nextIntArray(n);
        final int[] l = new int[(int) (5e5 + 5)];
        final int[] r = new int[(int) (5e5 + 5)];
        final int[] f = new int[(int) (5e5 + 5)];
        final int[] suff = new int[n];
        final int[] dp = new int[n];
        Arrays.fill(l, -1);
        for (int i = 0; i < n; i++) {
            if (l[arr[i]] == -1) {
                l[arr[i]] = i;
            }
            r[arr[i]] = i;
            dp[i] = -1;
        }
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, ++f[arr[i]]);
            suff[i] = max;
        }
        System.out.println(n - dfs(arr, f, l, r, suff, 0, dp));
    }

    private static int dfs(int[] arr, int[] f, int[] l, int[] r, int[] suff, int idx, int[] dp) {
        if (idx == arr.length) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int res = dfs(arr, f, l, r, suff, idx + 1, dp);
        if (l[arr[idx]] == idx) {
            res = Math.max(res, f[arr[idx]] + dfs(arr, f, l, r, suff, r[arr[idx]] + 1, dp));
        } else {
            res = Math.max(res, suff[idx] + dfs(arr, f, l, r, suff, arr.length, dp));
        }
        return dp[idx] = res;
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
