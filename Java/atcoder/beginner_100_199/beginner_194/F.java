package atcoder.beginner_100_199.beginner_194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final String s = fs.next();
        final int k = fs.nextInt();
        final int[][][] dp = new int[16][1 << 16][2];
        for (int[][] row : dp) {
            for (int[] row2 : row) {
                Arrays.fill(row2, -1);
            }
        }
        if (s.length() <= 16) {
            System.out.println(dfs(s.toCharArray(), 0, 0, k, 0, dp));
        } else {
            final char[] pre = s.substring(0, s.length() - 16).toCharArray();
            final char[] suff = s.substring(s.length() - 16).toCharArray();

            long res = dfs(suff, 0, 0, k, 1, dp);

            System.out.println(res % MOD);

            System.out.println(pre);
            System.out.println(suff);


            final long[][] dp2 = new long[pre.length][2];
            for (int i = 0; i < dp2.length; i++) {
                dp2[i][0] = dp2[i][1] = -1;
            }

            System.out.println(dfs2(pre, 0, 0, dp2));
            System.out.println(res * dfs2(pre, 0, 0, dp2) % MOD);

//            for (int i = 0; i < pre.length; i++) {
//                final int limit;
//                if (pre[i] >= 'A') {
//                    limit = pre[i] - 'A' + 10;
//                } else {
//                    limit = pre[i] - '0';
//                }
//                res = (res * limit) % MOD;
//            }
//            System.out.println(res);
        }
    }

    private static long dfs2(char[] num, int idx, int seenSmaller, long[][] dp) {
        if (idx == num.length) {
            return 1;
        }
        if (dp[idx][seenSmaller] != -1) {
            return dp[idx][seenSmaller];
        }
        long res = 0;
        if (seenSmaller == 1) {
            res = 16L * dfs2(num, idx + 1, 1, dp) % MOD;
        } else {
            final int limit;
            if (num[idx] >= 'A') {
                limit = num[idx] - 'A' + 10;
            } else {
                limit = num[idx] - '0';
            }
            if(limit == 0) {
                res = (res + dfs2(num, idx + 1, 0, dp)) % MOD;
            } else if(limit == 1) {
                res = (res + dfs2(num, idx + 1, 0, dp)) % MOD;
            } else if(limit > 1) {
                res = (limit - 2) * dfs2(num, idx + 1, 1, dp) % MOD;
                res = (res + dfs2(num, idx + 1, 0, dp)) % MOD;
            }


        }
        return dp[idx][seenSmaller] = res;
    }

    private static int dfs(char[] num, int idx, int mask, int k, int seenSmaller, int[][][] dp) {
        if (idx == num.length) {
            return Integer.bitCount(mask) == k ? 1 : 0;
        }
        if (dp[idx][mask][seenSmaller] != -1) {
            return dp[idx][mask][seenSmaller];
        }
        final int limit;
        if (num[idx] >= 'A') {
            limit = num[idx] - 'A' + 10;
        } else {
            limit = num[idx] - '0';
        }
        int res = 0;
        if (seenSmaller == 0) {
            for (int i = 0; i <= limit; i++) {
                int nextMask = mask;
                if (i == 0) {
                    if (Integer.bitCount(mask) > 0) {
                        nextMask = mask | 1;
                    }
                } else {
                    nextMask = mask | (1 << i);
                }
                res = (res + dfs(num, idx + 1, nextMask, k, i != limit ? 1 : 0, dp)) % MOD;
            }
        } else {
            for (int i = 0; i < 16; i++) {
                int nextMask = mask;
                if (i == 0) {
                    if (Integer.bitCount(mask) > 0) {
                        nextMask = mask | 1;
                    }
                } else {
                    nextMask = mask | (1 << i);
                }
                res = (res + dfs(num, idx + 1, nextMask, k, 1, dp)) % MOD;
            }
        }
        return dp[idx][mask][seenSmaller] = res;
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
