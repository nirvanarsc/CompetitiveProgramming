package atcoder.regular_100_199.arc_115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            g[i] = fs.nextIntArray(n);
        }
        final int[] diff = new int[n];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = g[0][i + 1] - g[0][i];
        }
        boolean ok = true;
        outer:
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (g[i][j + 1] - g[i][j] != diff[j]) {
                    ok = false;
                    break outer;
                }
            }
        }
        if (!ok) {
            System.out.println("No");
            return;
        }
        int minR = (int) 2e9;
        int minIdx = -1;
        for (int i = 0; i < n; i++) {
            if (minR > g[i][0]) {
                minR = g[i][0];
                minIdx = i;
            }
        }
        final int[] resA = g[minIdx];
        final int[] resB = new int[n];
        for (int i = 0; i < n; i++) {
            resB[i] = g[i][0] - resA[0];
        }
        System.out.println("Yes");
        for (int i = 0; i < n; i++) {
            System.out.print(resB[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(resA[i] + " ");
        }
        System.out.println();
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
