package codeforces.round_700_749.round_739;

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
        final String[] pow2 = new String[63];
        long p = 1L;
        for (int i = 0; i < 63; i++) {
            pow2[i] = String.valueOf(p);
            p *= 2L;
        }
        final StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            final String w = fs.next();
            int res = (int) 1e9;
            for (String pp : pow2) {
                res = Math.min(res, minDistance(w, pp));
            }
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }

    private static int minDistance(String curr, String target) {
        int j = 0;
        int i;
        int res = 0;
        for (i = 0; i < target.length() && j < curr.length(); i++) {
            if (curr.charAt(j) != target.charAt(i)) {
                while (j < curr.length() && curr.charAt(j) != target.charAt(i)) {
                    res++;
                    j++;
                }
            }
            if (j == curr.length()) {
                break;
            }
            j++;
        }
        return res + curr.length() - j + target.length() - i;
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
