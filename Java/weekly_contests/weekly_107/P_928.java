package weekly_contests.weekly_107;

import java.util.HashSet;
import java.util.Set;

import utils.DataStructures.UnionFind;

public class P_928 {

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int value : initial) {
            final UnionFind uf = new UnionFind(graph.length);
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[0].length; j++) {
                    if (i != value && j != value && graph[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }
            int totalInfected = 0;
            final Set<Integer> seen = new HashSet<>();
            for (int init : initial) {
                if (init != value) {
                    final int root = uf.find(init);
                    final int size = uf.size()[root];
                    if (!seen.contains(root)) {
                        seen.add(root);
                        totalInfected += size;
                    }
                }
            }
            if (totalInfected < min | (totalInfected == min && value < res)) {
                min = totalInfected;
                res = value;
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

