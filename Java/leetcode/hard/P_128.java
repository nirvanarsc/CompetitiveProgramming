package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class P_128 {

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

    public int longestConsecutive(int[] nums) {
        final Map<Integer, Integer> index = new HashMap<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }
        final UnionFind uf = new UnionFind(n);
        for (int num : nums) {
            final Integer l = index.get(num - 1);
            final Integer curr = index.get(num);
            final Integer r = index.get(num + 1);
            if (l != null) {
                uf.union(l, curr);
            }
            if (r != null) {
                uf.union(r, curr);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, uf.size[i]);
        }
        return res;
    }
}
