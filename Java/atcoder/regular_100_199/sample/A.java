package atcoder.regular_100_199.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    private static int[] sieveOfEratosthenes() {
        final int n = 100;
        final boolean[] prime = new boolean[n + 1];
        final int[] smallestDiv = new int[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    if (smallestDiv[i] == 0) {
                        smallestDiv[i] = p;
                    }
                    prime[i] = false;
                }
            }
        }
        return smallestDiv;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        final int[] sd = sieveOfEratosthenes();
        final List<Integer> valid = new ArrayList<>();
        for (int i = 2; i < 52; i++) {
            if (sd[i] == 0) {
                valid.add(i);
            }
        }
        long res = Long.MAX_VALUE;
        for (int mask = 0; mask < (1 << valid.size()); mask++) {
            boolean ok = true;
            outer:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < valid.size(); j++) {
                    if ((mask & (1 << j)) != 0) {
                        if (arr[i] % valid.get(j) == 0) {
                            continue outer;
                        }
                    }
                }
                ok = false;
                break;
            }
            if (ok) {
                long lcm = 1;
                for (int j = 0; j < valid.size(); j++) {
                    if ((mask & (1 << j)) != 0) {
                        lcm *= valid.get(j);

                    }
                }
                res = Math.min(res, lcm);
            }
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
