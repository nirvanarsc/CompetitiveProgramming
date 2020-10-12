package codeforces.round_673;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            int mostFreq = 0;
            int mostFreqEleme = 0;
            final Map<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < n; i++) {
                final int newfreq = freq.merge(arr[i], 1, Integer::sum);
                if (mostFreq < newfreq) {
                    mostFreq = newfreq;
                    mostFreqEleme = arr[i];
                }
            }
            if (mostFreq == 1) {
                int[] res = new int[n];
                if (n % 2 == 0) {
                    for (int i = 0; i < n / 2; i++) {
                        res[i] = -1;
                    }
                    res[n / 2] = Math.min(arr[n / 2], arr[n / 2 - 1]);
                    for (int i = n / 2 + 1, j = 3; i < n; i++, j += 2) {
                        System.out.println(arr[i] + " " + arr[i - j]);
                        res[i] = Math.min(res[i - 1], Math.min(arr[i], arr[i - j]));
                    }
                } else {
                    for (int i = 0; i < n / 2; i++) {
                        res[i] = -1;
                    }
                    res[n / 2] = Math.min(arr[n / 2], arr[n / 2]);
                    for (int i = n / 2 + 1, j = 2; i < n; i++, j += 2) {
                        System.out.println(arr[i] + " " + arr[i - j]);
                        res[i] = Math.min(res[i - 1], Math.min(arr[i], arr[i - j]));
                    }
                }
                for (int i = 0; i < n; i++) {
                    System.out.print(res[i] + " ");
                }
                System.out.println();
            } else {
                
            }

            System.out.println(n);
        }
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
