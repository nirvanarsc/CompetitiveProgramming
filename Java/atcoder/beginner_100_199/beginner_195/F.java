package atcoder.beginner_100_199.beginner_195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final long a = fs.nextLong();
        final long b = fs.nextLong();
        final int n = (int) (b - a + 1);
        final int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71 };
        final int[] masks = new int[n];
        long num = a;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < primes.length; j++) {
                if (num % primes[j] == 0) {
                    curr |= 1 << j;
                }
            }
            masks[i] = curr;
            num++;
        }
        final long[][] dp = new long[n][1 << 20];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1L);
        }
        System.out.println(dfs(masks, 0, 0, dp));
    }

    private static long dfs(int[] masks, int i, int mask, long[][] dp) {
        if (i == masks.length) {
            return 1;
        }
        if (dp[i][mask] != -1) {
            return dp[i][mask];
        }
        long res = 0;
        if ((mask & masks[i]) == 0) {
            res += dfs(masks, i + 1, mask | masks[i], dp);
        }
        res += dfs(masks, i + 1, mask, dp);
        return dp[i][mask] = res;
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
