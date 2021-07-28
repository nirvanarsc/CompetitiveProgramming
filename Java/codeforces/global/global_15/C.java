package codeforces.global.global_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int k = fs.nextInt();
            final List<int[]> chords = new ArrayList<>();
            final boolean[] used = new boolean[2 * n];
            for (int i = 0; i < k; i++) {
                int l = fs.nextInt() - 1;
                int r = fs.nextInt() - 1;
                if (l > r) {
                    final int temp = l;
                    l = r;
                    r = temp;
                }
                chords.add(new int[] { l, r });
                used[l] = used[r] = true;
            }
            final List<Integer> unused = new ArrayList<>();
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    unused.add(i);
                }
            }
            for (int i = 0; i < n - k; i++) {
                chords.add(new int[] { unused.get(i), unused.get(i + n - k) });
            }
            int res = 0;
            for (int i = 0; i < chords.size(); i++) {
                for (int j = i + 1; j < chords.size(); j++) {
                    res += f(chords.get(i), chords.get(j));
                }
            }
            System.out.println(res);
        }
    }

    private static int f(int[] c, int[] d) {
        if (c[0] > d[0]) {
            //noinspection TailRecursion
            return f(d, c);
        }
        return d[0] < c[1] && c[1] < d[1] ? 1 : 0;
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
