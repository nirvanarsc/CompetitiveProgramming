package atcoder.beginner_178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("UtilityClassWithoutPrivateConstructor")
public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final long[] x = new long[n];
        final long[] y = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = fs.nextLong();
            y[i] = fs.nextLong();
        }
        System.out.println(maxAbsValExpr(x, y));
    }

    public static long maxAbsValExpr(long[] x, long[] y) {
        final int n = x.length;
        long ans = 0;
        long maxmm = (long) -5e18;
        long maxmp = (long) -5e18;
        long maxpm = (long) -5e18;
        long maxpp = (long) -5e18;
        for (int i = 0; i < n; i++) {
            maxmm = Math.max(maxmm, -x[i] - y[i]);
            maxmp = Math.max(maxmp, -x[i] + y[i]);
            maxpm = Math.max(maxpm, x[i] - y[i]);
            maxpp = Math.max(maxpp, x[i] + y[i]);
            ans = Math.max(ans, maxmm - (-x[i] - y[i]));
            ans = Math.max(ans, maxmp - (-x[i] + y[i]));
            ans = Math.max(ans, maxpm - (x[i] - y[i]));
            ans = Math.max(ans, maxpp - (x[i] + y[i]));
        }
        return ans;
    }

    static final class Util {
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

        private Util() {}
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
