package atcoder.hhkb2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int h = fs.nextInt();
        final int w = fs.nextInt();
        final char[][] grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            grid[i] = fs.next().toCharArray();
        }
        final int row = getRow(h, w, grid);
        final int col = getCol(h, w, grid);
        System.out.println(row + col);
    }

    private static int getRow(int n, int m, char[][] grid) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '#') {
                    continue;
                } else {
                    int tt = j;
                    while (tt < m && grid[i][tt] == '.') {
                        tt++;
                    }
                    res += tt - j - 1;
                    j = tt - 1;
                }
            }
        }
        return res;
    }

    private static int getCol(int n, int m, char[][] grid) {
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == '#') {
                    continue;
                } else {
                    int tt = j;
                    while (tt < n && grid[tt][i] == '.') {
                        tt++;
                    }
                    res += tt - j - 1;
                    j = tt - 1;
                }
            }
        }
        return res;
    }

    static final class Utils {
        public static void shuffleSort(int[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffle(int[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void shuffle(long[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void swap(int[] arr, int i, int j) {
            final int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        public static void swap(long[] arr, int i, int j) {
            final long t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
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
