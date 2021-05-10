package atcoder.regular_100_199.arc_118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    static int aSum;
    static int bSum;

    static long[] b;
    static int[][] o;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int k = fs.nextInt();
        aSum = fs.nextInt();
        bSum = fs.nextInt();
        b = new long[k];
        o = new int[k][];
        long rem = bSum;
        final int[] arr = fs.nextIntArray(k);
        for (int i = 0; i < k; i++) {
            final long num = (long) arr[i] * bSum;
            final long den = aSum;
            b[i] = num / den;
            o[i] = new int[] { (int) (num % den), i };
            rem -= b[i];
        }
        Arrays.sort(o, Comparator.comparingInt(val -> val[0]));
        final int whole = (int) (rem / k);
        rem %= k;
        for (int i = 0; i < k; i++) {
            b[i] += whole;
        }
        for (int i = 0; i < rem; i++) {
            ++b[o[k - i - 1][1]];
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(b[i]);
            sb.append(' ');
        }
        System.out.println(sb);
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
