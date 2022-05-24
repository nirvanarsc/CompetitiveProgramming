package leetcode.weekly_contests.weekly_200_299.weekly_206;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_1584 {

    public static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        public UnionFind(int n) {
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

    public int minCostConnectPoints(int[][] points) {
        final List<int[]> weighted = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                final int w = dist(points[i], points[j]);
                weighted.add(new int[] { i, j, w });
            }
        }
        weighted.sort(Comparator.comparingInt(a -> a[2]));
        final UnionFind uf = new UnionFind(points.length);
        int res = 0;
        for (int[] pp : weighted) {
            if (uf.find(pp[0]) != uf.find(pp[1])) {
                uf.union(pp[0], pp[1]);
                res += pp[2];
            }
        }
        return res;
    }

    private static int dist(int[] l, int[] r) {
        return Math.abs(l[0] - r[0]) + Math.abs(l[1] - r[1]);
    }
}
