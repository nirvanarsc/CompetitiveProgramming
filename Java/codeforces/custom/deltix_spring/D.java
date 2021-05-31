package codeforces.custom.deltix_spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int p = fs.nextInt();
        final int[] f = new int[m];
        final char[][] g = new char[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = fs.next().toCharArray();
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '1') {
                    f[j]++;
                }
            }
        }
        char[] best = new char[m];
        for (int i = 0; i < m; i++) {
            best[i] = '0';
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (f[i] >= (n + 1) / 2) {
                final char[] curr = new char[m];
                for (char[] row : g) {
                    if (row[i] == '1') {
                        for (int k = 0; k < m; k++) {
                            if (row[k] == '1') {
                                curr[k]++;
                            }
                        }
                    }
                }
                final char[] currMask = new char[m];
                int set = 0;
                for (int j = 0; j < m; j++) {
                    if (curr[j] >= (n + 1) / 2) {
                        currMask[j] = '1';
                        set++;
                    } else {
                        currMask[j] = '0';
                    }
                }
                if (set > max && set < 15) {
                    max = set;
                    best = currMask;
                }
            }
        }

        System.out.println(best);
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
