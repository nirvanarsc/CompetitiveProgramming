package codeforces.round_650_699.round_684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C1 {

    private static void f(int[][] grid, int row, int col, int[] count, StringBuilder pw) {
        final int upL = grid[row][col];
        final int upR = grid[row][col + 1];
        final int downL = grid[row + 1][col];
        final int downR = grid[row + 1][col + 1];
        final int sum = upL + upR + downL + downR;
        if (sum == 1) {
            f1(grid, row, col, count, pw);
        } else if (sum == 2) {
            f2(grid, row, col, count, pw);
        } else if (sum == 3) {
            f3(grid, row, col, count, pw);
        } else {
            f4(grid, row, col, count, pw);
        }
    }

    private static void f1(int[][] grid, int row, int col, int[] count, StringBuilder pw) {
        final int upL = grid[row][col];
        final int upR = grid[row][col + 1];
        final int downL = grid[row + 1][col];
        if (upL == 1) {
            update(grid, row, col, row + 1, col, row + 1, col + 1, count, pw);
            f2(grid, row, col, count, pw);
        } else if (upR == 1) {
            update(grid, row, col + 1, row + 1, col, row + 1, col + 1, count, pw);
            f2(grid, row, col, count, pw);
        } else if (downL == 1) {
            update(grid, row, col, row, col + 1, row + 1, col, count, pw);
            f2(grid, row, col, count, pw);
        } else {
            update(grid, row, col, row, col + 1, row + 1, col + 1, count, pw);
            f2(grid, row, col, count, pw);
        }
    }

    private static void f2(int[][] grid, int row, int col, int[] count, StringBuilder pw) {
        final int upL = grid[row][col];
        final int upR = grid[row][col + 1];
        final int downL = grid[row + 1][col];
        final int downR = grid[row + 1][col + 1];
        if (upL == 1 && upR == 1) {
            update(grid, row, col + 1, row + 1, col, row + 1, col + 1, count, pw);
            f3(grid, row, col, count, pw);
        } else if (upL == 1 && downL == 1) {
            update(grid, row, col + 1, row + 1, col, row + 1, col + 1, count, pw);
            f3(grid, row, col, count, pw);
        } else if (upL == 1 && downR == 1) {
            update(grid, row, col, row, col + 1, row + 1, col, count, pw);
            f3(grid, row, col, count, pw);
        } else if (upR == 1 && downR == 1) {
            update(grid, row, col, row, col + 1, row + 1, col, count, pw);
            f3(grid, row, col, count, pw);
        } else if (upR == 1 && downL == 1) {
            update(grid, row, col, row + 1, col, row + 1, col + 1, count, pw);
            f3(grid, row, col, count, pw);
        } else if (downL == 1 && downR == 1) {
            update(grid, row, col, row, col + 1, row + 1, col + 1, count, pw);
            f3(grid, row, col, count, pw);
        }
    }

    private static void f3(int[][] grid, int row, int col, int[] count, StringBuilder pw) {
        final int upL = grid[row][col];
        final int upR = grid[row][col + 1];
        final int downL = grid[row + 1][col];
        if (upL == 0) {
            update(grid, row, col + 1, row + 1, col, row + 1, col + 1, count, pw);
        } else if (upR == 0) {
            update(grid, row, col, row + 1, col, row + 1, col + 1, count, pw);
        } else if (downL == 0) {
            update(grid, row, col, row, col + 1, row + 1, col + 1, count, pw);
        } else {
            update(grid, row, col, row, col + 1, row + 1, col, count, pw);
        }
    }

    private static void f4(int[][] grid, int row, int col, int[] count, StringBuilder pw) {
        update(grid, row, col, row + 1, col, row + 1, col + 1, count, pw);
        f1(grid, row, col, count, pw);
    }

    private static void update(int[][] grid, int r1, int c1, int r2, int c2, int r3, int c3, int[] count,
                               StringBuilder pw) {
        count[0]++;
        grid[r1][c1] ^= 1;
        grid[r2][c2] ^= 1;
        grid[r3][c3] ^= 1;
        pw.append(r1 + 1);
        pw.append(' ');
        pw.append(c1 + 1);
        pw.append(' ');
        pw.append(r2 + 1);
        pw.append(' ');
        pw.append(c2 + 1);
        pw.append(' ');
        pw.append(r3 + 1);
        pw.append(' ');
        pw.append(c3 + 1);
        pw.append('\n');
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                final String line = fs.next();
                for (int j = 0; j < m; j++) {
                    grid[i][j] = line.charAt(j) == '1' ? 1 : 0;
                }
            }
            final StringBuilder sb = new StringBuilder();
            final int[] count = { 0 };
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    f(grid, i, j, count, sb);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(count[0]);
            System.out.println(sb);
        }
    }

    static final class Utils {
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
