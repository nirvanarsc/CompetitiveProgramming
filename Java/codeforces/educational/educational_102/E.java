package codeforces.educational.educational_102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) throws IOException {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final List<List<int[]>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int w = fs.nextInt();
            g.get(u).add(new int[] { v, w });
            g.get(v).add(new int[] { u, w });
        }
        final long[][] dp = new long[n][4];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = dp[i][2] = dp[i][3] = -1;
        }
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[2]));
        pq.offer(new long[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            final long[] curr = pq.remove();
            final int u = (int) curr[0];
            final int mask = (int) curr[1];
            final long cost = curr[2];
            if (dp[u][mask] != -1) {
                continue;
            }
            dp[u][mask] = cost;
            for (int[] next : g.get(u)) {
                final int v = next[0];
                final int w = next[1];
                if (mask == 0) {
                    add(pq, dp, cost + w, v, 0);
                    add(pq, dp, cost, v, 1);
                    add(pq, dp, cost + 2 * w, v, 2);
                    add(pq, dp, cost + w, v, 3);
                } else if (mask == 1) {
                    add(pq, dp, cost + w, v, 1);
                    add(pq, dp, cost + 2 * w, v, 3);
                } else if (mask == 2) {
                    add(pq, dp, cost + w, v, 2);
                    add(pq, dp, cost, v, 3);
                } else if (mask == 3) {
                    add(pq, dp, cost + w, v, 3);
                }
            }
        }
        for (int i = 1; i < n; i++) {
            pw.print(dp[i][3] + " ");
        }
        pw.println();
        pw.close();
    }

    private static void add(PriorityQueue<long[]> pq, long[][] dp, long cost, int u, int mask) {
        if (dp[u][mask] == -1) {
            pq.offer(new long[] { u, mask, cost });
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
