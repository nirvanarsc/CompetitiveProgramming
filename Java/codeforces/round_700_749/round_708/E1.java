package codeforces.round_700_749.round_708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public final class E1 {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final Set<Integer> squares = new HashSet<>();
        for (int i = 1; i * i < (int) 1e7; i++) {
            squares.add(i * i);
        }
        final StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int k = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            int res = 1;
            final Set<Integer> curr = new HashSet<>();
            boolean hasSquare = false;
            for (int i = 0; i < n; i++) {
                int tt = arr[i];
                if (squares.contains(tt) && hasSquare) {
                    res++;
                    curr.clear();
                    curr.add(tt);
                } else if (squares.contains(tt)) {
                    hasSquare = true;
                } else {
                    int num = 1;
                    for (int p = 2; p * p <= arr[i]; p++) {
                        if (tt % p == 0) {
                            int count = 0;
                            while (tt % p == 0) {
                                tt /= p;
                                count++;
                            }
                            if (count % 2 != 0) {
                                num *= p;
                            }
                        }
                    }
                    num *= tt;
                    if (!curr.add(num)) {
                        res++;
                        hasSquare = false;
                        curr.clear();
                        curr.add(num);
                    }
                }
            }
            sb.append(res);
            sb.append('\n');
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
