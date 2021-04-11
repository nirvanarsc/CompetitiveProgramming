package codeforces.round_700_749.round_713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        outer:
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n + 2);
            long sum = 0;
            for (int num : arr) {
                sum += num;
            }
            final int[] sorted = arr.clone();
            Utils.shuffleSort(sorted);
            for (int i = 0; i < sorted.length; i++) {
                if (i == sorted.length - 1) {
                    if (sum - sorted[i] == 2L * sorted[sorted.length - 2]) {
                        final StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < sorted.length; j++) {
                            if (j != i && j != (sorted.length - 2)) {
                                sb.append(sorted[j]);
                                sb.append(' ');
                            }
                        }
                        System.out.println(sb);
                        continue outer;
                    }
                } else {
                    if (sum - sorted[i] == 2L * sorted[sorted.length - 1]) {
                        final StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < sorted.length; j++) {
                            if (j != i && j != (sorted.length - 1)) {
                                sb.append(sorted[j]);
                                sb.append(' ');
                            }
                        }
                        System.out.println(sb);
                        continue outer;
                    }
                }
            }
            System.out.println(-1);
        }
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
