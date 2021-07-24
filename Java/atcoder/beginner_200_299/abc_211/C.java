package atcoder.beginner_200_299.abc_211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    private static final int MOD = (int) (1e9 + 7);

    static boolean[][] seen;
    static int[][] dp;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final char[] w = fs.next().toCharArray();
        final char[] t = "chokudai".toCharArray();
        final int n = w.length;
        seen = new boolean[n][8];
        dp = new int[n][8];
        System.out.println(dfs(w, t, 0, 0));
    }

    private static int dfs(char[] w, char[] t, int i, int j) {
        if (j == t.length) {
            return 1;
        }
        if (i == w.length) {
            return 0;
        }
        if (seen[i][j]) {
            return dp[i][j];
        }
        int res = 0;
        if (w[i] == t[j]) {
            res = (res + dfs(w, t, i + 1, j + 1)) % MOD;
        }
        res = (res + dfs(w, t, i + 1, j)) % MOD;
        seen[i][j] = true;
        return dp[i][j] = res;
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
