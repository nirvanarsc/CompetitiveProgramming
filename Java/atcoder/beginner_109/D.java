package atcoder.beginner_109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = fs.nextInt();
            }
        }
        boolean dir = true;
        int row = 1;
        int col = 1;
        final List<int[]> ops = new ArrayList<>();
        for (int i = 0; i < (n * m) - 1; i++) {
            if (dir) {
                if (grid[row - 1][col - 1] % 2 != 0) {
                    if (col == m) {
                        row++;
                        dir = false;
                        ops.add(new int[] { row - 1, col, row, col });
                        grid[row - 1][col - 1]++;
                    } else {
                        ops.add(new int[] { row, col, row, col + 1 });
                        grid[row - 1][col]++;
                        col++;
                    }
                } else {
                    if (col == m) {
                        row++;
                        dir = false;
                    } else {
                        col++;
                    }
                }
            } else {
                if (grid[row - 1][col - 1] % 2 != 0) {
                    if (col == 1) {
                        row++;
                        dir = true;
                        ops.add(new int[] { row - 1, 1, row, 1 });
                        grid[row - 1][0]++;
                    } else {
                        ops.add(new int[] { row, col, row, col - 1 });
                        grid[row - 1][col - 2]++;
                        col--;
                    }
                } else {
                    if (col == 1) {
                        row++;
                        dir = true;
                    } else {
                        col--;
                    }
                }
            }
        }
        System.out.println(ops.size());
        for (int[] op : ops) {
            System.out.println(op[0] + " " + op[1] + ' ' + op[2] + ' ' + op[3]);
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
