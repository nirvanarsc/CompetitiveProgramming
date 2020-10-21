package cses.introductory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class ChessboardQueens {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = fs.next().toCharArray();
        }
        final int[] res = { 0 };
        dfs(0, 8, res, new ArrayList<>(), board);
        System.out.println(res[0]);
    }

    private static void dfs(int row, int n, int[] res, List<Integer> currSolution, char[][] grid) {
        if (row == n) {
            res[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (grid[row][i] == '.') {
                currSolution.add(i);
                if (isValid(row, currSolution)) {
                    dfs(row + 1, n, res, currSolution, grid);
                }
                currSolution.remove(currSolution.size() - 1);
            }
        }
    }

    private static boolean isValid(int row, List<Integer> placement) {
        for (int i = 0; i < row; i++) {
            final int diff = Math.abs(placement.get(i) - placement.get(row));
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
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
