package codeforces.round_700_749.round_725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("SuspiciousNameCombination")
public final class G {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            int x = fs.nextInt();
            int y = fs.nextInt();
            int a = fs.nextInt();
            int b = fs.nextInt();
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
                temp = x;
                x = y;
                y = temp;
            }
            if (a == b) {
                System.out.println(Math.min(x, y) / a);
                continue;
            }
            // N uses a red, b blue
            // M uses b red, a blue
            // Na + Mb <= x
            // Nb + Ma <= y
            // https://en.wikipedia.org/wiki/Cramer's_rule#Explicit_formulas_for_small_systems
            // intersection point: mid = (yb - xa) / (b^2 - a^2)
            long ret = 0;
            for (long d = -2; d <= 2; d++) {
                long mid = ((long) y * b - (long) x * a) / ((long) b * b - (long) a * a) + d;
                mid = Math.max(mid, 0L);
                mid = Math.min(mid, x / a);
                mid = Math.min(mid, y / b);
                ret = Math.max(ret, f(mid, x, y, a, b));
            }
            System.out.println(ret);
        }
    }

    private static long f(long mid, int x, int y, int a, int b) {
        final long remX = x - mid * a;
        final long remY = y - mid * b;
        return mid + Math.min(remX / b, remY / a);
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
