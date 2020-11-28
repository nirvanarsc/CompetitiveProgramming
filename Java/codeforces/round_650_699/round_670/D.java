package codeforces.round_650_699.round_670;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final PrintWriter pw = new PrintWriter(System.out);
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final long[] arr = new long[n];
        final long[] tmp = fs.nextLongArray(n);
        arr[0] = tmp[0];
        for (int i = 1; i < n; i++) {
            arr[i] = tmp[i] - tmp[i - 1];
        }
        long increasing = 0;
        for (int i = 0; i < n; i++) {
            increasing += value(arr, i);
        }
        final int q = fs.nextInt();
        pw.println(increasing + 1 >> 1);
        for (int i = 0; i < q; i++) {
            final int l = fs.nextInt() - 1;
            final int r = fs.nextInt();
            final long x = fs.nextInt();
            increasing -= value(arr, l);
            arr[l] += x;
            increasing += value(arr, l);
            if (r < n) {
                increasing -= value(arr, r);
                arr[r] -= x;
                increasing += value(arr, r);
            }
            pw.println(increasing + 1 >> 1);
        }
        pw.close();
    }

    public static long value(long[] arr, int ind) {
        if (ind == 0) {
            return arr[0];
        }
        return Math.max(arr[ind], 0);
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
