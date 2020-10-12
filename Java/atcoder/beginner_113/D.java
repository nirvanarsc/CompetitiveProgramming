package atcoder.beginner_113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int h = fs.nextInt();
        final int w = fs.nextInt();
        final int k = fs.nextInt();
        System.out.println(solve(h, w, k));
    }

    static int solve(int h, int w, int k) {
        final int[][] dp = new int[h + 1][w];
        dp[0][0] = 1;

        for (int i = 0; i < h; i++) {
            for (int mask = 0; mask < 1 << (w - 1); mask++) {
                if (isValid(mask)) {
                    for (int pos = 0; pos < w; pos++) {
                        final int nextPos = computeNextPos(pos, mask);
                        dp[i + 1][nextPos] = (dp[i + 1][nextPos] + dp[i][pos]) % MOD;
                    }
                }
            }
        }

        return dp[h][k - 1];
    }

    static boolean isValid(int code) {
        return !Integer.toBinaryString(code).contains("11");
    }

    static int computeNextPos(int pos, int code) {
        if ((code & (1 << pos)) != 0) {
            return pos + 1;
        } else if (pos != 0 && (code & (1 << (pos - 1))) != 0) {
            return pos - 1;
        } else {
            return pos;
        }
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
