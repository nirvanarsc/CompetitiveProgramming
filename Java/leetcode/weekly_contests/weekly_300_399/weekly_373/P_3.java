package leetcode.weekly_contests.weekly_300_399.weekly_373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

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

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        final int n = nums.length;
        final UnionFind uf = new UnionFind(n);
        final int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[] { nums[i], i };
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n - 1; i++) {
            if (sorted[i + 1][0] - sorted[i][0] <= limit) {
                uf.union(sorted[i + 1][1], sorted[i][1]);
            }
        }
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(uf.find(i), val -> new ArrayList<>()).add(nums[i]);
        }
        for (List<Integer> v : g.values()) {
            v.sort(Comparator.reverseOrder());
        }
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            final List<Integer> v = g.get(uf.find(i));
            res[i] = v.remove(v.size() - 1);
        }
        return res;
    }
}
