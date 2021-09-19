package kickstart.year_2021.round_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    static int[][] limit;
    static boolean[][] g;
    static int max;
    static int n;
    static int target;
    static boolean[][] seen;
    static long[][] dp;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 1; x <= t; x++) {
            n = fs.nextInt();
            final int m = fs.nextInt();
            target = fs.nextInt();
            limit = new int[n][3];
            for (int i = 0; i < n; i++) {
                limit[i] = new int[] { fs.nextInt(), fs.nextInt(), fs.nextInt() };
            }
            g = new boolean[n][n];
            for (int i = 0; i < m; i++) {
                final int u = fs.nextInt();
                final int v = fs.nextInt();
                g[u][v] = g[v][u] = true;
            }
            max = (1 << n) - 1;
            seen = new boolean[1 << n][n];
            dp = new long[1 << n][n];
            System.out.println("Case #" + x + ": " + dfs(0, 0));
        }
    }

    private static long dfs(int mask, int idx) {
        long power = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                power += limit[i][2];
            }
        }
        if (power == target) {
            return 1;
        }
        if (power > target || mask == max) {
            return 0;
        }
        if (seen[mask][idx]) {
            return dp[mask][idx];
        }
        long res = 0;
        if (mask == 0) {
            for (int i = 0; i < n; i++) {
                res += dfs(1 << i, i);
            }
        } else {
            int bad = 0;
            for (int i = 0; i < n; i++) {
                if (g[idx][i] && (mask & (1 << i)) == 0 && limit[i][0] <= power && power <= limit[i][1]) {
                    res += dfs(mask | (1 << i), i);
                    bad |= 1 << i;
                }
            }
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < n; j++) {
                        if (g[i][j] && (mask & (1 << j)) == 0 && limit[j][0] <= power && power <= limit[j][1]) {
                            if ((bad & (1 << j)) == 0) {
                                res += dfs(mask | (1 << j), j);
                                bad |= 1 << j;
                            }
                        }
                    }
                }
            }
        }
        seen[mask][idx] = true;
        return dp[mask][idx] = res;
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
