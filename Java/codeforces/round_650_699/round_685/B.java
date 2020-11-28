package codeforces.round_650_699.round_685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int q = fs.nextInt();
            final char[] str = fs.next().toCharArray();
            final int[] countF0 = new int[n];
            final int[] countB0 = new int[n];
            final int[] countF1 = new int[n];
            final int[] countB1 = new int[n];
            int count0 = 0;
            int count1 = 0;
            for (int i = 0; i < n; i++) {
                if (str[i] == '0') {
                    count0 += 1;
                } else {
                    count1 += 1;
                }
                countF0[i] = count0;
                countF1[i] = count1;
            }
            count0 = 0;
            count1 = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (str[i] == '0') {
                    count0 += 1;
                } else {
                    count1 += 1;
                }
                countB0[i] = count0;
                countB1[i] = count1;
            }
            for (int i = 0; i < q; i++) {
                final int l = fs.nextInt() - 1;
                final int r = fs.nextInt() - 1;
                boolean canDo = false;
                final char ll = str[l];
                final char rr = str[r];
                if (ll == '0' && l > 0 && countF0[l - 1] > 0) {
                    canDo = true;
                }
                if (ll == '1' && l > 0 && countF1[l - 1] > 0) {
                    canDo = true;
                }
                if (rr == '0' && r < (n - 1) && countB0[r + 1] > 0) {
                    canDo = true;
                }
                if (rr == '1' && r < (n - 1) && countB1[r + 1] > 0) {
                    canDo = true;
                }
                if (canDo) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
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
