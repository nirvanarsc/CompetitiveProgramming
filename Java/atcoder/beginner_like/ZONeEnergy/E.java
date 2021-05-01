package atcoder.beginner_like.ZONeEnergy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("UnnecessaryLocalVariable")
public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[][] a = new int[n][m - 1];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextIntArray(m - 1);
        }
        final int[][] b = new int[n - 1][m];
        for (int i = 0; i < n - 1; i++) {
            b[i] = fs.nextIntArray(m);
        }
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
        pq.offer(new int[] { 0, 0, 0 });
        final int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 2e9);
        }
        dp[0][0] = 0;
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int x = curr[1];
            final int y = curr[2];
            final int cost = curr[0];
            if (x == n - 1 && y == m - 1) {
                System.out.println(cost);
                return;
            }
            if (dp[x][y] < cost) {
                continue;
            }
            dp[x][y] = cost;
            if (y + 1 < m) {
                final int nx = x;
                final int ny = y + 1;
                final int nextW = cost + a[x][y];
                if (nextW < dp[nx][ny]) {
                    dp[nx][ny] = nextW;
                    pq.offer(new int[] { nextW, nx, ny });
                }
            }
            if (y - 1 >= 0) {
                final int nx = x;
                final int ny = y - 1;
                final int nextW = cost + a[x][y - 1];
                if (nextW < dp[nx][ny]) {
                    dp[nx][ny] = nextW;
                    pq.offer(new int[] { nextW, nx, ny });
                }
            }
            if (x + 1 < n) {
                final int nx = x + 1;
                final int ny = y;
                final int nextW = cost + b[x][y];
                if (nextW < dp[nx][ny]) {
                    dp[nx][ny] = nextW;
                    pq.offer(new int[] { nextW, nx, ny });
                }
            }
            for (int i = 0; i < x; i++) {
                final int nx = i;
                final int ny = y;
                final int nextW = cost + (x + 1 - i);
                if (nextW < dp[nx][ny]) {
                    dp[nx][ny] = nextW;
                    pq.offer(new int[] { nextW, nx, ny });
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);
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
