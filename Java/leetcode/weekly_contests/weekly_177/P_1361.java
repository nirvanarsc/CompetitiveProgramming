package leetcode.weekly_contests.weekly_177;

public class P_1361 {

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

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        final UnionFind uf = new UnionFind(n);
        final int[] inDeg = new int[n];
        for (int i = 0; i < leftChild.length; i++) {
            final int u = leftChild[i];
            if (u != -1) {
                inDeg[u]++;
                uf.union(i, u);
            }
        }
        for (int i = 0; i < rightChild.length; i++) {
            final int u = rightChild[i];
            if (u != -1) {
                inDeg[u]++;
                uf.union(i, u);
            }
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                root++;
            } else if (inDeg[i] > 1) {
                return false;
            }
        }
        return root == 1 && uf.count() == 1;
    }
}
