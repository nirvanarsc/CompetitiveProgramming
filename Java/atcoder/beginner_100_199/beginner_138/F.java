package atcoder.beginner_100_199.beginner_138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    private static final int MOD = (int) (1e9 + 7);

    private static int add(int l, int r) {
        return (l + r) % MOD;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final long x = fs.nextLong();
        final long y = fs.nextLong();
        final char[] l = String.format("%60s", Long.toBinaryString(x)).replace(' ', '0').toCharArray();
        final char[] r = String.format("%60s", Long.toBinaryString(y)).replace(' ', '0').toCharArray();
        System.out.println(dfs(l, r, 0, 0, 0, 0, new Integer[60][2][2][2]));
    }

    private static int dfs(char[] l, char[] r, int pos, int flagX, int flagY, int flagZ, Integer[][][][] dp) {
        if (pos == l.length) {
            return 1;
        }
        if (dp[pos][flagX][flagY][flagZ] != null) {
            return dp[pos][flagX][flagY][flagZ];
        }
        int res = 0;
        // 0 0
        if (flagX == 1 || l[pos] == '0') {
            res = add(res, dfs(l, r, pos + 1, flagX, r[pos] == '1' ? 1 : flagY, flagZ, dp));
        }
        // 0 1
        if ((flagX == 1 || l[pos] == '0') && (flagY == 1 || r[pos] == '1') && flagZ == 1) {
            res = add(res, dfs(l, r, pos + 1, flagX, flagY, 1, dp));
        }
        // 1 1
        if (flagY == 1 || r[pos] == '1') {
            res = add(res, dfs(l, r, pos + 1, l[pos] == '0' ? 1 : flagX, flagY, 1, dp));
        }
        return dp[pos][flagX][flagY][flagZ] = res;
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
