package codeforces.round_700_749.round_715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final char[] w = fs.next().toCharArray();
            final TreeSet<Integer> ll = new TreeSet<>();
            final TreeSet<Integer> rr = new TreeSet<>();
            final boolean[] matchedT = new boolean[w.length];
            for (int i = 0; i < w.length; i++) {
                if (w[i] == 'M') {
                    ll.add(i);
                    rr.add(i);
                }
            }
            boolean ok = true;
            for (int i = 0; i < w.length; i++) {
                if (w[i] == 'T' && !ll.isEmpty()) {
                    final Integer first = ll.higher(i);
                    if (first == null) {
                        ok = false;
                        break;
                    }
                    ll.remove(first);
                    matchedT[i] = true;
                }
            }
            for (int i = w.length - 1; i >= 0; i--) {
                if (w[i] == 'T' && !matchedT[i] && !rr.isEmpty()) {
                    final Integer first = rr.lower(i);
                    if (first == null) {
                        ok = false;
                        break;
                    }
                    rr.remove(first);
                    matchedT[i] = true;
                }
            }
            for (int i = 0; i < w.length; i++) {
                if (w[i] == 'T' && !matchedT[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok && ll.isEmpty() && rr.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
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
