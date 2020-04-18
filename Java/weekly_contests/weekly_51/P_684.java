package weekly_contests.weekly_51;

import utils.DataStructures.UnionFind;

public class P_684 {

    @SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
    public int[] findRedundantConnection(int[][] edges) {
        final UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] e : edges) {
            if (uf.find(e[0]) != uf.find(e[1])) {
                uf.union(e[0], e[1]);
            } else {
                return e;
            }
        }
        return null;
    }
}
