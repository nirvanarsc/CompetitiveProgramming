package gcj.year_2021.qualifying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            final int x = fs.nextInt();
            final int y = fs.nextInt();
            final char[] w = fs.next().toCharArray();
            final int[][] dp = new int[w.length][3];
            for (int i = 0; i < w.length; i++) {
                dp[i][0] = dp[i][1] = dp[i][2] = (int) 1e9;
            }
            System.out.println("Case #" + tt + ": " + dfs(w, 2, 0, x, y, dp));
        }
    }

    private static int dfs(char[] w, int prev, int idx, int x, int y, int[][] dp) {
        if (idx == w.length) {
            return 0;
        }
        if (dp[idx][prev] != (int) 1e9) {
            return dp[idx][prev];
        }
        int res = (int) 1e9;
        if (w[idx] == '?') {
            if (prev == 0) {
                res = Math.min(res, dfs(w, 0, idx + 1, x, y, dp));
                res = Math.min(res, x + dfs(w, 1, idx + 1, x, y, dp));
            } else if (prev == 1) {
                res = Math.min(res, y + dfs(w, 0, idx + 1, x, y, dp));
                res = Math.min(res, dfs(w, 1, idx + 1, x, y, dp));
            } else {
                int cost0 = 0;
                int cost1 = 0;
                if (idx > 0) {
                    if (w[idx - 1] == 'J') {
                        cost0 = y;
                    } else {
                        cost1 = x;
                    }
                }
                res = Math.min(res, cost0 + dfs(w, 0, idx + 1, x, y, dp));
                res = Math.min(res, cost1 + dfs(w, 1, idx + 1, x, y, dp));
            }
        } else {
            if (prev == 0) {
                if (w[idx] == 'C') {
                    res = Math.min(res, dfs(w, 2, idx + 1, x, y, dp));
                } else {
                    res = Math.min(res, x + dfs(w, 2, idx + 1, x, y, dp));
                }
            } else if (prev == 1) {
                if (w[idx] == 'C') {
                    res = Math.min(res, y + dfs(w, 2, idx + 1, x, y, dp));
                } else {
                    res = Math.min(res, dfs(w, 2, idx + 1, x, y, dp));
                }
            } else {
                int cost = 0;
                if (idx > 0) {
                    if (w[idx - 1] == 'C' && w[idx] == 'J') {
                        cost = x;
                    } else if (w[idx - 1] == 'J' && w[idx] == 'C') {
                        cost = y;
                    }
                }
                res = Math.min(res, cost + dfs(w, 2, idx + 1, x, y, dp));
            }
        }
        return dp[idx][prev] = res;
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
