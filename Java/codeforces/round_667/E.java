package codeforces.round_667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int k = fs.nextInt();
            final int[] x = fs.nextIntArray(n);
            final int[] y = fs.nextIntArray(n);
            Util.shuffleSort(x);
            int j = n - 1;
            final int[] l = new int[n];
            final int[] r = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                while (x[j] - x[i] > k) {
                    j--;
                }
                r[i] = j - i + 1;
                if (i + 1 < n) {
                    r[i] = Math.max(r[i], r[i + 1]);
                }
            }
            j = 0;
            for (int i = 0; i < n; i++) {
                while (x[i] - x[j] > k) {
                    j++;
                }
                l[i] = i - j + 1;
                if (i > 0) {
                    l[i] = Math.max(l[i], l[i - 1]);
                }
            }
            int res = 1;
            for (int i = 0; i < n - 1; i++) {
                res = Math.max(res, r[i + 1] + l[i]);
            }
            pw.println(res);
        }
        pw.flush();
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
