package atcoder.educational_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final char[] s = fs.next().toCharArray();
        final char[] t = fs.next().toCharArray();
        final int[][] dp = new int[s.length + 1][t.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        final int lcs = dfs(s, t, 0, 0, dp);
        if (lcs == 0) {
            System.out.println(" ");
            return;
        }
        final char[] res = new char[lcs];
        int i = 0, j = 0, idx = 0;
        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                res[idx++] = s[i];
                i++;
                j++;
            } else if (dp[i + 1][j] > dp[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println(res);
    }

    private static int dfs(char[] s, char[] t, int l, int r, int[][] dp) {
        if (l == s.length || r == t.length) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        int res = Math.max(dfs(s, t, l + 1, r, dp), dfs(s, t, l, r + 1, dp));
        if (s[l] == t[r]) {
            res = Math.max(res, 1 + dfs(s, t, l + 1, r + 1, dp));
        }
        return dp[l][r] = res;
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
