package codeforces.round_700_749.round_725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    static List<Integer> primes;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final StringBuilder sb = new StringBuilder();
        final int t = fs.nextInt();
        final boolean[] sieve = sieveOfEratosthenes();
        primes = new ArrayList<>();
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        for (int test = 0; test < t; test++) {
            final long a = fs.nextLong();
            final long b = fs.nextLong();
            final long k = fs.nextLong();
            final int l;
            if (a % b == 0 ^ b % a == 0) {
                l = 1;
            } else {
                l = 2;
            }
            final long r = f(a) + f(b);
            if (l <= k && k <= r) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static long f(long n) {
        int res = 0;
        for (int p : primes) {
            if (p > n) {
                break;
            }
            while (n % p == 0) {
                res++;
                n /= p;
            }
        }
        if (n > 1) {
            res++;
        }
        return res;
    }

    private static boolean[] sieveOfEratosthenes() {
        final int n = 32000;
        final boolean[] prime = new boolean[n + 1];
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
