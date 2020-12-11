package atcoder.beginner_100_199.beginner_118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[] costs = { 0, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
        final int[][] currCosts = new int[m][2];
        int minCost = 10;
        for (int i = 0; i < m; i++) {
            final int num = fs.nextInt();
            currCosts[i] = new int[] { num, costs[num] };
            minCost = Math.min(minCost, costs[num]);
        }
        System.out.println(dfs(n, currCosts, minCost, new String[n + 1]));
    }

    private static String dfs(int cost, int[][] costs, int minCost, String[] dp) {
        if (cost < minCost) {
            return cost == 0 ? "" : "No";
        }
        if (dp[cost] != null) {
            return dp[cost];
        }
        String res = "";
        for (int[] c : costs) {
            if (c[1] <= cost) {
                final String dfs = dfs(cost - c[1], costs, minCost, dp);
                if (!"No".equals(dfs)) {
                    final String curr1 = dfs + c[0];
                    final String curr2 = c[0] + dfs;
                    if (res.length() < curr1.length()
                        || res.length() == curr1.length() && res.compareTo(curr1) < 0) {
                        res = curr1;
                    }
                    if (res.length() < curr2.length()
                        || res.length() == curr2.length() && res.compareTo(curr2) < 0) {
                        res = curr2;
                    }
                }
            }
        }
        return dp[cost] = res;
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
