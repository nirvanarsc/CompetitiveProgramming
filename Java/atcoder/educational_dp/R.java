package atcoder.educational_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class R {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final long k = fs.nextLong();
        final long[][] grid = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = fs.nextInt();
            }
        }
        long[][] identity = new long[n][n];
        for (int i = 0; i < n; i++) {
            identity[i][i] = 1;
        }
        identity = pow(grid, identity, k);
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = (res + identity[i][j]) % MOD;
            }
        }
        System.out.println(res);
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
