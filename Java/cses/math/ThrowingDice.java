package cses.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class ThrowingDice {

    /*

    0 1  * 0 1  => 1 1 * 1 1 => 2 3
    1 1    1 1     1 2   1 2    3 5

    int dp[2] = { 0, 1 }
    for()
     int[] new_dp = { 0, 0 }
     new_dp[0] += dp[1]*1
     new_dp[1] += dp[0]*1
     new_dp[1] += dp[1]*1

    int dp[6] = { 1, 2, 4, 8, 16, 32 } => { 2, 4, 8, 16, 32, 63 }
    for()
     int[] new_dp = { 0, 0, 0, 0, 0, 0 }
     new_dp[0] += dp[1]*1
     new_dp[1] += dp[2]*1
     new_dp[2] += dp[3]*1
     new_dp[3] += dp[4]*1
     new_dp[4] += dp[5]*1
     new_dp[5] += dp[0]*1
     new_dp[5] += dp[1]*1
     new_dp[5] += dp[2]*1
     new_dp[5] += dp[3]*1
     new_dp[5] += dp[4]*1
     new_dp[5] += dp[5]*1

     0 1 0 0 0 0
     0 0 1 0 0 0
     0 0 0 1 0 0
     0 0 0 0 1 0
     0 0 0 0 0 1
     1 1 1 1 1 1

     */

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final long n = fs.nextLong();
        final long[][] grid = {
                { 0, 1L, 0, 0, 0, 0 },
                { 0, 0, 1L, 0, 0, 0 },
                { 0, 0, 0, 1L, 0, 0 },
                { 0, 0, 0, 0, 1L, 0 },
                { 0, 0, 0, 0, 0, 1L },
                { 1L, 1L, 1L, 1L, 1L, 1L }
        };
        long[][] identity = new long[6][6];
        for (int i = 0; i < identity.length; i++) {
            identity[i][i] = 1;
        }
        identity = pow(grid, identity, n);
        System.out.println(identity[5][5]);
    }

    private static long[][] pow(long[][] m, long[][] answer, long k) {
        while (k > 0) {
            if (k % 2 == 1) {
                answer = multiply(answer, m);
            }
            m = multiply(m, m);
            k >>= 1;
        }
        return answer;
    }

    private static long[][] multiply(long[][] left, long[][] right) {
        final int lRow = left.length;
        final int lCol = left[0].length;
        final int rCol = right[0].length;
        final long[][] res = new long[lRow][rCol];
        for (int i = 0; i < lRow; i++) {
            for (int k = 0; k < lCol; k++) {
                for (int j = 0; j < rCol; j++) {
                    res[i][j] = (res[i][j] + left[i][k] * right[k][j]) % MOD;
                }
            }
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
