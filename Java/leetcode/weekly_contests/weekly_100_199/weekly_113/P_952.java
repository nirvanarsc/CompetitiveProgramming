package leetcode.weekly_contests.weekly_100_199.weekly_113;

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

    public int largestComponentSize(int[] nums) {
        final UnionFind uf = new UnionFind((int) (1e5 + 5));
        for (int num : nums) {
            for (int p = 2; p * p <= num; p++) {
                if (num % p == 0) {
                    uf.union(p, num);
                    uf.union(num / p, num);
                }
            }
        }
        final int[] freq = new int[(int) (1e5 + 5)];
        int res = 0;
        for (int num : nums) {
            res = Math.max(res, ++freq[uf.find(num)]);
        }
        return res;
    }
}
