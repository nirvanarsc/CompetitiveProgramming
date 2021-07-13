package codeforces.round_600_649.round_641;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class C_2 {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final boolean[] sieve = sieveOfEratosthenes();
        final List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = fs.nextInt();
            for (int p : primes) {
                int count = 0;
                while (num % p == 0) {
                    count++;
                    num /= p;
                }
                if (count > 0) {
                    g.computeIfAbsent(p, val -> new ArrayList<>()).add(count);
                }
                if (num == 1) {
                    break;
                }
                if (sieve[num]) {
                    g.computeIfAbsent(num, val -> new ArrayList<>()).add(1);
                    break;
                }
            }
        }
        long res = 1;
        for (Map.Entry<Integer, List<Integer>> e : g.entrySet()) {
            final List<Integer> val = e.getValue();
            val.sort(Comparator.naturalOrder());
            final int zero = n - val.size();
            if (zero > 1) {
                continue;
            }
            res *= Math.pow(e.getKey(), val.get(1 - zero));
        }
        System.out.println(res);
    }

    private static boolean[] sieveOfEratosthenes() {
        final int n = (int) 2e5;
        final boolean[] prime = new boolean[n + 5];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
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
