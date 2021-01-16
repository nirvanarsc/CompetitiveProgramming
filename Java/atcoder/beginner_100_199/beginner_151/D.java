package atcoder.beginner_100_199.beginner_151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final char[][] g = new char[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = fs.next().toCharArray();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '.') {
                    res = Math.max(res, bfs(g, i, j, n, m));
                }
            }
        }
        System.out.println(res);
    }

    private static int bfs(char[][] g, int i, int j, int n, int m) {
        int res = 0;
        final Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[] { i, j });
        final boolean[][] seen = new boolean[n][m];
        seen[i][j] = true;
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final int[] curr = q.removeFirst();
                res = level;
                for (int[] dir : DIRS) {
                    final int nx = dir[0] + curr[0];
                    final int ny = dir[1] + curr[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && g[nx][ny] == '.') {
                        if (!seen[nx][ny]) {
                            seen[nx][ny] = true;
                            q.offerLast(new int[] { nx, ny });
                        }
                    }
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
