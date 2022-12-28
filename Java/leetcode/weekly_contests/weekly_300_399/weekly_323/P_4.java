package leetcode.weekly_contests.weekly_300_399.weekly_323;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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

    public int[] maxPoints(int[][] grid, int[] queries) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int q = queries.length;
        final int[][] sorted = new int[q][2];
        for (int i = 0; i < q; i++) {
            sorted[i] = new int[] { queries[i], i };
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        final UnionFind uf = new UnionFind(n * m + 1);
        final int root = n * m;
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { grid[0][0], 0, 0 });
        final int[] res = new int[q];
        final boolean[] seen = new boolean[n * m];
        seen[0] = true;
        for (int[] s : sorted) {
            while (!pq.isEmpty() && pq.element()[0] < s[0]) {
                final int[] curr = pq.remove();
                final int r = curr[1];
                final int c = curr[2];
                uf.union(r * m + c, root);
                for (int[] dir : DIRS) {
                    final int nr = r + dir[0];
                    final int nc = c + dir[1];
                    if (0 <= nr && nr < n && 0 <= nc && nc < m && !seen[nr * m + nc]) {
                        seen[nr * m + nc] = true;
                        pq.offer(new int[] { grid[nr][nc], nr, nc });
                    }
                }
            }
            res[s[1]] = uf.size()[uf.find(root)] - 1;
        }
        return res;
    }
}
