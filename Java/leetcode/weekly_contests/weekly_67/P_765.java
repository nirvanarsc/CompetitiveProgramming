package leetcode.weekly_contests.weekly_67;

import utils.DataStructures.UnionFind;

public class P_765 {

    public int minSwapsCouples(int[] row) {
        final int n = row.length / 2;
        final UnionFind uf = new UnionFind(n);
        for (int i = 0; i < row.length; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - uf.count();
    }
}
