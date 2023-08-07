package leetcode.weekly_contests.weekly_300_399.weekly_357;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class P_3 {

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

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        final int n = grid.size();
        final int m = grid.get(0).size();
        final int[][] g = new int[n][m];
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = grid.get(i).get(j);
                if (g[i][j] == 1) {
                    dq.offerLast(i * m + j);
                }
            }
        }
        final int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = g[i][j] == 1 ? 0 : (int) 1e9;
            }
        }
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int curr = dq.removeFirst();
                final int u = curr / m;
                final int v = curr % m;
                if (d[u][v] < level) {
                    continue;
                }
                for (int[] dir : DIRS) {
                    final int nu = u + dir[0];
                    final int nv = v + dir[1];
                    if (0 <= nu && nu < n && 0 <= nv && nv < m && d[nu][nv] > d[u][v] + 1) {
                        d[nu][nv] = d[u][v] + 1;
                        dq.offerLast(nu * m + nv);
                    }
                }
            }
        }
        int lo = 0;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            final UnionFind uf = new UnionFind(n * m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int[] dir : DIRS) {
                        final int nu = i + dir[0];
                        final int nv = j + dir[1];
                        if (0 <= nu && nu < n && 0 <= nv && nv < m && d[i][j] >= mid && d[nu][nv] >= mid) {
                            uf.union(i * m + j, nu * m + nv);
                        }
                    }
                }
            }
            if (uf.find(0) != uf.find(n * m - 1)) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo == (int) 1e9 ? 0 : lo;
    }
}
