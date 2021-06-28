package codeforces.round_700_749.round_717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final int[] smallestDiv = new int[(int) (1e5 + 5)];
        Arrays.fill(smallestDiv, 1);
        for (int i = 2; i < smallestDiv.length; i++) {
            if (smallestDiv[i] == 1) {
                for (int j = i; j < smallestDiv.length; j += i) {
                    smallestDiv[j] = i;
                }
            }
        }
        final int[] a = new int[n];
        final int[] next = new int[n];
        final int[] map = new int[(int) (1e5 + 5)];
        Arrays.fill(next, 1);
        Arrays.fill(map, -1);
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            int x = a[i];
            while (x > 1) {
                final int p = smallestDiv[x];
                while (x % p == 0) {
                    x /= p;
                }
                next[i] = Math.max(next[i], map[p]);
                map[p] = i + 1;
            }
            if (i > 0) {
                next[i] = Math.max(next[i], next[i - 1]);
            }
        }
        System.out.println(Arrays.toString(next));
        final int h = 18;
        final int[][] parents = new int[h + 1][n];
        parents[0] = next;
        for (int i = 1; i <= h; i++) {
            for (int u = 0; u < n; u++) {
                final int nodeParent = parents[i - 1][u];
                parents[i][u] = parents[i - 1][nodeParent];
            }
        }
        for (int i = 0; i < q; i++) {
            final int l = fs.nextInt() - 1;
            int r = fs.nextInt() - 1;
            int res = 0;
            for (int j = h - 1; j >= 0; j--) {
                if (parents[j][r] > l) {
                    res += 1 << j;
                    r = parents[j][r];
                }
            }
            res++;
            System.out.println(res);
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
