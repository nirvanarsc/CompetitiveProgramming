package codeforces.round_650_699.round_694;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static final int max = (int) (1e6 + 5);
    private static final int[] prime = new int[max];
    // reduce all numbers in the form of k*b^2 to k (3*1^2 => 3, 3*2^2 => 3)
    private static final int[] k = new int[max];

    private static void sieve() {
        for (int i = 1; i < max; i++) {
            k[i] = i;
        }
        for (int p = 2; p < max; p++) {
            if (prime[p] == 0) {
                for (int j = p; j < max; j += p) {
                    prime[j] = 1;
                    final long other = (long) p * p;
                    while (k[j] % other == 0) {
                        k[j] /= other;
                    }
                }
            }
        }
    }

    private static int[] countPairs(int[] arr, int n) {
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.merge(k[arr[i]], 1, Integer::sum);
        }
        int totalMax = 0;
        int even = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            totalMax = Math.max(totalMax, e.getValue());
            if (e.getValue() % 2 == 0 && e.getKey() != 1) {
                even += e.getValue();
            }
        }
        return new int[] { totalMax, even + freq.getOrDefault(1, 0) };
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        sieve();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final int q = fs.nextInt();
            final int[] res = countPairs(arr, n);
            for (int i = 0; i < q; i++) {
                final long c = fs.nextLong();
                pw.println(c == 0L ? res[0] : Math.max(res[0], res[1]));
            }
        }
        pw.close();
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
