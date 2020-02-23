package weekly_177;

public class P_1361 {

    static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        UnionFind(int n) {
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
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        final UnionFind uf = new UnionFind(n);

        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) {
                if (uf.find(i) != uf.find(leftChild[i])) {
                    uf.union(i, leftChild[i]);
                } else {
                    return false;
                }
            }
        }

        for (int i = 0; i < rightChild.length; i++) {
            if (rightChild[i] != -1) {
                if (uf.find(i) != uf.find(rightChild[i])) {
                    uf.union(i, rightChild[i]);
                } else {
                    return false;
                }
            }
        }

        return uf.count() == 1;
    }
}
