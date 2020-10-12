package atcoder.educational_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class L {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final long[] arr = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextLong();
            sum += arr[i];
        }
        System.out.println(2 * dfs(arr, 0, n - 1, new Long[n][n]) - sum);
    }

    private static long dfs(long[] nums, int start, int end, Long[][] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        return dp[start][end] = Math.max(nums[start] + Math.min(dfs(nums, start + 2, end, dp),
                                                                dfs(nums, start + 1, end - 1, dp)),
                                         nums[end] + Math.min(dfs(nums, start + 1, end - 1, dp),
                                                              dfs(nums, start, end - 2, dp)));
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
