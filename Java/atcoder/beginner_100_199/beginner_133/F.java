package atcoder.beginner_100_199.beginner_133;

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

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final Map<Integer, List<int[]>> g = new HashMap<>();
        final Map<Integer, List<int[]>> queries = new HashMap<>();
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        for (int i = 0; i < n - 1; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int c = fs.nextInt();
            final int w = fs.nextInt();
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(new int[] { v, c, w });
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(new int[] { u, c, w });
        }
        final int[] parents = new int[n];
        final int[] depth = new int[n];
        dfs(g, 0, -1, 0, parents, depth);
        final TreeAncestor ta = new TreeAncestor(n, parents);
        for (int i = 0; i < q; i++) {
            final int c = fs.nextInt();
            final int d = fs.nextInt();
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int lca = ta.getLca(u, v, depth);
            queries.computeIfAbsent(u, val -> new ArrayList<>()).add(new int[] { i, c, d, 1 });
            queries.computeIfAbsent(v, val -> new ArrayList<>()).add(new int[] { i, c, d, 1 });
            queries.computeIfAbsent(lca, val -> new ArrayList<>()).add(new int[] { i, c, d, -2 });
        }
        final int[] res = new int[q];
        dfs2(g, queries, 0, -1, 0, res, new int[n], new int[n]);
        for (int i = 0; i < q; i++) {
            pw.println(res[i]);
        }
        pw.close();
    }

    private static void dfs(Map<Integer, List<int[]>> g, int u, int v, int d, int[] parents, int[] depth) {
        parents[u] = v;
        depth[u] = d;
        for (int[] next : g.getOrDefault(u, Collections.emptyList())) {
            if (next[0] != v) {
                dfs(g, next[0], u, d + 1, parents, depth);
            }
        }
    }

    private static void dfs2(Map<Integer, List<int[]>> g, Map<Integer, List<int[]>> q,
                             int u, int v, int path, int[] res, int[] dis, int[] count) {
        for (int[] curr : q.getOrDefault(u, Collections.emptyList())) {
            res[curr[0]] += curr[3] * (path - dis[curr[1]] + count[curr[1]] * curr[2]);
        }
        for (int[] next : g.getOrDefault(u, Collections.emptyList())) {
            if (next[0] != v) {
                count[next[1]]++;
                dis[next[1]] += next[2];
                dfs2(g, q, next[0], u, path + next[2], res, dis, count);
                count[next[1]]--;
                dis[next[1]] -= next[2];
            }
        }
    }

    private static final class TreeAncestor {
        int h;
        int[][] parents;

        private TreeAncestor(int n, int[] parent) {
            h = (int) (Math.log(n) / Math.log(2));
            parents = new int[h + 1][n];
            parents[0] = parent;
            for (int i = 1; i <= h; i++) {
                for (int node = 0; node < n; node++) {
                    final int nodeParent = parents[i - 1][node];
                    if (nodeParent != -1) {
                        parents[i][node] = parents[i - 1][nodeParent];
                    } else {
                        parents[i][node] = -1;
                    }
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            for (int i = 0; i <= h; i++) {
                if ((k & (1 << i)) != 0) {
                    node = parents[i][node];
                    if (node == -1) {
                        return -1;
                    }
                }
            }
            return node;
        }

        public int getLca(int u, int v, int[] depth) {
            if (depth[u] < depth[v]) {
                v = getKthAncestor(v, depth[v] - depth[u]);
            } else {
                u = getKthAncestor(u, depth[u] - depth[v]);
            }
            if (u == v) {
                return u;
            }
            for (int i = h; i >= 0; i--) {
                if (parents[i][u] != parents[i][v]) {
                    u = parents[i][u];
                    v = parents[i][v];
                }
            }
            return parents[0][u];
        }
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
