package gcj.year_2021.round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    static int[][] dp;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        dp = new int[2][(int) (1e6 + 5)];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        for (int test = 1; test <= t; test++) {
            final int n = fs.nextInt();
            final int res = dfs(n, 0);
            System.out.println("Case #" + test + ": " + res);
        }
    }

    private static int dfs(int n, int p) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return -(int) (1e6 + 5);
        }
        if (dp[p][n] != -1) {
            return dp[p][n];
        }
        int res = 1;
        if (p == 0) {
            for (int k = 3; (long) k * k <= n; k++) {
                if (n % k == 0) {
                    res = Math.max(res, 1 + dfs((n / k) - 1, 1));
                    res = Math.max(res, 1 + dfs(k - 1, 1));
                }
            }
        } else {
            for (int k = 2; (long) k * k <= n; k++) {
                if (n % k == 0) {
                    res = Math.max(res, 1 + dfs((n / k) - 1, 1));
                    res = Math.max(res, 1 + dfs(k - 1, 1));
                }
            }
        }
        return dp[p][n] = res;
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
