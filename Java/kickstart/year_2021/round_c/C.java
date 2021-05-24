package kickstart.year_2021.round_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    static int w;
    static int e;
    static double[][][] dp;
    static boolean[][][] seen;
    static StringBuilder sb;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final int x = fs.nextInt();
        dp = new double[65][65][65];
        sb = new StringBuilder();
        for (int test = 1; test <= t; test++) {
            w = fs.nextInt();
            e = fs.nextInt();
            seen = new boolean[65][65][65];
            dfs(0, 0, 0);
            sb.setLength(0);
            getString(0, 0, 0);
            System.out.println("Case #" + test + ": " + sb);
        }
    }

    private static double dfs(int r, int s, int p) {
        final int day = r + s + p;
        if (day == 60) {
            return 0;
        }
        if (seen[r][s][p]) {
            return dp[r][s][p];
        }
        double res = 0;
        double pR = 1 / 3.0;
        double pS = 1 / 3.0;
        double pP = 1 / 3.0;
        if (day > 0) {
            pR = (double) s / day;
            pS = (double) p / day;
            pP = (double) r / day;
        }
        res = Math.max(res, w * pS + e * pR + dfs(r + 1, s, p));
        res = Math.max(res, w * pP + e * pS + dfs(r, s + 1, p));
        res = Math.max(res, w * pR + e * pP + dfs(r, s, p + 1));
        seen[r][s][p] = true;
        return dp[r][s][p] = res;
    }

    private static void getString(int r, int s, int p) {
        final int day = r + s + p;
        if (day == 60) {
            return;
        }
        double pR = 1 / 3.0;
        double pS = 1 / 3.0;
        double pP = 1 / 3.0;
        if (day > 0) {
            pR = (double) s / day;
            pS = (double) p / day;
            pP = (double) r / day;
        }
        double curr = -1;
        char c = '*';
        if (Double.compare(w * pS + e * pR + dp[r + 1][s][p], curr) > 0) {
            curr = w * pS + e * pR + dp[r + 1][s][p];
            c = 'R';
        }
        if (Double.compare(w * pP + e * pS + dp[r][s + 1][p], curr) > 0) {
            curr = w * pP + e * pS + dp[r][s + 1][p];
            c = 'S';
        }
        if (Double.compare(w * pR + e * pP + dp[r][s][p + 1], curr) > 0) {
            c = 'P';
        }
        sb.append(c);
        getString(r + (c == 'R' ? 1 : 0), s + (c == 'S' ? 1 : 0), p + (c == 'P' ? 1 : 0));
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
