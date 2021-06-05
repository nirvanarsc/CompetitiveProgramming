package codeforces.educational.educational_110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final char[] w = fs.next().toCharArray();
            final int n = w.length;
            final int[] seen = new int[n];
            long res = 0;
            for (int i = 0; i < n; i++) {
                int c = i % 2;
                if (w[i] - '0' == c || w[i] == '?') {
                    int j = i;
                    while (j < n && (w[j] - '0' == c || w[j] == '?')) {
                        seen[j++]++;
                        c ^= 1;
                    }
                    res += f(j - i);
                    i = j - 1;
                }
            }
            for (int i = 0; i < n; i++) {
                int c = (i + 1) % 2;
                if (w[i] - '0' == c || w[i] == '?') {
                    int j = i;
                    while (j < n && (w[j] - '0' == c || w[j] == '?')) {
                        seen[j++]++;
                        c ^= 1;
                    }
                    res += f(j - i);
                    i = j - 1;
                }
            }
            for (int i = 0; i < n; i++) {
                if (seen[i] == 2) {
                    int j = i;
                    while (j < n && seen[j] == 2) {
                        j++;
                    }
                    res -= f(j - i);
                    i = j - 1;
                }
            }
            System.out.println(res);
        }
    }

    private static long f(long n) {
        return (n * (n + 1)) / 2;
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
