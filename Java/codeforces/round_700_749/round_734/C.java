package codeforces.round_700_749.round_734;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final List<Integer> a = new ArrayList<>();
            final List<Integer> b = new ArrayList<>();
            final List<Integer> c = new ArrayList<>();
            final List<Integer> d = new ArrayList<>();
            final List<Integer> e = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                final char[] w = fs.next().toCharArray();
                final int[] map = new int[5];
                for (char value : w) {
                    map[value - 'a']++;
                }
                final int total = map[0] + map[1] + map[2] + map[3] + map[4];
                a.add(2 * map[0] - total);
                b.add(2 * map[1] - total);
                c.add(2 * map[2] - total);
                d.add(2 * map[3] - total);
                e.add(2 * map[4] - total);
            }
            a.sort(Comparator.reverseOrder());
            b.sort(Comparator.reverseOrder());
            c.sort(Comparator.reverseOrder());
            d.sort(Comparator.reverseOrder());
            e.sort(Comparator.reverseOrder());
            int res = 0;
            res = Math.max(res, f(n, a));
            res = Math.max(res, f(n, b));
            res = Math.max(res, f(n, c));
            res = Math.max(res, f(n, d));
            res = Math.max(res, f(n, e));
            System.out.println(res);
        }
    }

    private static int f(int n, List<Integer> a) {
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (curr + a.get(i) <= 0) {
                return i;
            }
            curr += a.get(i);
        }
        return n;
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
