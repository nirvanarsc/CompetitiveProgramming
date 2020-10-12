package codeforces.tree_basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public final class C {

    // https://codeforces.com/blog/entry/43230
    public static void main(String[] args) throws IOException {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 1; i < n; i++) {
            final int l = fs.nextInt() - 1;
            final int r = fs.nextInt() - 1;
            g.computeIfAbsent(l, v -> new ArrayList<>()).add(r);
            g.computeIfAbsent(r, v -> new ArrayList<>()).add(l);
        }
        final int[] parents = new int[n];
        final int[] depth = new int[n];
        dfs(g, 0, -1, 0, parents, depth);
        final TreeAncestor ta = new TreeAncestor(n, parents);
        final int q = fs.nextInt();
        for (int i = 0; i < q; i++) {
            final int a = fs.nextInt() - 1;
            final int b = fs.nextInt() - 1;
            final int c = fs.nextInt();
            final int lca = ta.getLca(a, b, depth);
            final int left = depth[a] - depth[lca];
            final int right = depth[b] - depth[lca];
            if (c >= left + right) {
                pw.println(b + 1);
            } else if (c >= left) {
                pw.println(ta.getKthAncestor(b, right - (c - left)) + 1);
            } else {
                pw.println(ta.getKthAncestor(a, c) + 1);
            }
        }
        pw.flush();
    }

    private static void dfs(Map<Integer, List<Integer>> g, int u, int v, int d, int[] parents, int[] depth) {
        parents[u] = v;
        depth[u] = d;
        for (int next : g.getOrDefault(u, Collections.emptyList())) {
            if (next != v) {
                dfs(g, next, u, d + 1, parents, depth);
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

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
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

        int[] readArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
