package atcoder.beginner_200_299.abc_201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final char[] w = fs.next().toCharArray();
        int must = 0;
        int q = 0;
        for (int i = 0; i < w.length; i++) {
            if (w[i] == 'o') {
                must |= 1 << i;
            } else if (w[i] == '?') {
                q |= 1 << i;
            }
        }
        int res = 0;
        for (int i = 10000; i < 20000; i++) {
            final String c = String.valueOf(i);
            int curr = 0;
            for (int j = 1; j < c.length(); j++) {
                curr |= 1 << (c.charAt(j) - '0');

            }
            boolean ok = true;
            for (int j = 0; j < 10; j++) {
                final boolean mustSet = (must & (1 << j)) != 0;
                final boolean currSet = (curr & (1 << j)) != 0;
                final boolean qSet = (q & (1 << j)) != 0;
                if (mustSet && !currSet) {
                    ok = false;
                    break;
                }
                if (!mustSet && currSet && !qSet) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                res++;
            }
        }
        System.out.println(res);
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
