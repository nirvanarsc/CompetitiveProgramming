package atcoder.beginner_100_199.beginner_162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F implements Runnable {

    public static void main(String[] args) {
        new Thread(null, new F(), "ThreadName", 1 << 26).start();
    }

    @Override
    public void run() {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        final long[][] dp = new long[n][3];
        for (long[] row : dp) {
            Arrays.fill(row, (long) -9e18);
        }
        System.out.println(dfs(arr, 0, (n % 2) + 1, dp));
    }

    private static long dfs(int[] arr, int idx, int skip, long[][] dp) {
        if (idx == arr.length - 1 && skip > 0) {
            return 0;
        }
        if (idx >= arr.length) {
            return 0;
        }
        if (dp[idx][skip] != (long) -9e18) {
            return dp[idx][skip];
        }
        long res = (long) -9e18;
        if (skip > 0) {
            res = Math.max(res, dfs(arr, idx + 1, skip - 1, dp));
        }
        res = Math.max(res, arr[idx] + dfs(arr, idx + 2, skip, dp));
        return dp[idx][skip] = res;
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
