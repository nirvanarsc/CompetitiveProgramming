package weekly_contests.weekly_205;

import java.util.Arrays;

public class P_1579 {

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

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        final UnionFind alice = new UnionFind(n);
        final UnionFind bob = new UnionFind(n);
        int needed = 0;
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        for (int[] e : edges) {
            if (e[0] == 1) {
                needed += union(alice, e) ? 1 : 0;
            } else if (e[0] == 2) {
                needed += union(bob, e) ? 1 : 0;
            } else {
                needed += (union(alice, e) | union(bob, e)) ? 1 : 0;
            }
        }
        if (alice.count() > 1 || bob.count() > 1) {
            return -1;
        }
        return edges.length - needed;
    }

    private static boolean union(UnionFind uf, int[] e) {
        if (uf.find(e[1] - 1) != uf.find(e[2] - 1)) {
            uf.union(e[1] - 1, e[2] - 1);
            return true;
        }
        return false;
    }
}
