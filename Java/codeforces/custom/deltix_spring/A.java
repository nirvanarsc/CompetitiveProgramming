package codeforces.custom.deltix_spring;

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
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final char[] w = fs.next().toCharArray();
            final char[] res = w.clone();
            int prev = -1;
            for (int i = 0; i < n; i++) {
                if (w[i] == '1') {
                    final int len;
                    if (prev == -1) {
                        len = Math.min(m, i);
                        for (int j = i - 1, k = 0; k < len; j--, k++) {
                            res[j] = '1';
                        }
                    } else {
                        len = i - prev - 1;
                        final int l = Math.min(m, len / 2);
                        final int r = Math.min(m, len / 2);
                        for (int j = prev + 1, k = 0; k < l; j++, k++) {
                            res[j] = '1';
                        }
                        for (int j = i - 1, k = 0; k < r; j--, k++) {
                            res[j] = '1';
                        }
                        if (2 * m > len && len % 2 != 0) {
                            res[prev + (len / 2) + 1] = '0';
                        }
                    }
                    prev = i;
                }
            }
            if (prev != -1) {
                final int len = Math.min(m, n - prev - 1);
                for (int j = prev + 1, k = 0; k < len; j++, k++) {
                    res[j] = '1';
                }
            }
            System.out.println(res);
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
