package cses.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class GraphPathsI {

    private static final int MOD = (int) (1e9 + 7);

    // https://cp-algorithms.com/graph/fixed_length_paths.html
    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int k = fs.nextInt();
        final long[][] mat = new long[n][n];
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            mat[u][v]++;
        }
        long[][] identity = new long[n][n];
        for (int i = 0; i < identity.length; i++) {
            identity[i][i] = 1;
        }
        identity = pow(mat, identity, k);
        System.out.println(identity[0][n - 1]);
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
