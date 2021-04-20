package codeforces.round_700_749.round_716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long[] bezout(long a, long b) {
        if (b == 0) {
            return new long[] { 1, 0 };
        }
        final long[] res = bezout(b, a % b);
        return new long[] { res[1], res[0] - a / b * res[1] };
    }

    private static long modInverse(long a, long mod) {
        return (a + mod) % mod;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        long total = 1;
        final boolean[] added = new boolean[n];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (gcd(i, n) == 1) {
                count++;
                added[i] = true;
                total = (total * i) % n;
            }
        }
        if (total != 1) {
            for (int i = 0; i < n; i++) {
                if (added[i]) {
                    final long modInverse = modInverse(bezout(i, n)[0], n);
                    if ((modInverse * total) % n == 1) {
                        count--;
                        added[i] = false;
                        break;
                    }
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(count);
        sb.append('\n');
        for (int i = 0; i < n; i++) {
            if (added[i]) {
                sb.append(i);
                sb.append(' ');
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
