package binarysearch.weekly_52;

import java.util.HashMap;
import java.util.Map;

public class P_4 {

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

    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int solve(int sx, int sy, int ex, int ey, int[][] roads) {
        final UnionFind uf = new UnionFind(roads.length + 2);
        final Map<String, Integer> map = new HashMap<>();
        final int[] idx = { 0 };
        add(uf, new int[] { sx, sy }, map, idx);
        add(uf, new int[] { ex, ey }, map, idx);
        for (int i = 0; i < roads.length; i++) {
            if (uf.find(0) == uf.find(1)) {
                return i;
            }
            add(uf, roads[i], map, idx);
        }
        return uf.find(0) == uf.find(1) ? roads.length : -1;
    }

    private static void add(UnionFind uf, int[] p, Map<String, Integer> map, int[] idx) {
        if (map.containsKey(p[0] + "," + p[1])) {
            return;
        }
        final int u = idx[0];
        map.put(p[0] + "," + p[1], idx[0]++);
        for (int[] dir : DIRS) {
            final int nx = dir[0] + p[0];
            final int ny = dir[1] + p[1];
            final String key = nx + "," + ny;
            final Integer other = map.get(key);
            if (other != null) {
                uf.union(u, other);
            }
        }
    }
}
