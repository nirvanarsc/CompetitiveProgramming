package kickstart.year_2021.round_a;

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
        for (int x = 1; x <= t; x++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final int[][] g = new int[n][m];
            final int[][] rev = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0, k = m - 1; j < m; j++, k--) {
                    g[i][j] = fs.nextInt();
                    rev[i][k] = g[i][j];
                }
            }
            System.out.println("Case #" + x + ": " + (f(g, n, m) + f(rev, n, m)));
        }
    }

    private static long f(int[][] grid, int n, int m) {
        final int[][] pre = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int k = j;
                    while (k < m && grid[i][k] == grid[i][j]) {
                        k++;
                    }
                    int count = k - j;
                    for (int l = j; l < k; l++) {
                        pre[i][l] = count--;
                    }
                    j = k - 1;
                }
            }
        }
        long res = 0;
        // up -> down
        for (int j = 0; j < m; j++) {
            int curr = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 0) {
                    curr = 0;
                } else {
                    curr++;
                }
                res += f2(curr, pre[i][j]);
                res += f2(pre[i][j], curr);
            }
        }
        for (int j = 0; j < m; j++) {
            int curr = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] == 0) {
                    curr = 0;
                } else {
                    curr++;
                }
                res += f2(curr, pre[i][j]);
                res += f2(pre[i][j], curr);
            }
        }
        return res;
    }

    private static int f2(int l, int r) {
        if (l < 2 || r < 2) {
            return 0;
        }
        return Math.min(l / 2, r) - 1;
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
