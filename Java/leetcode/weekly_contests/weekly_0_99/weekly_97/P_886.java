package leetcode.weekly_contests.weekly_0_99.weekly_97;

public class P_886 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] colors;

    public boolean possibleBipartitionDFS(int m, int[][] dislikes) {
        n = m;
        for (int[] e : dislikes) {
            e[0]--;
            e[1]--;
        }
        edges = dislikes;
        g = packG();
        colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(i, 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int u, int color) {
        if (colors[u] != 0) {
            return colors[u] == color;
        }
        colors[u] = color;
        for (int v : g[u]) {
            if (!dfs(v, 3 ^ color)) {
                return false;
            }
        }
        return true;
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
                size[rootQ] = 0;
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
                size[rootP] = 0;
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        final UnionFind uf = new UnionFind(2 * n);
        for (int[] edge : dislikes) {
            edge[0]--;
            edge[1]--;
            uf.union(edge[0], edge[1] + n);
            uf.union(edge[1], edge[0] + n);
        }
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == uf.find(i + n)) {
                return false;
            }
        }
        return true;
    }
}
