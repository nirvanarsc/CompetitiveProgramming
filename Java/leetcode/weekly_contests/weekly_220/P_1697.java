package leetcode.weekly_contests.weekly_220;

import java.util.Arrays;
import java.util.Comparator;

public class P_1697 {

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

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        final int qLen = queries.length;
        final boolean[] res = new boolean[qLen];
        final int[][] indexedQueries = new int[qLen][4];
        for (int i = 0; i < qLen; i++) {
            indexedQueries[i] = new int[] { queries[i][0], queries[i][1], queries[i][2], i };
        }
        final UnionFind uf = new UnionFind(n);
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a[2]));
        int idx = 0;
        for (int[] query : indexedQueries) {
            final int p = query[0];
            final int q = query[1];
            final int limit = query[2];
            final int i = query[3];
            while (idx < edgeList.length && edgeList[idx][2] < limit) {
                uf.union(edgeList[idx][0], edgeList[idx][1]);
                idx++;
            }
            res[i] = uf.find(p) == uf.find(q);
        }
        return res;
    }
}
