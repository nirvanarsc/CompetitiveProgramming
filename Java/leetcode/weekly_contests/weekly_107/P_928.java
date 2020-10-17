package leetcode.weekly_contests.weekly_107;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_928 {

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
        Arrays.sort(initial);
        int min = (int) 1e9;
        int res = -1;
        for (int banned : initial) {
            final int n = graph.length;
            final UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (i != banned && j != banned && graph[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }
            int curr = 0;
            final boolean[] counted = new boolean[n];
            for (int infected : initial) {
                if (infected != banned) {
                    final int par = uf.find(infected);
                    if (!counted[par]) {
                        curr += uf.size()[par];
                        counted[par] = true;
                    }
                }
            }
            if (min > curr) {
                min = curr;
                res = banned;
            }
        }
        return res;
    }

    public int minMalwareSpreadDFS(int[][] graph, int[] initial) {
        int min = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < initial.length; ++i) {
            final Set<Integer> infected = new HashSet<>();
            for (int j = 0; j < initial.length; ++j) {
                if (i != j) {
                    dfs(graph, infected, initial[j], initial[i]);
                }
            }
            if (infected.size() < min | (infected.size() == min && initial[i] < res)) {
                min = infected.size();
                res = initial[i];
            }
        }

        return res;
    }

    private static void dfs(int[][] graph, Set<Integer> infected, int curr, int removed) {
        if (!infected.contains(curr) && curr != removed) {
            infected.add(curr);
            for (int j = 0; j < graph[curr].length; ++j) {
                if (graph[curr][j] == 1) {
                    dfs(graph, infected, j, removed);
                }
            }
        }
    }
}

