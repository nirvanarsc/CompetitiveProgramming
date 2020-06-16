package hard;

import java.util.ArrayList;
import java.util.List;

public class P_305 {

    public static class UnionFind2D {
        private final int[] parent;
        private final int[] size;
        private final int row;
        private final int col;
        private int count;

        public UnionFind2D(int row, int col) {
            this.row = row;
            this.col = col;
            count = 0;
            parent = new int[row * col + 1];
            size = new int[row * col + 1];
        }

        public int index(int x, int y) { return x * col + y + 1; }

        public int count() { return count; }

        public int getID(int x, int y) {
            if (0 <= x && x < row && 0 <= y && y < col) {
                return parent[index(x, y)];
            }
            return 0;
        }

        public void add(int index) {
            if (parent[index] != index) {
                parent[index] = index;
                size[index] = 1;
                ++count;
            }
        }

        public boolean find(int p, int q) {
            return find(p) == find(q);
        }

        public void unite(int p, int q) {
            final int i = find(p);
            final int j = find(q);
            if (i != j) {
                if (size[i] < size[j]) {
                    parent[i] = j;
                    size[j] += size[i];
                } else {
                    parent[j] = i;
                    size[i] += size[j];
                }
                --count;
            }
        }

        private int find(int p) {
            // path compression
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
    }

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        final UnionFind2D uf = new UnionFind2D(m, n);
        final List<Integer> ans = new ArrayList<>();
        for (int[] position : positions) {
            final int x = position[0];
            final int y = position[1];
            final int p = uf.index(x, y);
            uf.add(p);
            for (int[] dir : DIRS) {
                final int q = uf.getID(x + dir[0], y + dir[1]);
                if (q > 0 && !uf.find(p, q)) {
                    uf.unite(p, q);
                }
            }
            ans.add(uf.count());
        }
        return ans;
    }
}
