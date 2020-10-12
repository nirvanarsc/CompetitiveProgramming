package atcoder.beginner_178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int[] a = fs.nextIntArray(n);
        final int[] b = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            b[i] = fs.nextInt();
        }
        int c = -1;
        for (int i = 0; i < n; ++i) {
            if (a[i] == b[i]) {
                c = a[i];
                break;
            }
        }
        int l = 0;
        for (int i = 0; i < n; ++i) {
            if (a[i] == c && b[i] == c) {
                l = i;
                break;
            }
        }
        int r = -1;
        for (int i = n - 1; i >= 0; --i) {
            if (a[i] == c && b[i] == c) {
                r = i;
                break;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (a[i] != c && b[i] != c && l <= r) {
                final int temp = b[l];
                b[l] = b[i];
                b[i] = temp;
                ++l;
            }
        }
        if (l <= r) {
            pw.println("No");
            pw.close();
            return;
        }
        pw.println("Yes");
        for (int i = 0; i < n; ++i) {
            pw.print(b[i] + " ");
        }
        pw.println();
        pw.close();
    }

    static final class Util {
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

        private Util() {}
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
