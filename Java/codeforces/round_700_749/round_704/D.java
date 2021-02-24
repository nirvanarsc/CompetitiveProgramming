package codeforces.round_700_749.round_704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int a = fs.nextInt();
        final int b = fs.nextInt();
        final int k = fs.nextInt();
        if (k == 0) {
            final char[] l = new char[a + b];
            final char[] r = new char[a + b];
            Arrays.fill(l, '0');
            Arrays.fill(r, '0');
            for (int i = 0; i < b; i++) {
                l[i] = r[i] = '1';
            }
            System.out.println("Yes");
            System.out.println(l);
            System.out.println(r);
            return;
        }
        if (a == 0 || b == 1 || k > (a + b - 2)) {
            System.out.println("No");
            return;
        }
        final char[] l = new char[a + b];
        final char[] r = new char[a + b];
        Arrays.fill(l, '0');
        Arrays.fill(r, '0');
        for (int i = 0; i < b; i++) {
            l[i] = r[i] = '1';
        }
        if (0 <= k && k <= a) {
            r[b - 1] = '0';
            r[b + k - 1] = '1';
        } else {
            r[a + b - 1 - k] = '0';
            r[a + b - 1] = '1';
        }
        System.out.println("Yes");
        System.out.println(l);
        System.out.println(r);
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
