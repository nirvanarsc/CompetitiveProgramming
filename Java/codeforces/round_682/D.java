package codeforces.round_682;

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
        final int[] arr = fs.nextIntArray(n);
        int totalXor = 0;
        for (int i = 0; i < n; i++) {
            totalXor ^= arr[i];
        }
        if (n % 2 == 0 && totalXor != 0) {
            System.out.println("NO");
            return;
        }
        final int last = n - 1;
        final int times = last / 2;
        System.out.println("YES");
        System.out.println(2 * times);
        for (int i = 0, j = 0; i < times; i++, j += 2) {
            final int xor = arr[j] ^ arr[j + 1] ^ arr[last];
            arr[j] = arr[j + 1] = arr[last] = xor;
            System.out.print((j + 1) + " " + (j + 2) + ' ' + (last + 1) + ' ');
        }
        for (int i = 0, j = 0; i < times; i++, j += 2) {
            arr[j] = arr[j + 1] = arr[last];
            System.out.print((j + 1) + " " + (j + 2) + ' ' + (last + 1) + ' ');
        }
        System.out.println();
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
