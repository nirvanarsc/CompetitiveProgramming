package atcoder.regular_100_199.arc_122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        if (n < 3) {
            System.out.println((n * arr[0]) % MOD);
            return;
        }
        final long[] up = new long[n - 1];
        final long[] down = new long[n - 1];
        for (int i = 0; i < up.length; i++) {
            if (i == 0) {
                up[0] = 1;
            } else if (i == 1) {
                up[1] = 2;
            } else {
                up[i] = (up[i - 1] + up[i - 2]) % MOD;
            }
        }
        for (int i = 0; i < down.length; i++) {
            if (i == 0) {
                down[0] = 1;
            } else if (i == 1) {
                down[1] = 1;
            } else {
                down[i] = (down[i - 1] + down[i - 2]) % MOD;
            }
        }
        final long total = up[n - 3] + up[n - 2];
        long res = (total * arr[0]) % MOD;
        for (int i = 0, j = up.length - 1; i < up.length; i++, j--) {
            final long top = (up[i] * up[j]) % MOD;
            final long bot = (down[i] * down[j]) % MOD;
            final long coeff = (top - bot + MOD) % MOD;
            final long add = coeff * arr[i + 1] % MOD;
            res = (res + add) % MOD;
        }
        System.out.println(res);
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
