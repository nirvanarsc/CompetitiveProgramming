package hard;

import java.util.ArrayList;
import java.util.List;

public class P_305 {

    private static final class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        private UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
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

        public int getParent(int idx) {
            return parent[idx];
        }

        public void add(int index) {
            if (parent[index] != index) {
                parent[index] = index;
                size[index] = 1;
                count++;
            }
        }
    }

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        final UnionFind uf = new UnionFind(n * m + 1);
        final List<Integer> res = new ArrayList<>();
        for (int[] pos : positions) {
            final int p = n * pos[0] + pos[1] + 1;
            uf.add(p);
            for (int[] dir : DIRS) {
                final int nx = pos[0] + dir[0];
                final int ny = pos[1] + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    final int q = uf.getParent(n * nx + ny + 1);
                    if (q > 0 && uf.find(p) != uf.find(q)) {
                        uf.union(p, q);
                    }
                }
            }
            res.add(uf.count());
        }
        return res;
    }
}
