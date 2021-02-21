package atcoder.beginner_100_199.beginner_192;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final String x = fs.next();
        final BigInteger m = new BigInteger(fs.next());
        int d = 0;
        for (int i = 0; i < x.length(); i++) {
            d = Math.max(d, x.charAt(i) - '0');
        }
        if (x.length() == 1) {
            if (Integer.valueOf(x) <= m.longValue()) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }
        long lo = 1;
        long hi = (long) 1e18;
        while (lo < hi) {
            final long mid = lo + hi + 1 >>> 1;
            final BigInteger base = BigInteger.valueOf(mid);
            BigInteger curr = BigInteger.ZERO;
            boolean ok = true;
            for (int i = 0; i < x.length(); i++) {
                curr = curr.multiply(base).add(BigInteger.valueOf(x.charAt(i) - '0'));
                if (curr.compareTo(m) > 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(Math.max(0, lo - d));
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

