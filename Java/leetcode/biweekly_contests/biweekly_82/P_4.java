package leetcode.biweekly_contests.biweekly_82;

import java.util.Arrays;

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

    public int validSubarraySize(int[] nums, int threshold) {
        final int n = nums.length;
        final int[][] indexed = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexed[i] = new int[] { nums[i], i };
        }
        Arrays.sort(indexed, (a, b) -> Integer.compare(b[0], a[0]));
        final UnionFind uf = new UnionFind(n);
        for (int[] p : indexed) {
            final int u = p[0];
            final int idx = p[1];
            if (idx > 0 && nums[idx - 1] >= u) {
                uf.union(idx, idx - 1);
            }
            if (idx < (n - 1) && nums[idx + 1] >= u) {
                uf.union(idx, idx + 1);
            }
            final int par = uf.find(idx);
            if (threshold / uf.size[par] < u) {
                return uf.size[par];
            }
        }
        return -1;
    }
}
