package codeforces.round_700_749.round_705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static final int MOD = (int) (1e9 + 7);

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final int max = (int) (2e5 + 5);
        final List<List<Integer>> primes = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            primes.add(new ArrayList<>());
        }
        final Map<Integer, Map<Integer, Integer>> counter = new HashMap<>();
        final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        final boolean[] seen = new boolean[max];
        for (int i = 2; i < max; i++) {
            int curr = i;
            for (int p = 2; p * p <= curr; p++) {
                while (curr % p == 0) {
                    if (!seen[p]) {
                        seen[p] = true;
                        counter.put(p, new HashMap<>());
                    }
                    primes.get(i).add(p);
                    curr /= p;
                }
            }
            if (curr > 1) {
                if (!seen[curr]) {
                    seen[curr] = true;
                    counter.put(curr, new HashMap<>());
                }
                primes.get(i).add(curr);
            }
        }
        int gcd = 0;
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
            final int curr = fs.nextInt();
            gcd = gcd(gcd, curr);
            for (int f : primes.get(curr)) {
                final int count = map.get(i).merge(f, 1, Integer::sum);
                counter.get(f).merge(count, 1, Integer::sum);
            }
        }
        long currGcd = gcd;
        for (int i = 0; i < q; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt();
            for (int f : primes.get(v)) {
                final int count = map.get(u).merge(f, 1, Integer::sum);
                final int size = counter.get(f).merge(count, 1, Integer::sum);
                if (size == n) {
                    currGcd = (currGcd * f) % MOD;
                }
            }
            pw.println(currGcd);
        }
        pw.close();
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
