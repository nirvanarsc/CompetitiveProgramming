package binarysearch.weekly_53;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    public int solve(int n, int[][] views) {
        Arrays.sort(views, Comparator.comparingInt(a -> a[2]));
        final List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = views.length - 1; i >= 0; i--) {
            final int u = views[i][0];
            final int v = views[i][1];
            g.get(u).add(v);
            g.get(v).add(u);
            if (!isBipartiteUF(g)) {
                return views[i][2];
            }
        }
        return 0;
    }

    public boolean isBipartiteUF(List<List<Integer>> g) {
        final UnionFind uf = new UnionFind(g.size());
        for (int i = 0; i < g.size(); i++) {
            for (int j = 0; j < g.get(i).size(); j++) {
                if (uf.find(i) == uf.find(g.get(i).get(j))) {
                    return false;
                }
                uf.union(g.get(i).get(0), g.get(i).get(j));
            }
        }
        return true;
    }
}
