package codeforces.round_700_749.round_724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("ReturnOfNull")
public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final String s = fs.next();
            String res = f1(s);
            if (res != null) {
                System.out.println(res);
                continue;
            }
            res = f2(s);
            if (res != null) {
                System.out.println(res);
                continue;
            }
            System.out.println(f3(s));
        }
    }

    private static String f1(String s) {
        for (int i = 0; i < 26; i++) {
            final char c = (char) (i + 'a');
            if (s.indexOf(c) == -1) {
                return String.valueOf(c);
            }
        }
        return null;
    }

    private static String f2(String s) {
        for (int i = 0; i < 26; i++) {
            final String l = String.valueOf((char) (i + 'a'));
            for (int j = 0; j < 26; j++) {
                final char c = (char) (j + 'a');
                if (!s.contains(l + c)) {
                    return l + c;
                }
            }
        }
        return null;
    }

    private static String f3(String s) {
        final String f = "a";
        for (int i = 0; i < 26; i++) {
            final String l = f + (char) (i + 'a');
            for (int j = 0; j < 26; j++) {
                final char c = (char) (j + 'a');
                if (!s.contains(l + c)) {
                    return l + c;
                }
            }
        }
        return null;
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
