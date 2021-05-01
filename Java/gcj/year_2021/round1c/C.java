package gcj.year_2021.round1c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 1; test <= t; test++) {
            final char[] l = fs.next().toCharArray();
            final char[] r = fs.next().toCharArray();
            if (Arrays.equals(l, r)) {
                System.out.println("Case #" + test + ": " + 0);
                continue;
            }
            int longestMatch = -1;
            for (int i = 0; i < l.length; i++) {
                if (isMatch(l, r, i)) {
                    longestMatch = i;
                    break;
                }
            }
            int res = 0;
            if (longestMatch != -1) {
                int rIdx = l.length - longestMatch;
                if (isGood(r, rIdx)) {
                    int one = 0;
                    for (int i = rIdx; i < r.length; i++) {
                        if (r[i] == '1') {
                            one++;
                        } else {
                            res++;
                        }
                    }
                    if (l[l.length - 1] == '1' && one > 0) {
                        res += 2 + one;
                    } else {
                        res += one;
                    }
                    System.out.println("Case #" + test + ": " + res);
                } else {
                    System.out.println("Case #" + test + ": IMPOSSIBLE");
                }
            } else {
                res++;
                final char[] swap = new char[l.length];
                for (int i = 0; i < l.length; i++) {
                    swap[i] = l[i] == '0' ? '1' : '0';
                }
                for (int i = 0; i < l.length; i++) {
                    if (isMatch(swap, r, i)) {
                        longestMatch = i;
                        break;
                    }
                }
                if (longestMatch == -1) {
                    System.out.println("Case #" + test + ": IMPOSSIBLE");
                } else {
                    int rIdx = l.length - longestMatch;
                    if (isGood(r, rIdx)) {
                        int one = 0;
                        for (int i = rIdx; i < r.length; i++) {
                            if (r[i] == '1') {
                                one++;
                            } else {
                                res++;
                            }
                        }
                        if (l[l.length - 1] == '1' && one > 0) {
                            res += 2 + one;
                        } else {
                            res += one;
                        }
                        System.out.println("Case #" + test + ": " + res);
                    } else {
                        System.out.println("Case #" + test + ": IMPOSSIBLE");
                    }
                }
            }
        }
    }

    private static boolean isMatch(char[] l, char[] r, int from) {
        if (from == l.length) {
            return true;
        }
        int i = from;
        for (int j = 0; i < l.length && j < r.length; i++, j++) {
            if (l[i] != r[j]) {
                return false;
            }
        }
        return i == l.length;
    }

    private static boolean isGood(char[] r, int from) {
        for (int i = from; i < r.length - 1; i++) {
            if (r[i] == '0' && r[i + 1] == '1') {
                return false;
            }
        }
        return true;
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
