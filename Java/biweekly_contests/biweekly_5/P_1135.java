package biweekly_contests.biweekly_5;

import java.util.Arrays;
import java.util.Comparator;

public class P_1135 {

    static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        UnionFind(int n) {
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
    }

    public int minimumCost(int n, int[][] connections) {
        int res = 0;
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        final UnionFind uf = new UnionFind(n);
        for (int[] c : connections) {
            if (uf.find(c[0] - 1) != uf.find(c[1] - 1)) {
                res += c[2];
                uf.union(c[0] - 1, c[1] - 1);
            }
        }
        return uf.count() == 1 ? res : -1;
    }
}
