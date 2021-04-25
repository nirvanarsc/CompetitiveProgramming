package atcoder.beginner_100_199.beginner_199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    static int n;
    static long[][] dp;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        n = fs.nextInt();
        dp = new long[n][1 << n];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        final int m = fs.nextInt();
        final int[][] conditions = new int[m][3];
        for (int i = 0; i < m; i++) {
            conditions[i] = new int[] { fs.nextInt(), fs.nextInt(), fs.nextInt() };
        }
        System.out.println(dfs(0, 0, conditions));
    }

    private static long dfs(int mask, int idx, int[][] conditions) {
        if (idx == n) {
            return 1;
        }
        if (dp[idx][mask] != -1) {
            return dp[idx][mask];
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0 && canPlace(mask | (1 << i), idx, conditions)) {
                res += dfs(mask | (1 << i), idx + 1, conditions);
            }
        }
        return dp[idx][mask] = res;
    }

    private static boolean canPlace(int mask, int idx, int[][] conditions) {
        final int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                pre[i + 1] = 1;
            }
            pre[i + 1] += pre[i];
        }
        for (int[] cond : conditions) {
            final int x = cond[0] - 1;
            final int y = cond[1];
            final int z = cond[2];
            if (x < idx) {
                continue;
            }
            if (pre[y] > z) {
                return false;
            }
        }
        return true;
    }

    static final class Utils {
        private static class Shuffler {
            private static void shuffle(int[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void shuffle(long[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void swap(int[] x, int i, int j) {
                final int t = x[i];
                x[i] = x[j];
                x[j] = t;
            }

            private static void swap(long[] x, int i, int j) {
                final long t = x[i];
                x[i] = x[j];
                x[j] = t;
            }
        }

        public static void shuffleSort(int[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
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
