package atcoder.beginner_100_199.beginner_159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int k = fs.nextInt();
        final char[][] g = new char[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = fs.next().toCharArray();
        }
        final int[][] pre = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + g[i - 1][j - 1] - '0';
            }
        }
        int res = (int) 1e9;
        for (int mask = 0; mask < 1 << (n - 1); mask++) {
            int curr = 0;
            final List<Integer> rowCuts = new ArrayList<>();
            rowCuts.add(0);
            for (int j = 0; j < n - 1; j++) {
                if ((mask & (1 << j)) != 0) {
                    curr++;
                    rowCuts.add(j + 1);
                }
            }
            rowCuts.add(n);
            int col = 1;
            boolean ok = true;
            for (int i = 1; i <= m; i++) {
                int currMax = 0;
                for (int c = 0; c < rowCuts.size() - 1; c++) {
                    currMax = Math.max(currMax, f(pre, rowCuts.get(c) + 1, col, rowCuts.get(c + 1), i));
                }
                if (currMax > k) {
                    if (col == i) {
                        ok = false;
                        break;
                    }
                    curr++;
                    col = i;
                }
            }
            if (ok) {
                res = Math.min(res, curr);
            }
        }
        System.out.println(res);
    }

    private static int f(int[][] pre, int fromX, int fromY, int toX, int toY) {
        return pre[toX][toY] - pre[toX][fromY - 1] - pre[fromX - 1][toY] + pre[fromX - 1][fromY - 1];
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
