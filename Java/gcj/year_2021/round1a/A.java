package gcj.year_2021.round1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 1; test <= t; test++) {
            final int n = fs.nextInt();
            final BigInteger[] arr = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new BigInteger(fs.next());
            }
            long res = 0;
            for (int i = 0; i < n - 1; i++) {
                final BigInteger next = getNext(arr[i], arr[i + 1]);
                res += next.toString().length() - arr[i + 1].toString().length();
                arr[i + 1] = next;
            }
            System.out.println("Case #" + test + ": " + res);
        }
    }

    private static BigInteger getNext(BigInteger l, BigInteger r) {
        if (l.compareTo(r) < 0) {
            return r;
        }
        final String ll = l.toString();
        final String rr = r.toString();
        if (ll.length() == rr.length()) {
            return r.multiply(BigInteger.TEN);
        }
        final int diff = ll.length() - rr.length();
        final StringBuilder t1 = new StringBuilder(rr);
        final StringBuilder t2 = new StringBuilder(rr);
        final StringBuilder t3 = new StringBuilder(rr);
        for (int i = 0; i < diff; i++) {
            t1.append('0');
            t2.append('9');
        }
        //noinspection StringRepeatCanBeUsed
        for (int i = 0; i <= diff; i++) {
            t3.append('0');
        }
        final BigInteger low = new BigInteger(t1.toString());
        final BigInteger high = new BigInteger(t2.toString());
        if (low.compareTo(l) > 0) {
            return low;
        }
        if (l.compareTo(high) < 0) {
            return l.add(BigInteger.ONE);
        }
        return new BigInteger(t3.toString());
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
