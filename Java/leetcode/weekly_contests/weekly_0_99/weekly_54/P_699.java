package leetcode.weekly_contests.weekly_0_99.weekly_54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import utils.IntervalSegmentTree;

public class P_699 {

    public List<Integer> fallingSquares(int[][] positions) {
        final List<Integer> res = new ArrayList<>();
        final TreeMap<Integer, Integer> startHeight = new TreeMap<>(Collections.singletonMap(0, 0));
        int max = 0;
        for (int[] pos : positions) {
            final int start = pos[0];
            final int end = start + pos[1];
            final Integer from = startHeight.floorKey(start);
            final int height = startHeight.subMap(from, end)
                                          .values()
                                          .stream()
                                          .max(Integer::compare).get() + pos[1];
            max = Math.max(height, max);
            res.add(max);
            // remove interval within [start, end)
            final int lastHeight = startHeight.floorEntry(end).getValue();
            startHeight.put(start, height);
            startHeight.put(end, lastHeight);
            startHeight.subMap(start, false, end, false).clear();
        }
        return res;
    }

    public List<Integer> fallingSquaresST(int[][] positions) {
        final Set<Integer> coords = new HashSet<>();
        for (int[] pos : positions) {
            coords.add(pos[0]);
            coords.add(pos[0] + pos[1] - 1);
        }
        final List<Integer> sortedCoords = new ArrayList<>(coords);
        Collections.sort(sortedCoords);

        final Map<Integer, Integer> index = new HashMap<>();
        int t = 0;
        for (int coord : sortedCoords) {
            index.put(coord, t++);
        }

        final IntervalSegmentTree tree = new IntervalSegmentTree(0, (int) 1e9, 0, "MAX");
        int best = 0;
        final List<Integer> ans = new ArrayList<>();

        for (int[] pos : positions) {
            final int L = index.get(pos[0]);
            final int R = index.get(pos[0] + pos[1] - 1);
            final int h = tree.query(tree, L, R) + pos[1];
            tree.update(tree, L, R, h);
            best = Math.max(best, h);
            ans.add(best);
        }
        return ans;
    }
}
