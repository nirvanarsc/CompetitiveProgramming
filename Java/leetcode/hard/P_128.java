package leetcode.hard;

import java.util.Arrays;
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

    public int longestConsecutiveMap(int[] nums) {
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

    public int longestConsecutive(int[] nums) {
        final int n = nums.length;
        final UnionFind uf = new UnionFind(n);
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            final int l = lowerBound(nums, nums[i] - 1);
            final int r = lowerBound(nums, nums[i] + 1);
            if (l != n && nums[l] == nums[i] - 1) {
                uf.union(l, i);
            }
            if (r != n && nums[r] == nums[i] + 1) {
                uf.union(r, i);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, uf.size[i]);
        }
        return res;
    }

    private static int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
