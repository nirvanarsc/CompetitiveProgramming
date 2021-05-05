package atcoder.beginner_100_199.beginner_178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    private static final int MOD = (int) (1e9 + 7);

    // https://en.wikipedia.org/wiki/Inclusion%E2%80%93exclusion_principle
    // Answer = (total sequences of length n with all elements <= 9) — (total sequences that do not contain 0 nor 9)
    // first term above is simply pow(10,n) for the second term I used inclusion exclusion:
    // A = Set of sequences that don't contain 0
    // B = Set of sequences that don't contain 9
    // n(A union B) = n(A) + n(B) - n(A intersection B)
    // n(A) = n(B) = pow(9,n)
    // n(A intersection B) = pow(8,n)
    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        long noZero, noNine, noZeroNine;
        final long total = modPow(10, n);
        noNine = noZero = modPow(9, n);
        noZeroNine = modPow(8, n);
        // at least one nine
        noNine = (total - noNine + MOD) % MOD;
        // at least one zero
        noZero = (total - noZero + MOD) % MOD;
        // at least one nine or zero
        noZeroNine = (total - noZeroNine + MOD) % MOD;
        final long res = (noNine + noZero - noZeroNine + MOD) % MOD;
        System.out.println(res);
    }

    private static long modPow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n /= 2;
        }
        return res;
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
