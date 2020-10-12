package atcoder.beginner_107;

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
        final int m = fs.nextInt();
        final char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = fs.next().toCharArray();
        }
        final boolean[][] remove = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            boolean removeRow = true;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '#') {
                    removeRow = false;
                    break;
                }
            }
            if (removeRow) {
                for (int j = 0; j < m; j++) {
                    remove[i][j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            boolean removeCol = true;
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == '#') {
                    removeCol = false;
                    break;
                }
            }
            if (removeCol) {
                for (int j = 0; j < n; j++) {
                    remove[j][i] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            boolean emptyRow = true;
            for (int j = 0; j < m; j++) {
                if (!remove[i][j]) {
                    emptyRow = false;
                    System.out.print(grid[i][j]);
                }
            }
            if (!emptyRow) {
                System.out.println();
            }
        }
    }

    static final class Util {
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

        private Util() {}
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
