package gcj.year_2021.round1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 1; test <= t; test++) {
            final int m = fs.nextInt();
            final int[][] p = new int[m][2];
            int sum = 0;
            for (int i = 0; i < m; i++) {
                final int u = fs.nextInt();
                final int v = fs.nextInt();
                p[i] = new int[] { u, v };
                sum += u * v;
            }
            final boolean[] ok = new boolean[1 << 16];
            final int[] tt = new int[1 << 16];
            ok[1] = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p[i][1]; j++) {
                    for (int k = ok.length - 1; k >= 1; k--) {
                        if (k * p[i][0] < ok.length) {
                            tt[k * p[i][0]] = tt[k] + p[i][0];
                            ok[k * p[i][0]] = ok[k];
                        }
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < ok.length; i++) {
                if (ok[i] && sum - i == tt[i]) {
                    res = Math.max(res, i);
                }
            }
            System.out.println("Case #" + test + ": " + res);
        }
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
