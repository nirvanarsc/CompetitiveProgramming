package atcoder.regular_100_199.arc_109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int a = fs.nextInt();
        final int b = fs.nextInt();
        final int x = fs.nextInt();
        final int y = fs.nextInt();
        System.out.println(dfs(a, b, x, y, 1, new Integer[105][2]));
    }

    private static int dfs(int a, int b, int x, int y, int inA, Integer[][] dp) {
        if (a == b) {
            return inA == 0 ? 0 : x;
        }
        if (dp[a][inA] != null) {
            return dp[a][inA];
        }
        int res = (int) 1e9;
        if (a < b) {
            if (inA == 1) {
                res = Math.min(res, x + dfs(a, b, x, y, 0, dp));
                res = Math.min(res, y + dfs(a + 1, b, x, y, 1, dp));
            } else {
                res = Math.min(res, x + dfs(a + 1, b, x, y, 1, dp));
                res = Math.min(res, y + dfs(a + 1, b, x, y, 0, dp));
            }
        } else {
            if (inA == 1) {
                res = Math.min(res, x + dfs(a - 1, b, x, y, 0, dp));
                res = Math.min(res, y + dfs(a - 1, b, x, y, 1, dp));
            } else {
                res = Math.min(res, x + dfs(a, b, x, y, 1, dp));
                res = Math.min(res, y + dfs(a - 1, b, x, y, 0, dp));
            }
        }
        return dp[a][inA] = res;
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
