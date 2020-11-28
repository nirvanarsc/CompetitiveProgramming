package codeforces.round_600_649.round_637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static final int[][] NUMS = {
            new int[] { 0b1111011, 9, 6 },
            new int[] { 0b1111111, 8, 7 },
            new int[] { 0b1010010, 7, 3 },
            new int[] { 0b1101111, 6, 6 },
            new int[] { 0b1101011, 5, 5 },
            new int[] { 0b0111010, 4, 4 },
            new int[] { 0b1011011, 3, 5 },
            new int[] { 0b1011101, 2, 5 },
            new int[] { 0b0010010, 1, 2 },
            new int[] { 0b1110111, 0, 6 }
    };

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int k = fs.nextInt();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            final String line = fs.next();
            arr[i] = Integer.parseInt(line, 2);
        }
        final Boolean[][] dp = new Boolean[n + 1][k + 1];
        dfs(arr, 0, k, dp);
        if (dp[n][0] == null || !dp[n][0]) {
            System.out.println(-1);
            return;
        }
        final StringBuilder best = new StringBuilder();
        int currCost = k;
        for (int i = 0; i < n; i++) {
            final int bits = Integer.bitCount(arr[i]);
            for (int[] num : NUMS) {
                if (bits <= num[2] && (arr[i] | num[0]) == num[0]) {
                    final int cost = num[2] - bits;
                    if (currCost >= cost && dp[i + 1][currCost - cost] != null && dp[i + 1][currCost - cost]) {
                        currCost -= cost;
                        best.append(num[1]);
                        break;
                    }
                }
            }
        }
        System.out.println(best);
    }

    private static boolean dfs(int[] arr, int idx, int k, Boolean[][] dp) {
        if (idx == arr.length) {
            if (dp[idx][0] == null) {
                dp[idx][0] = k == 0;
            }
            return dp[idx][0] |= k == 0;
        }
        if (dp[idx][k] != null) {
            return dp[idx][k];
        }
        boolean res = false;
        final int bits = Integer.bitCount(arr[idx]);
        for (int[] num : NUMS) {
            if (bits <= num[2] && (arr[idx] | num[0]) == num[0]) {
                final int cost = num[2] - bits;
                if (k >= cost) {
                    res |= dfs(arr, idx + 1, k - cost, dp);
                }
            }
        }
        return dp[idx][k] = res;
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
