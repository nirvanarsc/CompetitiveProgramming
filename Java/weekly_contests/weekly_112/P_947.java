package weekly_contests.weekly_112;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DataStructures.UnionFind;

public class P_947 {

    public int removeStones(int[][] stones) {
        final UnionFind uf = new UnionFind(stones.length);
        final Map<Integer, List<Integer>> cols = new HashMap<>();
        final Map<Integer, List<Integer>> rows = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            cols.computeIfAbsent(stones[i][0], v -> new ArrayList<>()).add(i);
            rows.computeIfAbsent(stones[i][1], v -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < stones.length; i++) {
            for (int row : rows.get(stones[i][1])) { uf.union(i, row); }
            for (int col : cols.get(stones[i][0])) { uf.union(i, col); }
        }
        return stones.length - uf.count();
    }
}
