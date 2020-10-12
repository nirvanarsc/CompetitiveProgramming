package codeforces.round_675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final char[] s = fs.next().toCharArray();
        final long[] pow10 = new long[s.length];
        final long[] suff = new long[s.length];
        pow10[pow10.length - 1] = 1;
        for (int i = pow10.length - 2, j = 1; i >= 0; i--, j++) {
            pow10[i] = (pow10[i + 1] * 10) % MOD;
            suff[i] = (suff[i + 1] + ((pow10[i + 1] * j) % MOD)) % MOD;
        }
        long res = 0;
        for (int i = 0; i < s.length; i++) {
            final long curr = s[i] - '0';
            res = add(res, mul(curr, mul(pow10[i], nC2(i))));
            res = add(res, mul(curr, suff[i]));
        }
        System.out.println(res);
    }

    private static long nC2(long n) {
        return add(n * (n + 1) / 2, 0);
    }

    private static long add(long a, long b) {
        return ((a + b) % MOD + MOD) % MOD;
    }

    private static long mul(long a, long b) {
        return ((a * b) % MOD + MOD) % MOD;
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
