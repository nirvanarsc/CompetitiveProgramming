package kickstart.year_2020.round_h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final Map<Long, Long> table = new HashMap<>();
        long pow = 1L;
        long res = 1L;
        for (int i = 0; i <= 18; i++) {
            table.put(pow, res);
            pow *= 10;
            res *= 5;
        }
        for (int test = 1; test <= t; test++) {
            final String L = String.valueOf(fs.nextLong() - 1);
            final String R = fs.next();
            final long currR = getMSB(R, table) + countLessThan(R, table);
            final long currL = getMSB(L, table) + countLessThan(L, table);
            System.out.println("Case #" + test + ": " + (currR - currL));
        }
    }

    private static long getMSB(String str, Map<Long, Long> table) {
        if (str.length() == 1) {
            return 0;
        }
        long res = 0;
        long pp = 1L;
        for (int i = 0; i < str.length(); i++) {
            res += table.get(pp);
            pp *= 10;
        }
        return res - 1;
    }

    private static long countLessThan(String str, Map<Long, Long> table) {
        final int pow = str.length();
        long res = 0;
        for (int i = 0, j = 1; i < str.length(); i++, j++) {
            final int curr = str.charAt(i) - '0';
            long mult = curr / 2;
            if (j % 2 == 0) {
                mult = (curr + 1) / 2;
            }
            if (i == str.length() - 1) {
                if (j % 2 == 0) {
                    mult = (curr + 2) / 2;
                } else {
                    mult = (curr + 1) / 2;
                }
            }
            final long power = (long) Math.pow(10, pow - j);
            res += mult * table.get(power);
            if (curr % 2 != j % 2) {
                break;
            }
        }
        return res;
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
