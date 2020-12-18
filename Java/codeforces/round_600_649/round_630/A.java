package codeforces.round_600_649.round_630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int a = fs.nextInt();
            final int b = fs.nextInt();
            final int c = fs.nextInt();
            final int d = fs.nextInt();
            final int x = fs.nextInt();
            final int y = fs.nextInt();
            final int x1 = fs.nextInt();
            final int y1 = fs.nextInt();
            final int x2 = fs.nextInt();
            final int y2 = fs.nextInt();
            boolean ok = true;
            final int diff1 = Math.abs(a - b);
            final int diff2 = Math.abs(c - d);
            if (x2 - x1 == 0 && (a > 0 || b > 0)) {
                ok = false;
            }
            if (y2 - y1 == 0 && (c > 0 || d > 0)) {
                ok = false;
            }
            if (a > b) {
                ok &= (x - x1) >= diff1;
            } else {
                ok &= (x2 - x) >= diff1;
            }
            if (c > d) {
                ok &= (y - y1) >= diff2;
            } else {
                ok &= (y2 - y) >= diff2;
            }
            System.out.println(ok ? "Yes" : "No");
        }
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
