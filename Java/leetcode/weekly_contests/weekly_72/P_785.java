package leetcode.weekly_contests.weekly_72;

public class P_785 {

    public boolean isBipartite(int[][] graph) {
        final int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                if (!dfs(i, graph, colors, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int u, int[][] g, int[] colors, int c) {
        if (colors[u] != 0) {
            return colors[u] == c;
        }
        colors[u] = c;
        for (int n : g[u]) {
            if (!dfs(n, g, colors, c ^ 3)) {
                return false;
            }
        }
        return true;
    }

    private static final class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        private UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            // path compression
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // union by size
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public boolean isBipartiteUF(int[][] graph) {
        final UnionFind uf = new UnionFind(graph.length);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (uf.find(i) == uf.find(graph[i][j])) {
                    return false;
                }
                uf.union(graph[i][0], graph[i][j]);
            }
        }
        return true;
    }
}
