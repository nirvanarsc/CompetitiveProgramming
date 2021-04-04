package codeforces.round_700_749.round_712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        // 2
        final Deque<int[]> l = new ArrayDeque<>();
        // 3
        final Deque<int[]> r = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    l.addFirst(new int[] { i, j });
                } else {
                    r.addFirst(new int[] { i, j });
                }
            }
        }
        for (int i = 0; i < n * n; i++) {
            final int color = fs.nextInt();
            if (color == 1) {
                if (!l.isEmpty()) {
                    final int[] c = l.removeFirst();
                    System.out.printf("%d %d %d\n", 2, c[0] + 1, c[1] + 1);
                } else {
                    final int[] c = r.removeFirst();
                    System.out.printf("%d %d %d\n", 3, c[0] + 1, c[1] + 1);
                }
            } else if (color == 2) {
                if (!r.isEmpty()) {
                    final int[] c = r.removeFirst();
                    System.out.printf("%d %d %d\n", 3, c[0] + 1, c[1] + 1);
                } else {
                    final int[] c = l.removeFirst();
                    System.out.printf("%d %d %d\n", 1, c[0] + 1, c[1] + 1);
                }
            } else {
                if (!l.isEmpty()) {
                    final int[] c = l.removeFirst();
                    System.out.printf("%d %d %d\n", 2, c[0] + 1, c[1] + 1);
                } else {
                    final int[] c = r.removeFirst();
                    System.out.printf("%d %d %d\n", 1, c[0] + 1, c[1] + 1);
                }
            }
            System.out.flush();
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
