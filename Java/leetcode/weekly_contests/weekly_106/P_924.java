package leetcode.weekly_contests.weekly_106;

import utils.DataStructures.UnionFind;

public class P_924 {

    public int minMalwareSpread(int[][] graph, int[] initial) {
        final UnionFind uf = new UnionFind(graph.length);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int init : initial) {
            final int root = uf.find(init);
            final int size = uf.size()[root];
            if (size > max | (size == max && init < res)) {
                max = size;
                res = init;
            }
        }
        return res;
    }
}
