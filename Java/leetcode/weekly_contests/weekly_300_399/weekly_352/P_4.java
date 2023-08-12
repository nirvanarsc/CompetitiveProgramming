package leetcode.weekly_contests.weekly_300_399.weekly_352;

import java.util.HashMap;
import java.util.Map;

public class P_4 {

    private static final class DynamicUnionFind {
        private final Map<Integer, Integer> parent;
        private final Map<Integer, Integer> size;
        int count;

        private DynamicUnionFind() {
            parent = new HashMap<>();
            size = new HashMap<>();
            count = 0;
        }

        public int find(int p) {
            // path compression
            while (p != parent.get(p)) {
                parent.put(p, parent.getOrDefault(parent.getOrDefault(p, p), p));
                p = parent.get(p);
            }
            return p;
        }

        public void union(int p, int q) {
            if (!hasKey(p) || !hasKey(q)) {
                return;
            }
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // union by size
            if (size.get(rootP) > size.get(rootQ)) {
                parent.put(rootQ, rootP);
                size.merge(rootP, size.get(rootQ), Integer::sum);
                size.put(rootQ, 0);
            } else {
                parent.put(rootP, rootQ);
                size.merge(rootQ, size.get(rootP), Integer::sum);
                size.put(rootP, 0);
            }
            count--;
        }

        public void add(int u) {
            if (hasKey(u)) {
                return;
            }
            parent.put(u, u);
            size.put(u, 1);
            count++;
        }

        public boolean hasKey(int v) {
            return parent.containsKey(v);
        }

        public int count() {
            return count;
        }
    }

    public int sumImbalanceNumbers(int[] nums) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            final DynamicUnionFind uf = new DynamicUnionFind();
            for (int j = i; j < n; j++) {
                uf.add(nums[j]);
                uf.union(nums[j], nums[j] - 1);
                uf.union(nums[j], nums[j] + 1);
                res += uf.count() - 1;
            }
        }
        return res;
    }
}
