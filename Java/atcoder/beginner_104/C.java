package atcoder.beginner_104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int D = fs.nextInt();
        final int G = fs.nextInt();
        final int[] p = new int[11];
        final int[] bonus = new int[11];
        for (int i = 0; i < D; ++i) {
            p[i] = fs.nextInt();
            bonus[i] = fs.nextInt();
        }
        int res = (int) 1e9;
        for (int mask = 0; mask < (1 << D); ++mask) {
            int s = 0, num = 0, remMax = -1;
            for (int i = 0; i < D; ++i) {
                if ((mask >> i & 1) != 0) {
                    s += 100 * (i + 1) * p[i] + bonus[i];
                    num += p[i];
                } else {
                    remMax = i;
                }
            }
            if (s < G) {
                final int s1 = 100 * (remMax + 1);
                final int need = (G - s + s1 - 1) / s1;
                if (need >= p[remMax]) {
                    continue;
                }
                num += need;
            }
            res = Math.min(res, num);
        }
        System.out.println(res);
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
