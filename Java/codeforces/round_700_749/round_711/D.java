package codeforces.round_700_749.round_711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final int m = fs.nextInt();
        boolean[] seen = new boolean[m + 1];
        final int[] res = new int[m + 1];
        Arrays.fill(res, -1);
        seen[0] = true;
        final StringBuilder sb = new StringBuilder();
        for (int time = 1; time <= t; time++) {
            final boolean[] next = seen.clone();
            final int type = fs.nextInt();
            final long x = fs.nextLong();
            final int y = fs.nextInt();
            for (int i = 0; i <= m; i++) {
                if (seen[i]) {
                    long curr = f(type, i, x);
                    for (int a = 1; a <= y; a++) {
                        if (curr > m || seen[(int) curr]) {
                            break;
                        }
                        next[(int) curr] = true;
                        res[(int) curr] = time;
                        curr = f(type, curr, x);
                    }
                }
            }
            seen = next;
        }
        for (int i = 1; i <= m; i++) {
            sb.append(res[i]);
            sb.append(' ');
        }
        System.out.println(sb);
    }

    private static long f(long t, long curr, long x) {
        if (t == 1) {
            return curr + ceil(x, (long) 1e5);
        }
        return ceil(curr * x, (long) 1e5);
    }

    private static long ceil(long a, long b) {
        return (a + b - 1) / b;
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
