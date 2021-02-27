package atcoder.beginner_100_199.beginner_193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int i = 0; i < t; i++) {
            final int x = fs.nextInt();
            final int y = fs.nextInt();
            final int p = fs.nextInt();
            final int q = fs.nextInt();
            final long p1 = 2 * (x + y);
            final long p2 = p + q;
            long res = Long.MAX_VALUE;
            for (int t1 = x; t1 < x + y; t1++) {
                for (int t2 = p; t2 < p + q; t2++) {
                    final long crt = crt(p1, t1, p2, t2);
                    if (crt != -1) {
                        res = Math.min(res, crt);
                    }
                }

            }
            System.out.println(res == Long.MAX_VALUE ? "infinity" : res);
        }
    }

    private static long crt(long p, long m, long q, long n) {
        if (p < q) {
            return crt(q, n, p, m);
        }
        long a = p, b = q;
        long pp = 1, qq = 0;
        while (b > 0) {
            final long c = a / b;
            long d;
            d = a;
            a = b;
            b = d % b;
            d = pp;
            pp = qq;
            qq = d - c * qq;
        }
        if ((n - m) % a != 0) {
            return -1;
        }
        final long mod = p / a * q;
        long ret = ((n - m) * pp % q) * (p / a) + m;
        if (ret < 0) {
            ret += mod;
        }
        return ret;
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
