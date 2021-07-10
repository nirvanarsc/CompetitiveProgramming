package atcoder.beginner_200_299.abc_209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    static int n;
    static int q;
    static int h;
    static int time;
    static int[][] parents;
    static int[][] edges;
    static int[][] g;
    static int[] parent;
    static int[] depth;
    static int[] in;
    static int[] out;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        time = 0;
        n = fs.nextInt();
        q = fs.nextInt();
        h = 18;
        edges = new int[n - 1][2];
        for (int i = 0; i < (n - 1); i++) {
            edges[i] = new int[] { fs.nextInt() - 1, fs.nextInt() - 1 };
        }
        g = packG();
        parent = new int[n];
        depth = new int[n];
        in = new int[n];
        out = new int[n];
        dfs1();
        dfs2();
        initParents();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int lca = getLca(u, v);
            final int res = depth[u] + depth[v] - 2 * depth[lca];
            sb.append(res % 2 != 0 ? "Road" : "Town");
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs1() {
        final int[] stack = new int[n];
        int stackIdx = 0;
        stack[stackIdx++] = 0;
        parent[0] = 0;
        depth[0] = 0;
        while (stackIdx > 0) {
            final int u = stack[--stackIdx];
            depth[u] = depth[parent[u]] + 1;
            for (int v : g[u]) {
                if (v != parent[u]) {
                    parent[v] = u;
                    stack[stackIdx++] = v;
                }
            }
        }
    }

    private static void dfs2() {
        final int[] stack = new int[n];
        final int[] idx = new int[n];
        int stackIdx = 0;
        stack[stackIdx++] = 0;
        while (stackIdx > 0) {
            final int u = stack[stackIdx - 1];
            if (idx[u] == 0) {
                in[u] = time++;
            }
            if (idx[u] < g[u].length) {
                final int v = g[u][idx[u]++];
                if (parent[u] != v) {
                    stack[stackIdx++] = v;
                }
            } else {
                out[u] = time;
                stackIdx--;
            }
        }
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
            g[edge[1]][--size[edge[1]]] = edge[0];
        }
        return g;
    }

    private static void initParents() {
        parents = new int[h + 1][n];
        parents[0] = parent;
        for (int i = 1; i <= h; i++) {
            for (int u = 0; u < n; u++) {
                final int nodeParent = parents[i - 1][u];
                parents[i][u] = parents[i - 1][nodeParent];
            }
        }
    }

    private static boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[v] <= out[u];
    }

    private static int getLca(int u, int v) {
        if (isAncestor(u, v)) { return u; }
        if (isAncestor(v, u)) { return v; }
        for (int i = h; i >= 0; i--) {
            if (!isAncestor(parents[i][u], v)) {
                u = parents[i][u];
            }
        }
        return parents[0][u];
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
