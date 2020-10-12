package atcoder.educational_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class J {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                a++;
            } else if (arr[i] == 2) {
                b++;
            } else {
                c++;
            }
        }
        System.out.println(dfs(a, b, c, n, new Double[n + 1][n + 1][n + 1]));
    }

    private static double dfs(int a, int b, int c, int n, Double[][][] dp) {
        if (a == 0 && b == 0 && c == 0) {
            return 0;
        }
        if (dp[a][b][c] != null) {
            return dp[a][b][c];
        }
        double res = 1.0 * n / (a + b + c);
        if (a > 0) {
            res += (1.0 * a / (a + b + c)) * dfs(a - 1, b, c, n, dp);
        }
        if (b > 0) {
            res += (1.0 * b / (a + b + c)) * dfs(a + 1, b - 1, c, n, dp);
        }
        if (c > 0) {
            res += (1.0 * c / (a + b + c)) * dfs(a, b + 1, c - 1, n, dp);
        }
        return dp[a][b][c] = res;
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
