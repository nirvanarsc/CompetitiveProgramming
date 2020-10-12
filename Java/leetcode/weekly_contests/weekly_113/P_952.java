package leetcode.weekly_contests.weekly_113;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_952 {

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

    public int largestComponentSize(int[] A) {
        final Map<Integer, Integer> indices = new HashMap<>();
        final UnionFind uf = new UnionFind(A.length);
        for (int i = 0; i < A.length; i++) {
            final int limit = A[i];
            for (int p = 2; p * p <= limit; p++) {
                if (A[i] % p == 0) {
                    uf.union(i, indices.getOrDefault(p, i));
                    indices.put(p, i);
                    while (A[i] % p == 0) {
                        A[i] /= p;
                    }
                }
            }
            if (A[i] > 1) {
                uf.union(i, indices.getOrDefault(A[i], i));
                indices.put(A[i], i);
            }
        }
        int res = 0;
        for (int size : uf.size()) {
            res = Math.max(res, size);
        }
        return res;
    }
}
