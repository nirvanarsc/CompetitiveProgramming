package codeforces.round_700_749.round_741;

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
        final StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int q = fs.nextInt();
            final char[] w = fs.next().toCharArray();
            final int[] pre1 = new int[n + 1];
            final int[] pre2 = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                final int curr;
                if (i % 2 != 0) {
                    if (w[i - 1] == '+') {
                        curr = 1;
                    } else {
                        curr = -1;
                    }
                } else {
                    if (w[i - 1] == '+') {
                        curr = -1;
                    } else {
                        curr = 1;
                    }
                }
                if (curr < 0) {
                    pre1[i] = pre1[i - 1];
                    pre2[i] = pre2[i - 1] + 1;
                } else {
                    pre1[i] = pre1[i - 1] + 1;
                    pre2[i] = pre2[i - 1];
                }
            }
            for (int i = 0; i < q; i++) {
                final int l = fs.nextInt() - 1;
                final int r = fs.nextInt();
                final int pp = pre1[r] - pre1[l];
                final int nn = pre2[r] - pre2[l];
                int res = Math.abs(pp - nn) / 2;
                if ((pp + nn) % 2 == 0) {
                    if (res > 0) {
                        res = Math.max(res, 2);
                    }
                } else {
                    if (res == 0) {
                        res++;
                    }
                }
                sb.append(res).append('\n');
            }
        }
        System.out.println(sb);
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
