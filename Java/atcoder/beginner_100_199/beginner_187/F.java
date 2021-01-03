package atcoder.beginner_100_199.beginner_187;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[][] grid = new int[n][n];
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            grid[u][v] = 1;
            grid[v][u] = 1;
        }
        final boolean[] ok = new boolean[1 << n];
        for (int mask = 1; mask < 1 << n; mask++) {
            final List<Integer> bits = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits.add(i);
                }
            }
            boolean res = true;
            for (int i = 0; i < bits.size(); i++) {
                for (int j = i + 1; j < bits.size(); j++) {
                    final int u = bits.get(i);
                    final int v = bits.get(j);
                    if (grid[u][v] != 1) {
                        res = false;
                        break;
                    }
                }
            }
            ok[mask] = res;
        }
        System.out.println(dfs((1 << n) - 1, 0, ok, new Integer[1 << n]));
    }

    private static int dfs(int target, int currMask, boolean[] ok, Integer[] dp) {
        if (currMask == target) {
            return 0;
        }
        if (dp[currMask] != null) {
            return dp[currMask];
        }
        int res = (int) 1e9;
        final int available = target ^ currMask;
        // https://cp-algorithms.com/algebra/all-submasks.html
        for (int subMask = available; subMask > 0; subMask = (subMask - 1) & available) {
            if (ok[subMask]) {
                res = Math.min(res, 1 + dfs(target, currMask | subMask, ok, dp));
            }
        }
        return dp[currMask] = res;
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
