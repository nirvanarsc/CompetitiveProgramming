package atcoder.beginner_100_199.beginner_144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            g.get(u).add(v);
        }
        final double[] dp = new double[n];
        for (int v = n - 2; v >= 0; v--) {
            double curr = 0;
            for (int u : g.get(v)) {
                curr += dp[u];
            }
            final int deg = g.get(v).size();
            curr /= deg;
            curr += 1;
            dp[v] = curr;
        }
        double res = dp[0];
        for (int nv = 0; nv < n - 1; nv++) {
            if (g.get(nv).size() == 1) {
                continue;
            }
            int nu = g.get(nv).get(0);
            for (int u : g.get(nv)) {
                if (dp[nu] < dp[u]) {
                    nu = u;
                }
            }
            final double[] dp2 = new double[n];
            for (int v = n - 2; v >= 0; v--) {
                double curr = 0;
                for (int u : g.get(v)) {
                    if (v == nv && u == nu) {
                        continue;
                    }
                    curr += dp2[u];
                }
                int deg = g.get(v).size();
                if (v == nv) {
                    deg--;
                }
                curr /= deg;
                curr += 1;
                dp2[v] = curr;
            }
            res = Math.min(res, dp2[0]);
        }
        System.out.printf("%.6f\n", res);
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
