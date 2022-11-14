package leetcode.weekly_contests.weekly_100_199.weekly_112;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_947 {

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

    public int removeStones(int[][] stones) {
        final int n = stones.length;
        final UnionFind uf = new UnionFind(n);
        final Map<Integer, List<Integer>> cols = new HashMap<>();
        final Map<Integer, List<Integer>> rows = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cols.computeIfAbsent(stones[i][0], v -> new ArrayList<>()).add(i);
            rows.computeIfAbsent(stones[i][1], v -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int row : rows.get(stones[i][1])) { uf.union(i, row); }
            for (int col : cols.get(stones[i][0])) { uf.union(i, col); }
        }
        return n - uf.count();
    }
}
