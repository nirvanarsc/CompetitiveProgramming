package codeforces.round_672;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    static long res;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            res = 0;
            final int n = fs.nextInt();
            final int q = fs.nextInt();
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                update(i, fs.nextInt(), arr);
            }
            pw.println(res);
            for (int i = 0; i < q; i++) {
                final int from = fs.nextInt() - 1;
                final int to = fs.nextInt() - 1;
                final int temp = arr[from];
                update(from, arr[to], arr);
                update(to, temp, arr);
                pw.println(res);
            }
        }
        pw.close();
    }

    private static void update(int idx, int val, int[] arr) {
        res -= arr[0];
        if (idx > 0) { res -= Math.max(0, arr[idx] - arr[idx - 1]); }
        if (idx + 1 < arr.length) { res -= Math.max(0, arr[idx + 1] - arr[idx]); }
        arr[idx] = val;
        if (idx > 0) { res += Math.max(0, arr[idx] - arr[idx - 1]); }
        if (idx + 1 < arr.length) { res += Math.max(0, arr[idx + 1] - arr[idx]); }
        res += arr[0];
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
