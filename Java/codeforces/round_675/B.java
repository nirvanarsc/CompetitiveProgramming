package codeforces.round_675;

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
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = fs.nextInt();
                }
            }
            long res = 0;
            for (int i = 0, upR = 0, botR = n - 1; i < n / 2; i++, upR++, botR--) {
                for (int j = 0, lC = 0, rC = m - 1; j < m / 2; j++, lC++, rC--) {
                    final int[] curr = new int[4];
                    curr[0] = grid[upR][lC];
                    curr[1] = grid[upR][rC];
                    curr[2] = grid[botR][lC];
                    curr[3] = grid[botR][rC];
                    res += getRes(curr);
                }
            }
            if (n % 2 != 0) {
                for (int i = 0, j = m - 1; i < j; i++, j--) {
                    res += Math.abs(grid[n / 2][i] - grid[n / 2][j]);
                }
            }
            if (m % 2 != 0) {
                for (int i = 0, j = n - 1; i < j; i++, j--) {
                    res += Math.abs(grid[i][m / 2] - grid[j][m / 2]);
                }
            }
            System.out.println(res);
        }
    }

    private static long getRes(int[] arr) {
        Arrays.sort(arr);
        final long curr = arr[arr.length / 2];
        long res = 0;
        for (int value : arr) {
            res += Math.abs(curr - value);
        }
        return res;
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
