package cses.graph_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class HighScore {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final List<int[]> edges = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            // Mark negative to find negative cycles
            final int w = fs.nextInt() * -1;
            edges.add(new int[] { u, v, w });
        }
        final long[] dist = bellmanFord(edges, 0, n);
        if (dist[n - 1] == (long) -1e18) {
            System.out.println(-1);
        } else {
            System.out.println(-dist[n - 1]);
        }
    }

    // Bellman-Ford O (V*E) == O(V^3)
    private static long[] bellmanFord(List<int[]> e, int start, int n) {
        final long[] dist = new long[n];
        Arrays.fill(dist, (long) 1e18);
        dist[start] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : e) {
                final int from = edge[0];
                final int to = edge[1];
                final int cost = edge[2];
                if (dist[from] == (long) 1e18) {
                    continue;
                }
                dist[to] = Math.min(dist[to], dist[from] + cost);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : e) {
                final int from = edge[0];
                final int to = edge[1];
                final int cost = edge[2];
                if (dist[from] == (long) 1e18) {
                    continue;
                }
                if (dist[from] + cost < dist[to]) {
                    dist[to] = (long) -1e18;
                }
            }
        }
        return dist;
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
