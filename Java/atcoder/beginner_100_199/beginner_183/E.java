package atcoder.beginner_100_199.beginner_183;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    private static final int MOD = (int) (1e9 + 7);

    private static int add(int l, int r) {
        return (l + r) % MOD;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = fs.next().toCharArray();
        }
        final int[][] dp = new int[n][m];
        final int[][] preSumX = new int[n][m];
        final int[][] preSumY = new int[n][m];
        final int[][] preSumXY = new int[n][m];
        dp[0][0] = 1;
        preSumX[0][0] = 1;
        preSumY[0][0] = 1;
        preSumXY[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) { continue; }
                if (grid[i][j] == '#') { continue; }
                // update prefix sums
                if (j > 0) {
                    preSumX[i][j] = add(preSumX[i][j], preSumX[i][j - 1]);
                }
                if (i > 0) {
                    preSumY[i][j] = add(preSumY[i][j], preSumY[i - 1][j]);
                }
                if (i > 0 && j > 0) {
                    preSumXY[i][j] = add(preSumXY[i][j], preSumXY[i - 1][j - 1]);
                }
                // compute dp
                dp[i][j] = add(add(preSumX[i][j], preSumY[i][j]), preSumXY[i][j]);
                // distribute dp into prefix sums
                preSumX[i][j] = add(preSumX[i][j], dp[i][j]);
                preSumY[i][j] = add(preSumY[i][j], dp[i][j]);
                preSumXY[i][j] = add(preSumXY[i][j], dp[i][j]);
            }
        }
        System.out.println(dp[n - 1][m - 1]);
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
