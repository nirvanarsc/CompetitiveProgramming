package codeforces.round_650_699.round_688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final StringBuilder pw = new StringBuilder();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] res = new int[10];
            final int[] yl = new int[10];
            final int[] yr = new int[10];
            final int[] xl = new int[10];
            final int[] xr = new int[10];
            Arrays.fill(yl, (int) 1e9);
            Arrays.fill(xl, (int) 1e9);
            final char[][] grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                grid[i] = fs.next().toCharArray();
                for (int j = 0; j < n; j++) {
                    final int curr = grid[i][j] - '0';
                    xl[curr] = Math.min(xl[curr], i);
                    xr[curr] = Math.max(xr[curr], i);
                    yl[curr] = Math.min(yl[curr], j);
                    yr[curr] = Math.max(yr[curr], j);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    final int curr = grid[i][j] - '0';
                    final int a1 = Math.max(n - j - 1, j) * Math.max(xr[curr] - i, i - xl[curr]);
                    final int a2 = Math.max(n - i - 1, i) * Math.max(yr[curr] - j, j - yl[curr]);
                    res[curr] = Math.max(res[curr], Math.max(a1, a2));
                }
            }
            for (int i = 0; i < 10; i++) {
                pw.append(res[i]);
                pw.append(' ');
            }
            pw.append('\n');
        }
        System.out.println(pw);
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
