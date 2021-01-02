package atcoder.beginner_100_199.beginner_142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[][] masks = new int[m][2];
        for (int i = 0; i < m; i++) {
            final int cost = fs.nextInt();
            final int keys = fs.nextInt();
            int mask = 0;
            for (int j = 0; j < keys; j++) {
                final int u = fs.nextInt() - 1;
                mask |= 1 << u;
            }
            masks[i] = new int[] { cost, mask };
        }
        final int res = dfs((1 << n) - 1, masks, 0, 0, new Integer[m][1 << n]);
        System.out.println(res == (int) 1e9 ? -1 : res);
    }

    private static int dfs(int target, int[][] masks, int idx, int currMask, Integer[][] dp) {
        if (idx == masks.length) {
            return target == currMask ? 0 : (int) 1e9;
        }
        if (dp[idx][currMask] != null) {
            return dp[idx][currMask];
        }
        int res = (int) 1e9;
        res = Math.min(res, dfs(target, masks, idx + 1, currMask, dp));
        res = Math.min(res, masks[idx][0] + dfs(target, masks, idx + 1, currMask | masks[idx][1], dp));

        return dp[idx][currMask] = res;
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
