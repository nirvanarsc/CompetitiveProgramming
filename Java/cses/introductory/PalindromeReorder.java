package cses.introductory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class PalindromeReorder {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final String s = fs.next();
        final int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'A']++;
        }
        int odd = -1;
        for (int i = 0; i < 26; i++) {
            if (map[i] % 2 != 0 && odd == -1) {
                odd = i;
            } else if (map[i] % 2 != 0) {
                System.out.println("NO SOLUTION");
                return;
            }
        }
        final char[] res = new char[s.length()];
        int ll = 0;
        int rr = s.length() - 1;
        for (int i = 0; i < 26; i++) {
            if (i != odd) {
                final int count = map[i] / 2;
                final char c = (char) (i + 'A');
                for (int j = 0; j < count; j++) {
                    res[ll++] = c;
                    res[rr--] = c;
                }
            }
        }
        final char last = (char) (odd + 'A');
        while (ll <= rr) {
            res[ll++] = last;
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
