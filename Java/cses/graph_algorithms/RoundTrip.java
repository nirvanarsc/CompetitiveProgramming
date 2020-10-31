package cses.graph_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class RoundTrip {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        final int[] parents = new int[n];
        final boolean[] seen = new boolean[n];
        final int[] loop = { -1, -1 };
        for (int i = 0; i < n; i++) {
            if (dfs(i, -1, g, parents, seen, loop)) {
                final StringBuilder sb = new StringBuilder();
                int x = loop[0];
                int k = 0;
                sb.append(loop[1] + 1);
                sb.append(' ');
                while (x != loop[1]) {
                    k++;
                    sb.append(x + 1);
                    sb.append(' ');
                    x = parents[x];
                }
                sb.append(loop[1] + 1);
                System.out.println(k + 2);
                System.out.println(sb);
                return;
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static boolean dfs(int n, int par, Map<Integer, List<Integer>> g,
                               int[] parents, boolean[] seen, int[] loop) {
        if (seen[n]) {
            return false;
        }
        seen[n] = true;
        parents[n] = par;
        for (int next : g.getOrDefault(n, Collections.emptyList())) {
            if (next == par) {
                continue;
            }
            if (seen[next]) {
                loop[0] = n;
                loop[1] = next;
                return true;
            }
            if (dfs(next, n, g, parents, seen, loop)) {
                return true;
            }
        }
        return false;
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
