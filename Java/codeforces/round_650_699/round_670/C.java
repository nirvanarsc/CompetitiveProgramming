package codeforces.round_650_699.round_670;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final PrintWriter pw = new PrintWriter(System.out);
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final Map<Integer, List<Integer>> g = new HashMap<>();
            final List<Integer> centroids = new ArrayList<>();
            final int[] size = new int[n + 1];
            for (int i = 0; i < n - 1; i++) {
                final int u = fs.nextInt();
                final int v = fs.nextInt();
                g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
                g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
            }
            dfs(g, centroids, 1, -1, size, n);
            if (centroids.size() == 1) {
                pw.println(1 + " " + g.get(1).get(0));
                pw.println(1 + " " + g.get(1).get(0));
            } else {
                for (int next : g.get(centroids.get(0))) {
                    if (next != centroids.get(1)) {
                        pw.println(next + " " + centroids.get(0));
                        pw.println(next + " " + centroids.get(1));
                        break;
                    }
                }
            }
        }
        pw.close();
    }

    private static void dfs(Map<Integer, List<Integer>> g, List<Integer> centroids,
                            int u, int prev, int[] size, int n) {
        size[u] = 1;
        boolean isCentroid = true;
        for (int v : g.getOrDefault(u, Collections.emptyList())) {
            if (v != prev) {
                dfs(g, centroids, v, u, size, n);
                size[u] += size[v];
                if (size[v] > n / 2) {
                    isCentroid = false;
                }
            }
        }
        // size[u] >= (n + 1) / 2
        if (n - size[u] > n / 2) {
            isCentroid = false;
        }
        if (isCentroid) {
            centroids.add(u);
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
