package codeforces.sit_star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class I {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] pairs = new int[n][2];
        final int[] freq1 = new int[2 * n + 5];
        final int[] freq2 = new int[2 * n + 5];
        int res = (int) 1e9;
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] { fs.nextInt(), fs.nextInt() };
            if (pairs[i][0] == pairs[i][1]) {
                freq1[pairs[i][0]]++;
            } else {
                freq1[pairs[i][0]]++;
                freq1[pairs[i][1]]++;
            }
            freq2[pairs[i][0]]++;
            freq2[pairs[i][1]]++;
        }
        for (int[] p : pairs) {
            if (p[0] == p[1]) {
                res = Math.min(res, 2 * n - freq2[p[0]]);
            } else {
                res = Math.min(res, 2 * n - (freq1[p[0]] + freq1[p[1]]));
            }
        }
        List<Integer> ff = new ArrayList<>();
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] > 0) {
                ff.add(i);
            }
        }
        ff.sort(Comparator.reverseOrder());
        for (int i = 0; i < Math.min(ff.size(), 100); i++) {
            for (int j = i + 1; j < Math.min(ff.size(), 100); j++) {
                res = Math.min(res, 2 * n - (freq1[ff.get(i)] + freq1[ff.get(j)]));
            }
        }
        System.out.println(res);
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
