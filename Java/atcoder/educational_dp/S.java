package atcoder.educational_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class S {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final char[] str = fs.next().toCharArray();
        final int d = fs.nextInt();
        final long res = dfs(str, 0, 0, 0, d, new Long[str.length][101][2]);
        System.out.println(Math.floorMod(res - 1, MOD));
    }

    public static long dfs(char[] str, int idx, int mod, int smallerAlready, int d, Long[][][] dp) {
        if (idx == str.length) {
            return mod % d == 0 ? 1 : 0;
        }
        if (dp[idx][mod][smallerAlready] != null) {
            return dp[idx][mod][smallerAlready];
        }
        long res = 0;
        // if smallerAlready = 1 we can take all numbers, otherwise only up to limit
        final int maxNum = smallerAlready == 0 ? str[idx] - '0' : 9;
        for (int i = 0; i <= maxNum; i++) {
            if (i == maxNum && smallerAlready == 0) {
                res = (res + dfs(str, idx + 1, (mod + i) % d, 0, d, dp)) % MOD;
            } else {
                res = (res + dfs(str, idx + 1, (mod + i) % d, 1, d, dp)) % MOD;
            }
        }
        return dp[idx][mod][smallerAlready] = res;
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
