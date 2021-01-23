package atcoder.beginner_100_199.beginner_155;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final char[] str = fs.next().toCharArray();
        final int[] s = new int[str.length + 1];
        for (int i = 0; i < str.length; i++) {
            s[i] = str[i] - '0';
        }
        final int[][] dp = new int[s.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(dfs(s, 0, 0, dp));
    }

    private static int dfs(int[] s, int idx, int carry, int[][] dp) {
        if (s.length == idx) {
            return 0;
        }
        if (dp[idx][carry] != -1) {
            return dp[idx][carry];
        }
        int res = (int) 1e9;
        final int x = s[idx] + carry;
        for (int a = 0; a < 10; a++) {
            final int b = a - x;
            if (b < 0) {
                res = Math.min(res, dfs(s, idx + 1, 1, dp) + a + b + 10);
            } else {
                res = Math.min(res, dfs(s, idx + 1, 0, dp) + a + b);
            }
        }
        return dp[idx][carry] = res;
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
