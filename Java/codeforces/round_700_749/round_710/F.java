package codeforces.round_700_749.round_710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] r = fs.nextIntArray(n);
            final int[] c = fs.nextIntArray(n);
            final int[][] p = new int[n][2];
            for (int i = 0; i < n; i++) {
                p[i] = new int[] { r[i], c[i] };
            }
            Arrays.sort(p, Comparator.comparingInt(v -> v[0]));
            int cr = 1;
            int cc = 1;
            long res = 0;
            for (int i = 0; i < n; i++) {
                final int tr = p[i][0];
                final int tc = p[i][1];
                res += f(cr, cc, tr, tc);
                cr = tr;
                cc = tc;
            }
            System.out.println(res);
        }
    }

    private static int f(int r1, int c1, int r2, int c2) {
        if (r1 - c1 == r2 - c2) {
            return isRight(r1, c1) ? 0 : r2 - r1;
        }
        r2 -= r1 - 1;
        c2 -= c1 - 1;
        if (isLeft(r1, c1)) {
            return (r2 - c2) / 2;
        } else {
            return (r2 - c2 + 1) / 2;
        }
    }

    private static boolean isLeft(int r, int c) {
        return (r + c) % 2 == 0;
    }

    private static boolean isRight(int r, int c) {
        return (r + c) % 2 != 0;
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
