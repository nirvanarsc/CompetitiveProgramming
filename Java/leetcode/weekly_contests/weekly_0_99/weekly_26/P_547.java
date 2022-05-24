package leetcode.weekly_contests.weekly_0_99.weekly_26;

import utils.DataStructures.UnionFind;

public class P_547 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int findCircleNum(int[][] M) {
        final int n = M.length;
        final UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }
}
