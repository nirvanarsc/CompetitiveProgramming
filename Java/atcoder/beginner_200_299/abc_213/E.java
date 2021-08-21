package atcoder.beginner_200_299.abc_213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final char[][] g = new char[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = fs.next().toCharArray();
        }
        final int[][] d = new int[n][m];
        for (int[] row : d) {
            Arrays.fill(row, (int) 1e9);
        }
        d[0][0] = 0;
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[] { 0, 0, 0 });
        while (!dq.isEmpty()) {
            final int[] curr = dq.removeFirst();
            final int x = curr[0];
            final int y = curr[1];
            final int dist = curr[2];
            if (d[x][y] < dist) {
                continue;
            }
            for (int[] dir : DIRS) {
                final int nx = dir[0] + x;
                final int ny = dir[1] + y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m && g[nx][ny] == '.') {
                    if (d[nx][ny] > dist) {
                        d[nx][ny] = dist;
                        dq.addFirst(new int[] { nx, ny, dist });
                    }
                }
            }
            for (int dirx = -2; dirx <= 2; dirx++) {
                for (int diry = -2; diry <= 2; diry++) {
                    if (Math.abs(dirx) + Math.abs(diry) == 4) {
                        continue;
                    }
                    final int nx = dirx + x;
                    final int ny = diry + y;
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (d[nx][ny] > dist + 1) {
                            d[nx][ny] = dist + 1;
                            dq.addLast(new int[] { nx, ny, dist + 1 });
                        }
                    }
                }
            }
        }
        System.out.println(d[n - 1][m - 1]);
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
