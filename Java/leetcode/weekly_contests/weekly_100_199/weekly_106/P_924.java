package leetcode.weekly_contests.weekly_100_199.weekly_106;

import java.util.Arrays;

public class P_924 {

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

    public int minMalwareSpread(int[][] graph, int[] initial) {
        final int n = graph.length;
        final UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        final int[] malCount = new int[n];
        for (int node : initial) {
            malCount[uf.find(node)]++;
        }
        Arrays.sort(initial);
        int res = initial[0];
        int max = 0;
        for (int node : initial) {
            final int idx = uf.find(node);
            if (malCount[idx] == 1 && uf.size()[idx] > max) {
                max = uf.size()[idx];
                res = node;
            } else if (uf.size()[idx] == max && res > node) {
                res = node;
            }
        }
        return res;
    }
}
