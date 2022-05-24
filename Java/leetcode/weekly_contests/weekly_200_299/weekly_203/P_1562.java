package leetcode.weekly_contests.weekly_200_299.weekly_203;

public class P_1562 {

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

        public void union(int p, int q, int[] counter, int m) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // union by size
            if (size[rootP] == m) {
                counter[0]--;
            }
            if (size[rootQ] == m) {
                counter[0]--;
            }
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
                size[rootQ] = 0;
                if (size[rootP] == m) {
                    counter[0]++;
                }
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
                size[rootP] = 0;
                if (size[rootQ] == m) {
                    counter[0]++;
                }
            }
            count--;
        }

        public void add(int idx, int[] counter, int m) {
            if (++size[idx] == m) {
                counter[0]++;
            }
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public int findLatestStep(int[] arr, int m) {
        final UnionFind uf = new UnionFind(arr.length);
        final int[] state = new int[arr.length];
        final int[] counter = { 0 };
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            final int idx = arr[i] - 1;
            uf.add(idx, counter, m);
            state[idx] = 1;
            if (idx > 0 && state[idx - 1] == 1) {
                uf.union(idx - 1, idx, counter, m);
            }
            if (idx + 1 < state.length && state[idx + 1] == 1) {
                uf.union(idx + 1, idx, counter, m);
            }
            if (counter[0] > 0) {
                res = i + 1;
            }
        }
        return res;
    }
}
