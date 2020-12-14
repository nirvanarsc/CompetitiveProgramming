package codeforces.probability;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final double p = Double.parseDouble(fs.next());
        final double q = 1 - p;
        final int t = fs.nextInt();
        final Double[][] dp = new Double[t + 1][n + 1];
        double res = 0.0;
        for (int person = 1; person <= n; person++) {
            double curr = 0;
            curr += dfs(t, person, p, q, dp);
//            System.out.println(curr);
            res += curr * person;
        }
//        System.out.println(dfs(4,1,p,q,dp));
//        System.out.println(dfs(3,1,p,q,dp));
//        System.out.println(dfs(2,1,p,q,dp));
//        System.out.println(dfs(4,1,p,q,dp));
        System.out.printf("%.6f\n", res);
    }

    private static double dfs(int time, int person, double p, double q, Double[][] dp) {
        if (time == 0) {
            return person == 0 ? 1.0 : 0.0;
        }
        if (dp[time][person] != null) {
            return dp[time][person];
        }
        double res = q * dfs(time - 1, person, p, q, dp);
        if (person > 0) {
            res += p * dfs(time - 1, person - 1, p, q, dp);
        }
        return res;
    }

    static final class Utils {
        public static void shuffleSort(int[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffleSort(long[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffle(int[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void shuffle(long[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void swap(int[] x, int i, int j) {
            final int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        public static void swap(long[] x, int i, int j) {
            final long t = x[i];
            x[i] = x[j];
            x[j] = t;
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
