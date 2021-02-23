package codeforces.round_700_749.round_704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

@SuppressWarnings("ConstantConditions")
public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final char[] s = fs.next().toCharArray();
        final char[] t = fs.next().toCharArray();
        final List<TreeSet<Integer>> g = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            g.add(new TreeSet<>());
        }
        for (int i = 0; i < n; i++) {
            g.get(s[i] - 'a').add(i);
        }
        final int[] curr = new int[m];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                curr[0] = g.get(t[0] - 'a').first();
            } else {
                curr[i] = g.get(t[i] - 'a').higher(curr[i - 1]);
            }
        }
        int res = 0;
        for (int i = 0; i < m - 1; i++) {
            res = Math.max(res, curr[i + 1] - curr[i]);
        }
        for (int i = m - 1; i >= 0; i--) {
            if (i == m - 1) {
                curr[m - 1] = g.get(t[m - 1] - 'a').last();
                res = Math.max(res, curr[m - 1] - curr[m - 2]);
            } else {
                curr[i] = g.get(t[i] - 'a').lower(curr[i + 1]);
                res = Math.max(res, curr[i + 1] - curr[i]);
                if (i > 0) {
                    res = Math.max(res, curr[i] - curr[i - 1]);
                }
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
