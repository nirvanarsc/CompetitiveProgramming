package leetcode.weekly_contests.weekly_300_399.weekly_345;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

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

    public int countCompleteComponents(int n, int[][] edges) {
        final boolean[][] g = new boolean[n][n];
        final UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            g[e[0]][e[1]] = true;
            g[e[1]][e[0]] = true;
            uf.union(e[0], e[1]);
        }
        final Map<Integer, List<Integer>> cc = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g[i][i] = true;
            cc.computeIfAbsent(uf.find(i), val -> new ArrayList<>()).add(i);
        }
        int res = 0;
        for (List<Integer> curr : cc.values()) {
            res += isComplete(curr, g);
        }
        return res;
    }

    private static int isComplete(List<Integer> curr, boolean[][] g) {
        for (int i : curr) {
            for (int j : curr) {
                if (!g[i][j] || !g[j][i]) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
