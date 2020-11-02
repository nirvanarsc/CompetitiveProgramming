package cses.graph_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class CycleFinding {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final List<int[]> edges = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int w = fs.nextInt();
            edges.add(new int[] { u, v, w });
        }
        bellmanFord(edges, 0, n);
    }

    // Bellman-Ford O (V*E) == O(V^3)
    private static void bellmanFord(List<int[]> e, int start, int n) {
        final int[] parents = new int[n];
        // Pretend there is a hidden vertex connecting all vertices with weight 0
        // to deal with disconnected graphs
        final long[] dist = new long[n];
        int x = -1;
        for (int i = 0; i < n; i++) {
            x = -1;
            for (int[] edge : e) {
                final int from = edge[0];
                final int to = edge[1];
                final int cost = edge[2];
                if (dist[from] + cost < dist[to]) {
                    dist[to] = dist[from] + cost;
                    parents[to] = from;
                    x = to;
                }
            }
        }
        if (x == -1) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < n; ++i) {
            x = parents[x];
        }
        final List<Integer> cycle = new ArrayList<>();
        int v = x;
        do {
            cycle.add(v + 1);
            v = parents[v];
        } while (v != x);
        Collections.reverse(cycle);
        cycle.add(cycle.get(0));
        System.out.println("YES");
        for (int num : cycle) {
            System.out.print(num + " ");
        }
        System.out.println();
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
