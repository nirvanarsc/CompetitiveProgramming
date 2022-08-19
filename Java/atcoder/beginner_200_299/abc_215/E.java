package atcoder.beginner_200_299.abc_215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final char[] w = fs.next().toCharArray();
        final int[][][] dp = new int[n + 1][1 << 11][11];
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int mask = 0; mask < 1 << 11; mask++) {
                final int v = w[i] - 'A' + 1;
                for (int u = 0; u < 11; u++) {
                    if (u == v) {
                        dp[i + 1][mask][v] = (dp[i + 1][mask][v] + dp[i][mask][u]) % MOD;
                    } else if ((mask & (1 << v)) == 0) {
                        dp[i + 1][mask | (1 << v)][v] = (dp[i + 1][mask | (1 << v)][v] + dp[i][mask][u]) % MOD;
                    }
                    dp[i + 1][mask][u] = (dp[i + 1][mask][u] + dp[i][mask][u]) % MOD;
                }
            }
        }
        int res = 0;
        for (int mask = 0; mask < 1 << 11; mask++) {
            for (int u = 0; u < 11; u++) {
                res = (res + dp[n][mask][u]) % MOD;
            }
        }
        System.out.println((res - 1 + MOD) % MOD);
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
