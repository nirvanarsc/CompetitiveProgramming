package atcoder.beginner_200_299.abc_203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int k = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        Utils.shuffleSort(arr);
        final int[] skips = new int[n];
        for (int i = 0; i < n; i++) {
            skips[i] = upperBound(arr, (arr[i] * 2) - 1);
        }
        final int[][] dp = new int[n + 1][32];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 31; j++) {
                dp[skips[i] + 1][j + 1] = Math.min(dp[skips[i] + 1][j + 1], dp[i][j]);
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
            }
        }
        for (int i = 0; i < 31; i++) {
            if (dp[n][i] <= k) {
                System.out.println(i + " " + dp[n][i]);
                return;
            }
        }
    }

    private static int upperBound(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
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
