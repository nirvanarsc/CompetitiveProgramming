package atcoder.beginner_200_299.abc_202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    // k-th lexicographical permutation
    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int[] f = fs.nextIntArray(2);
        long k = fs.nextLong();
        final int a = f[0];
        final int b = f[1];
        final BigInteger[] total = new BigInteger[a + b + 1];
        final BigInteger[] af = new BigInteger[a + 1];
        final BigInteger[] bf = new BigInteger[b + 1];
        total[0] = af[0] = bf[0] = BigInteger.ONE;
        for (int i = 1; i <= a + b; i++) {
            total[i] = total[i - 1].multiply(BigInteger.valueOf(i));
        }
        for (int i = 1; i <= a; i++) {
            af[i] = af[i - 1].multiply(BigInteger.valueOf(i));
        }
        for (int i = 1; i <= b; i++) {
            bf[i] = bf[i - 1].multiply(BigInteger.valueOf(i));
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (a + b); i++) {
            long sum = 0;
            for (int j = 0; j < 2; j++) {
                if (f[j] == 0) {
                    continue;
                }
                f[j]--;
                final long curr = total[f[0] + f[1]].divide(af[f[0]]).divide(bf[f[1]]).longValue();
                sum += curr;
                if (sum >= k) {
                    sb.append((char) (j + 'a'));
                    k -= sum - curr;
                    break;
                }
                f[j]++;
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
