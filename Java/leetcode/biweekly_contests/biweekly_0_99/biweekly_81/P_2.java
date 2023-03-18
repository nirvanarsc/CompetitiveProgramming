package leetcode.biweekly_contests.biweekly_0_99.biweekly_81;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

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

    public long countPairs(int n, int[][] edges) {
        final UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        final int[] cc = new int[n];
        for (int i = 0; i < n; i++) {
            cc[uf.find(i)]++;
        }
        final List<Integer> list = new ArrayList<>();
        long s = 0;
        for (int i = 0; i < n; i++) {
            if (cc[i] > 0) {
                list.add(cc[i]);
                s += cc[i];
            }
        }
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            s -= list.get(i);
            res += (long) list.get(i) * s;
        }
        return res;
    }
}
