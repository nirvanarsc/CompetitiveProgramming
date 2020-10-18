package leetcode.weekly_contests.weekly_211;

import java.util.ArrayList;
import java.util.List;

public class P_1627 {

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

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        final UnionFind uf = new UnionFind(n + 1);
        for (int i = 1; i <= n; i++) {
            for (int p = 1; p * p <= i; p++) {
                if (i % p == 0) {
                    if (gcd(i, p) > threshold) { uf.union(i, p); }
                    if (gcd(i, i / p) > threshold) { uf.union(i, i / p); }
                }
            }
        }
        final List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(uf.find(q[0]) == uf.find(q[1]));
        }
        return res;
    }
}
